package net.cam.employeeservice.controller;

import lombok.RequiredArgsConstructor;
import net.cam.employeeservice.dto.ApiResponseDto;
import net.cam.employeeservice.dto.EmployeeDto;
import net.cam.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    //Save Employee REST API
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.saveEmployee(employeeDto);
    }

    //Get Employee By Id REST API
    @GetMapping("{id}")
    public ApiResponseDto getEmployeeById(@PathVariable("id") Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

}
