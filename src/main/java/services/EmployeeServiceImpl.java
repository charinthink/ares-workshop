package services;

import dtos.EmployeeRequestDto;
import dtos.EmployeeResponseDto;
import entityes.Employee;

import java.util.List;

public interface EmployeeServiceImpl {
    EmployeeResponseDto createEmployee(EmployeeRequestDto employee);
    List<EmployeeResponseDto> findAll();
    EmployeeResponseDto findById(Long id);
    EmployeeResponseDto updateById(Long id, EmployeeRequestDto employee);
    List<EmployeeResponseDto> findByDepartmentId(Long id);
    List<EmployeeResponseDto> findByOfficeId(Long id);
    void deleteAll();
    void deleteById(Long id);
    void deleteByDepartmentId(Long id);
    void deleteByOfficeId(Long id);
}
