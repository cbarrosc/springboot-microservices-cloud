package net.cam.departmentservice.controller;

import lombok.RequiredArgsConstructor;
import net.cam.departmentservice.dto.DepartmentDto;
import net.cam.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    //Save Department REST API
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public DepartmentDto saveDepartment(@RequestBody DepartmentDto departmentDto) {
        return departmentService.saveDepartment(departmentDto);
    }

    //Find department by code REST API
    @GetMapping("/{department-code}")
    public DepartmentDto findDepartmentByCode(@PathVariable("department-code") String code) {
        return departmentService.getDepartmentByCode(code);
    }

}
