import consts.CompanyConst;
import consts.DepartmentConst;
import consts.OfficeConst;
import controllers.EmployeeController;
import db_on_memory.DB;
import dtos.EmployeeDto;
import entityes.Employee;
import org.junit.Test;
import services.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
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
        requestDto.setAge(25);

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
        assertEquals("Demo", response.getFirstName());
        assertEquals("Demo", response.getSurName());

        DB.close();
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

        DB.close();
    }

    @Test
    public void findAll() {
        IntStream.range(0, 10).forEach(i -> {
            EmployeeDto data = mockData();

            employeeController.createEmployee(data);
        });

        List<EmployeeDto> response = employeeController.findAll();

        assertEquals(10, response.size());
        DB.close();
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
        assertEquals(10, emNumber);

        DB.close();
    }

    @Test
    public void updateEmployee() {
        List<Integer> numberRand = new ArrayList<>();
        List<EmployeeDto> keepResponse = new ArrayList<>();
        AtomicInteger countAddr = new AtomicInteger();

        IntStream.range(0, 10).forEach(i -> {
            EmployeeDto data = mockData();
            EmployeeDto responseCreate = employeeController.createEmployee(data);

            IntStream.range(0, 5).forEach( x -> {
                EmployeeDto.Address addressDto = new EmployeeDto.Address();
                addressDto.setAddress("111 m.8");
                addressDto.setCity("Moeng");
                addressDto.setCountry("Thailand");
                addressDto.setPostcode("21000");

                responseCreate.getAddresses().add(addressDto);
                countAddr.getAndIncrement();
            });

            responseCreate.getAddresses()
                    .stream()
                    .forEach(addr -> {
                        int mathRand = (int) (Math.random() * 10);
                        numberRand.add(mathRand);

                        addr.setAddress(String.valueOf(mathRand));
                    });

            keepResponse.add(employeeController.updateById(responseCreate.getId(), responseCreate));
        });

        AtomicInteger count = new AtomicInteger();
        keepResponse.stream()
                .forEach(v -> {
                    boolean found = v.getAddresses()
                            .stream()
                            .anyMatch(addr -> numberRand.stream()
                                    .anyMatch(number -> Integer.toString(number).equals(addr.getAddress())));
                    if (found)
                        count.getAndIncrement();
                });


        assertEquals(10, keepResponse.size());
        assertEquals(10, count.get());
        assertEquals(50, countAddr.get());
        assertEquals("Moeng", keepResponse.get(0).getAddresses().get(0).getCity());

        DB.close();
    }

    @Test
    public void findByDepartmentId() {
        EmployeeDto employee = mockData();

        EmployeeDto response = employeeController.createEmployee(employee);
        Long id = response.getCompany().getOffice().getDepartment().getId();


        List<EmployeeDto> responses = employeeController.findByDepartmentId(id);

        assertTrue(responses.size() > 0);

        DB.close();
    }

    @Test
    public void findByOfficeId() {
        EmployeeDto employeeDto = mockData();

        EmployeeDto response = employeeController.createEmployee(employeeDto);
        Long id = response.getCompany().getOffice().getId();

        List<EmployeeDto> responses = employeeController.findByOfficeId(id);

        assertTrue(responses.size() > 0);

        DB.close();
    }

    @Test
    public void deleteAll(){
        IntStream.range(0, 10).forEach(i -> {
            EmployeeDto employeeDto = mockData();
            EmployeeDto response = employeeController.createEmployee(employeeDto);
        });

        employeeController.deleteAll();

        List<EmployeeDto> employeeDtos = employeeController.findAll();
        assertEquals(0, employeeDtos.size());
    }
}
