package services;

import dtos.EmployeeDto;

import java.util.List;

public interface EmployeeServiceImpl {
    EmployeeDto createEmployee(EmployeeDto employee);
    List<EmployeeDto> findAll();
    EmployeeDto findById(Long id);
    EmployeeDto updateById(Long id, EmployeeDto employee);
    List<EmployeeDto> findByDepartmentId(Long id);
    List<EmployeeDto> findByOfficeId(Long id);
    void deleteAll();
    void deleteById(Long id);
    void deleteByDepartmentId(Long id);
    void deleteByOfficeId(Long id);
}
