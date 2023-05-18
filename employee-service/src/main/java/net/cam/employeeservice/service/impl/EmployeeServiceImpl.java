package net.cam.employeeservice.service.impl;

import lombok.RequiredArgsConstructor;
import net.cam.employeeservice.exception.ResourceNotFoundException;
import net.cam.employeeservice.mapper.EmployeeMapper;
import net.cam.employeeservice.dto.EmployeeDto;
import net.cam.employeeservice.entity.Employee;
import net.cam.employeeservice.repository.EmployeeRepository;
import net.cam.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);
        return EmployeeMapper.MAPPER.mapToEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        return EmployeeMapper.MAPPER.mapToEmployeeDto(employeeRepository
                .findById(employeeId)
                .orElseThrow(() ->new ResourceNotFoundException("Employee", "employeeId", employeeId.toString())));
    }
}
