package net.cam.employeeservice.service;

import net.cam.employeeservice.dto.ApiResponseDto;
import net.cam.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployeeById(Long employeeId);

}
