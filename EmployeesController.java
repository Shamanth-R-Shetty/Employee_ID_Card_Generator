package com.boostmytool.bestemp;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    private EmployeesRepository repo;

    @GetMapping({"","/"})
    public String showEmployeeList(Model model){
        List<Employee> employees = repo.findAll();
        model.addAttribute("employees",employees);
        return "employees/index";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("employeeDto", employeeDto);
        return "employees/CreateEmployee";
    }

    @PostMapping("/create")
    public String createEmployee(
        @Valid @ModelAttribute EmployeeDto employeeDto,
        BindingResult result
        ){
            if(employeeDto.getImageFile().isEmpty()){
                result.addError(new FieldError("employeeDto", "imageFile", "The image file is required"));
            }
            if(result.hasErrors()){
                return "employees/CreateEmployee";
            }

            MultipartFile image=employeeDto.getImageFile();
            Date joinedAt = new Date();
            String storageFileName = joinedAt.getTime() + "_" + image.getOriginalFilename();

            try{
                String uploadDir="public/Images/";
                Path uploadPath= Paths.get(uploadDir);

                if(!Files.exists(uploadPath)){
                Files.createDirectories(uploadPath);
                 }
            try (InputStream  inputStream = image.getInputStream()){
                Files.copy(inputStream,Paths.get(uploadDir + storageFileName),StandardCopyOption.REPLACE_EXISTING);
               }
                
            } catch (Exception ex) {
              System.out.println("Exception: "+ex.getMessage());
            }
            
            Employee employee=new Employee();
            employee.setName(employeeDto.getName());
            employee.setCity(employeeDto.getCity());
            employee.setDesignation(employeeDto.getDesignation());
            employee.setSalary(employeeDto.getSalary());
            employee.setAbout(employeeDto.getAbout());
            employee.setJoinedAt(joinedAt);
            employee.setImageFileName(storageFileName);

            repo.save(employee);

            return "redirect:/employees";
            }

            @GetMapping("/edit")
            public String showEditPage(Model model,@RequestParam int id) {
                
                try{
                    Employee employee = repo.findById(id).get();
                    model.addAttribute("employee", employee);

                    EmployeeDto employeeDto=new EmployeeDto();
                    employeeDto.setName(employee.getName());
                    employeeDto.setCity(employee.getCity());
                    employeeDto.setDesignation(employee.getDesignation());
                    employeeDto.setSalary(employee.getSalary());
                    employeeDto.setAbout(employee.getAbout());

                    model.addAttribute("employeeDto", employeeDto);
                }
                catch(Exception ex){
                    System.out.println("Exception:"+ex.getMessage());
                    return "redirect:/employees";
                }
                
                return "employees/EditEmployee" ;
            }


            @PostMapping("/edit")
            public String updateEmployee(Model model,
            @RequestParam int id,
            @Valid @ModelAttribute EmployeeDto employeeDto,
            BindingResult result){
                try{
                    Employee employee = repo.findById(id).get();
                    model.addAttribute("employee", employee);

                    if(result.hasErrors())
                    {
                        return "employees/EditEmployee";
                    }

                    if(!employeeDto.getImageFile().isEmpty()){
                        String uploadDir = "public/Images/";
                        Path oldImagePath = Paths.get(uploadDir + employee.getImageFileName());

                        try{
                            Files.delete(oldImagePath);
                        }
                        catch (Exception ex){
                            System.out.println("Exception:" + ex.getMessage());
                        }
                        MultipartFile image=employeeDto.getImageFile();
                        Date joinedAt = new Date();
                        String storageFileName = joinedAt.getTime() + "_" + image.getOriginalFilename();
                        
                        try (InputStream  inputStream = image.getInputStream()){
                            Files.copy(inputStream,Paths.get(uploadDir + storageFileName),StandardCopyOption.REPLACE_EXISTING);
                           }
                      employee.setImageFileName(storageFileName);
                    }
                    employee.setName(employeeDto.getName());
                    employee.setCity(employeeDto.getCity());
                    employee.setDesignation(employeeDto.getDesignation());
                    employee.setSalary(employeeDto.getSalary());
                    employee.setAbout(employeeDto.getAbout());

                    repo.save(employee);
                }
                catch(Exception ex){
                    System.out.println("Exception:"+ex.getMessage());
                }

                return "redirect:/employees";
            }

            @GetMapping("/delete")
            public String deleteEmployee(
                @RequestParam int id )
                {

                    try{
                        Employee employee = repo.findById(id).get();

                        Path imagePath = Paths.get("public/Images/" + employee.getImageFileName());
                    try{
                        Files.delete(imagePath);
                    }
                    catch(Exception ex){
                        System.out.println("Exception :"+ex.getMessage());
                    }
                    repo.delete(employee);
                    
                    }
                    catch(Exception ex){
                        System.out.println("Exception :" +ex.getMessage());
                    }
                    return "redirect:/employees";
            }
            
            
    
}
