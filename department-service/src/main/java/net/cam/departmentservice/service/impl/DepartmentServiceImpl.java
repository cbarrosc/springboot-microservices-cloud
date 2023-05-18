package net.cam.departmentservice.service.impl;

import lombok.RequiredArgsConstructor;
import net.cam.departmentservice.dto.DepartmentDto;
import net.cam.departmentservice.entity.Department;
import net.cam.departmentservice.mapper.DepartmentMapper;
import net.cam.departmentservice.repository.DepartmentRepository;
import net.cam.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.MAPPER.mapToDepartment(departmentDto);
        return DepartmentMapper.MAPPER.mapToDepartmentDto(departmentRepository.save(department));
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        return DepartmentMapper.MAPPER.mapToDepartmentDto(departmentRepository.findByDepartmentCode(departmentCode));
    }
}
