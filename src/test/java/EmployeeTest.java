import consts.CompanyConst;
import consts.DepartmentConst;
import consts.OfficeConst;
import controllers.EmployeeController;
import dtos.EmployeeDto;
import org.junit.Test;
import services.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmployeeTest {
    private final EmployeeController employeeController;

    public EmployeeTest() {
        EmployeeService employeeService = new EmployeeService();
        employeeController = new EmployeeController(employeeService);
    }

    public EmployeeDto mockData() {
        EmployeeDto requestDto = new EmployeeDto();
        requestDto.setTitleName("Mr");
        requestDto.setFirstName("Demo");
        requestDto.setSurName("Demo");
        requestDto.setOld(25);

        List<EmployeeDto.Address> addresses = new ArrayList<>();
        EmployeeDto.Address address = new EmployeeDto.Address();
        address.setAddress("111 m.8");
        address.setCity("Moeng");
        address.setCountry("Thailand");
        address.setPostcode("21000");
        addresses.add(address);
        requestDto.setAddresses(addresses);

        EmployeeDto.Department department = new EmployeeDto.Department();
        department.setDepartmentName(DepartmentConst.ATHENA);

        EmployeeDto.Office office = new EmployeeDto.Office();
        office.setOfficeName(OfficeConst.KUBERNETES_CAMPUS);
        office.setDepartment(department);

        EmployeeDto.Company company = new EmployeeDto.Company();
        company.setCompanyConst(CompanyConst.GREEK_TECHNOLOGY);
        company.setOffice(office);

        requestDto.setCompany(company);

        return requestDto;
    }

    @Test
    public void createEmployee() {
        EmployeeDto data = mockData();

        EmployeeDto response = employeeController.createEmployee(data);
        assertTrue(Objects.nonNull(response.getId()));
        assertEquals(response.getFirstName(), "Demo");
        assertEquals(response.getSurName(), "Demo");
    }

    @Test
    public void createEmployeeMultipleAddr() {
        EmployeeDto data = mockData();

        EmployeeDto.Address address = new EmployeeDto.Address();
        address.setAddress("111 m.8");
        address.setCity("Moeng");
        address.setCountry("Thailand");
        address.setPostcode("22000");
        data.getAddresses().add(address);

        EmployeeDto response = employeeController.createEmployee(data);
        assertTrue(response.getAddresses().size() > 1);
        assertTrue(response.getAddresses().stream().anyMatch(addr -> addr.getPostcode().equals("22000")));
    }

    @Test
    public void findAll() {
        IntStream.range(0, 10).forEach(i -> {
            EmployeeDto data = mockData();

            employeeController.createEmployee(data);
        });

        List<EmployeeDto> response = employeeController.findAll();

        assertEquals(response.size(), 10);
    }

    @Test
    public void findById() {
        IntStream.range(0, 10).forEach(i -> {
            EmployeeDto data = mockData();

            employeeController.createEmployee(data);
        });

        List<EmployeeDto> response = employeeController.findAll();
        List<Long> emId = response.stream().map(EmployeeDto::getId).collect(Collectors.toList());

        long emNumber = emId.stream().filter(id -> Objects.nonNull(employeeController.findById(id))).count();
        assertEquals(emNumber, 10);
    }


}
