package net.cam.employeeservice.dto;

public record EmployeeDto(
    Long id,
    String firstName,
    String lastName,
    String email,
    String departmentCode
) {
}
