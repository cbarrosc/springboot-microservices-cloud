package net.cam.employeeservice.service.impl;

import lombok.RequiredArgsConstructor;
import net.cam.employeeservice.dto.ApiResponseDto;
import net.cam.employeeservice.dto.DepartmentDto;
import net.cam.employeeservice.dto.EmployeeDto;
import net.cam.employeeservice.entity.Employee;
import net.cam.employeeservice.exception.ResourceNotFoundException;
import net.cam.employeeservice.mapper.EmployeeMapper;
import net.cam.employeeservice.repository.EmployeeRepository;
import net.cam.employeeservice.service.APIClient;
import net.cam.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  /**  public static final String URL = "http://localhost:8080/api/departments/";
    private final RestTemplate restTemplate;
    private final WebClient webClient;*/
    private final EmployeeRepository employeeRepository;
    private final APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);
        return EmployeeMapper.MAPPER.mapToEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "employeeId", employeeId.toString()));

        DepartmentDto department = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        return new ApiResponseDto(
                EmployeeMapper.MAPPER.mapToEmployeeDto(employee),
                department
        );
    }


    /**
     * The following two methods are equivalents, and they're a prof of concepts of different approach's
     * to achieve a HTTP REST call within Spring Boot*/
   /** private DepartmentDto getDepartmentWebClient(Employee employee) {
        return webClient.get()
                .uri(URL + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
    }

    private DepartmentDto getDepartmentRestTemplate(Employee employee) {
        return restTemplate.getForEntity(
                        URL + employee.getDepartmentCode(),
                        DepartmentDto.class)
                .getBody();
    }*/
}
