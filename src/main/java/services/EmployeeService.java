package services;

import dtos.EmployeeDto;
import entityes.*;
import util.DtoMapper;
import util.EntityMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static db_on_memory.DB.*;

public class EmployeeService implements EmployeeServiceImpl {
    @Override
    public EmployeeDto createEmployee(EmployeeDto employee) {
        Long id = (long) (Math.random() * 10);

        Employee employeeNew = EntityMapper.toEmployee(employee);
        employeeNew.setId(id);

        List<Address> addressNew = employee.getAddresses()
                .stream()
                .map(EntityMapper::toAddress)
                .collect(Collectors.toList());
        employeeNew.setAddress(addressNew);

        Department departmentNew = EntityMapper.toDepartment(employee.getCompany().getOffice().getDepartment());
        departmentNew.setId(id);

        Office officeNew = EntityMapper.toOffice(employee.getCompany().getOffice());
        officeNew.setId(id);
        officeNew.setDepartment(departmentNew);

        Company companyNew = EntityMapper.toCompany(employee.getCompany());
        companyNew.setId(id);
        companyNew.setOffice(officeNew);

        employeeNew.setCompany(companyNew);

        /* Save */
        DB.add(employeeNew);

        EmployeeDto employeeResponseDto = DtoMapper.toEmployeeDto(employeeNew);

        List<EmployeeDto.Address> addressesResponseDto = addressNew.stream()
                .map(DtoMapper::toAddressDto)
                .collect(Collectors.toList());
        employeeResponseDto.setAddresses(addressesResponseDto);

        EmployeeDto.Department departmentResponseDto = DtoMapper.toDepartmentDto(departmentNew);

        EmployeeDto.Office officeResponseDto = DtoMapper.toOfficeDto(officeNew);
        officeResponseDto.setDepartment(departmentResponseDto);

        EmployeeDto.Company companyResponseDto = DtoMapper.toCompanyDto(companyNew);
        companyResponseDto.setOffice(officeResponseDto);

        employeeResponseDto.setCompany(companyResponseDto);

        return employeeResponseDto;
    }

    @Override
    public List<EmployeeDto> findAll() {
        List<EmployeeDto> employeeResponseDtos = new ArrayList<>();
        DB.stream()
                .forEach(em -> {
                    EmployeeDto employeeResponseDto = DtoMapper.toEmployeeDto(em);

                    List<EmployeeDto.Address> addressesResponseDto = em.getAddress()
                            .stream()
                            .map(DtoMapper::toAddressDto)
                            .collect(Collectors.toList());

                    EmployeeDto.Department departmentResponseDto = DtoMapper.toDepartmentDto(em.getCompany().getOffice().getDepartment());

                    EmployeeDto.Office officeResponseDto = DtoMapper.toOfficeDto(em.getCompany().getOffice());
                    officeResponseDto.setDepartment(departmentResponseDto);

                    EmployeeDto.Company companyResponseDto = DtoMapper.toCompanyDto(em.getCompany());
                    companyResponseDto.setOffice(officeResponseDto);

                    employeeResponseDto.setCompany(companyResponseDto);
                    employeeResponseDtos.add(employeeResponseDto);
                });

        return employeeResponseDtos;
    }

    @Override
    public EmployeeDto findById(Long id) {
        Employee employee = DB.stream()
                .filter(em -> em.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (Objects.nonNull(employee)) {
            EmployeeDto employeeResponseDto = DtoMapper.toEmployeeDto(employee);

            List<EmployeeDto.Address> addressesResponseDto = employee.getAddress()
                    .stream()
                    .map(DtoMapper::toAddressDto)
                    .collect(Collectors.toList());

            EmployeeDto.Department departmentResponseDto = DtoMapper.toDepartmentDto(employee.getCompany().getOffice().getDepartment());

            EmployeeDto.Office officeResponseDto = DtoMapper.toOfficeDto(employee.getCompany().getOffice());
            officeResponseDto.setDepartment(departmentResponseDto);

            EmployeeDto.Company companyResponseDto = DtoMapper.toCompanyDto(employee.getCompany());
            companyResponseDto.setOffice(officeResponseDto);

            employeeResponseDto.setCompany(companyResponseDto);

            return employeeResponseDto;
        }

        return null;
    }

    @Override
    public EmployeeDto updateById(Long id, EmployeeDto employee) {
        Employee employeeDb = DB.stream()
                .filter(em -> em.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (Objects.nonNull(employeeDb)) {
            employeeDb.setOld(employee.getOld());
            employeeDb.setTitleName(employee.getTitleName());
            employeeDb.setFirstName(employee.getFirstName());
            employeeDb.setSurName(employee.getSurName());

            List<Address> addresses = employeeDb.getAddress();
            employee.getAddresses()
                    .stream().forEach(addr -> {
//                        addresses.stream().filter(addrDb -> addrDb.getId().equals(addr.getId()));
                    });
        }
        return null;
    }

    @Override
    public List<EmployeeDto> findByDepartmentId(Long id) {
        return null;
    }

    @Override
    public List<EmployeeDto> findByOfficeId(Long id) {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteByDepartmentId(Long id) {

    }

    @Override
    public void deleteByOfficeId(Long id) {

    }
}
