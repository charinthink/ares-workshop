package services;

import entityes.Employee;

import java.util.List;

public interface EmployeeServiceImpl {
    Employee createEmployee(Employee employee);
    List<Employee> findAll();
    Employee findById(Long id);
    Employee updateById(Long id, Employee employee);
    List<Employee> findByDepartmentId(Long id);
    List<Employee> findByOfficeId(Long id);
    void deleteAll();
    void deleteById(Long id);
    void deleteByDepartmentId(Long id);
    void deleteByOfficeId(Long id);
}
