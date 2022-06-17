import consts.CompanyConst;
import consts.DepartmentConst;
import consts.OfficeConst;
import controllers.CompanyController;
import dtos.CompanyDto;
import org.junit.Test;
import services.CompanyService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmployeeTest {
    private final CompanyController companyController;

    public EmployeeTest() {
        CompanyService companyService = new CompanyService();
        companyController = new CompanyController(companyService);
    }

    public CompanyDto mockDataCompany() {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(1L);
        companyDto.setCompanyName(CompanyConst.GREEK_TECHNOLOGY);

        List<CompanyDto.OfficeDto> officeDtos = new ArrayList<>();
        IntStream.range(0, 2)
                .forEach(i -> {
                    List<CompanyDto.DepartmentDto> departmentDtos = new ArrayList<>();
                    IntStream.range(0, 2)
                            .forEach(x -> {
                                CompanyDto.DepartmentDto departmentDto = new CompanyDto.DepartmentDto();
                                departmentDto.setId((long) (x + 1));
                                departmentDto.setDepartmentName(x != 0 ? DepartmentConst.ZEUS : DepartmentConst.ATHENA);

                                departmentDtos.add(departmentDto);
                            });

                    CompanyDto.OfficeDto officeDto = new CompanyDto.OfficeDto();
                    officeDto.setId((long) (i + 1));
                    officeDto.setOfficeName(i != 0 ? OfficeConst.KUBERNETES_CAMPUS : OfficeConst.DOCKER_CAMPUS);
                    officeDto.setDepartmentDtos(departmentDtos);

                    officeDtos.add(officeDto);
                });
        companyDto.setOffices(officeDtos);

        return companyDto;
    }

    public CompanyDto.EmployeeDto mockDataEmployee() {
        CompanyDto.EmployeeDto employeeDto = new CompanyDto.EmployeeDto();
        employeeDto.setTitleName("Mr");
        employeeDto.setFirstName("Test");
        employeeDto.setSurName("Test Test");
        employeeDto.setAge(20);

        CompanyDto.OfficeDto officeDto = new CompanyDto.OfficeDto();
        officeDto.setId(1L);
        officeDto.setOfficeName(OfficeConst.KUBERNETES_CAMPUS);

        CompanyDto.DepartmentDto departmentDto = new CompanyDto.DepartmentDto();
        departmentDto.setId(1L);
        departmentDto.setDepartmentName(DepartmentConst.ZEUS);

        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(1L);
        companyDto.setCompanyName(CompanyConst.GREEK_TECHNOLOGY);

        employeeDto.setCompany(companyDto);
        employeeDto.setOffice(officeDto);
        employeeDto.setDepartment(departmentDto);

        return employeeDto;
    }

    @Test
    public void createCompany() {
        CompanyDto companyDto = mockDataCompany();

        CompanyDto response = companyController.createCompany(companyDto);

        Long number = response.getOffices()
                .stream()
                .map(CompanyDto.OfficeDto::getDepartmentDtos)
                .mapToLong(Collection::size)
                .sum();

        assertEquals(2, response.getOffices().size());
        assertEquals(Long.valueOf(4), number);
    }

    @Test
    public void createEmployee() {
        CompanyDto companyDto = mockDataCompany();
        companyController.createCompany(companyDto);

        List<CompanyDto.AddressDto> addressDtos = new ArrayList<>();
        IntStream.range(0, 2)
                .forEach(x -> {
                    CompanyDto.AddressDto addressDto = new CompanyDto.AddressDto();
                    addressDto.setAddress("111");
                    addressDto.setCity("Thai");
                    addressDto.setCountry("Thailand");
                    addressDto.setPostcode("11111");

                    addressDtos.add(addressDto);
                });

        CompanyDto.OfficeDto officeDto = new CompanyDto.OfficeDto();
        officeDto.setId(1L);

        CompanyDto.DepartmentDto departmentDto = new CompanyDto.DepartmentDto();
        departmentDto.setId(1L);

        CompanyDto.EmployeeDto employeeDto = new CompanyDto.EmployeeDto();
        employeeDto.setTitleName("Mr");
        employeeDto.setFirstName("World Wide Web");
        employeeDto.setSurName("WWW");
        employeeDto.setAge(25);
        employeeDto.setAddresses(addressDtos);
        employeeDto.setOffice(officeDto);
        employeeDto.setDepartment(departmentDto);

        CompanyDto.EmployeeDto response = companyController.createEmployee(employeeDto);

        assertTrue(Objects.nonNull(response.getId()));
        assertEquals(OfficeConst.DOCKER_CAMPUS, response.getOffice().getOfficeName());
        assertEquals(DepartmentConst.ATHENA, response.getDepartment().getDepartmentName());
    }

    @Test
    public void findAllEmployee() {
        CompanyDto companyDto = mockDataCompany();
        companyController.createCompany(companyDto);

        CompanyDto.EmployeeDto employeeDto = mockDataEmployee();
        IntStream.range(0, 10)
                .forEach(i -> {
                    companyController.createEmployee(employeeDto);
                });

        List<CompanyDto.EmployeeDto> employeeDtos = companyController.findAllEmployee();

        assertEquals(10, employeeDtos.size());
    }

    @Test
    public void findEmployeeById() {
        CompanyDto.EmployeeDto employeeDto = mockDataEmployee();
        CompanyDto companyDto = mockDataCompany();

        companyController.createCompany(companyDto);
        List<Long> id = new ArrayList<>();
        IntStream.range(0, 5)
                .forEach(i -> {
                    CompanyDto.EmployeeDto response = companyController.createEmployee(employeeDto);

                    id.add(response.getId());
                });

        AtomicInteger sum = new AtomicInteger(0);
        id.stream().forEach(idR -> {
            CompanyDto.EmployeeDto response = companyController.findEmployeeById(idR);

            if(Objects.nonNull(response.getId()))
                sum.getAndIncrement();
        });

        assertEquals(5, sum.get());
    }
}
