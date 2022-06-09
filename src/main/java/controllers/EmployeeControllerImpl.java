package controllers;

import dtos.EmployeeRequestDto;
import dtos.EmployeeResponseDto;

import java.util.List;

public interface EmployeeControllerImpl {
    EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto employeeRequestDto);
    List<EmployeeResponseDto> findAll();
    EmployeeResponseDto findById(Long id);
    EmployeeResponseDto updateById(Long id, EmployeeRequestDto employeeRequestDto);
    List<EmployeeResponseDto> findByDepartmentId(Long id);
    List<EmployeeResponseDto> findByOfficeId(Long id);
    void deleteAll();
    void deleteById(Long id);
    void deleteByDepartmentId(Long id);
    void deleteByOfficeId(Long id);
}
