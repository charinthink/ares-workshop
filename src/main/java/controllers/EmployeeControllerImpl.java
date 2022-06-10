package controllers;

import dtos.EmployeeDto;

import java.util.List;

public interface EmployeeControllerImpl {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);

    List<EmployeeDto> findAll();

    EmployeeDto findById(Long id);

    EmployeeDto updateById(Long id, EmployeeDto employeeDto);

    List<EmployeeDto> findByDepartmentId(Long id);

    List<EmployeeDto> findByOfficeId(Long id);

    void deleteAll();

    void deleteById(Long id);

    void deleteByDepartmentId(Long id);

    void deleteByOfficeId(Long id);
}
