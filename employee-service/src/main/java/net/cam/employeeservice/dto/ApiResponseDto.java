package net.cam.employeeservice.dto;

public record ApiResponseDto(
        EmployeeDto employeeDto,
        DepartmentDto departmentDto
) {
}
