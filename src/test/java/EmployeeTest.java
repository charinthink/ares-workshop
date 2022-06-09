import consts.CompanyConst;
import consts.DepartmentConst;
import consts.OfficeConst;
import controllers.EmployeeController;
import dtos.EmployeeRequestDto;
import dtos.EmployeeResponseDto;
import entityes.Employee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import services.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {
    private final EmployeeController employeeController;

    public EmployeeTest() {
        EmployeeService employeeService = new EmployeeService();
        employeeController = new EmployeeController(employeeService);
    }

    public EmployeeRequestDto mockData() {
        EmployeeRequestDto requestDto = new EmployeeRequestDto();
        requestDto.setTitleName("Mr");
        requestDto.setFirstName("Charin");
        requestDto.setSurName("Wiset");
        requestDto.setOld(25);

        List<EmployeeRequestDto.Address> addresses = new ArrayList<>();
        EmployeeRequestDto.Address address = new EmployeeRequestDto.Address();
        address.setAddress("111 m.8");
        address.setCity("Moeng");
        address.setCountry("Thailand");
        address.setPostcode("21000");
        addresses.add(address);
        requestDto.setAddresses(addresses);

        EmployeeRequestDto.Department department = new EmployeeRequestDto.Department();
        department.setDepartmentName(DepartmentConst.ATHENA);

        EmployeeRequestDto.Office office = new EmployeeRequestDto.Office();
        office.setOfficeName(OfficeConst.KUBERNETES_CAMPUS);
        office.setDepartment(department);

        EmployeeRequestDto.Company company = new EmployeeRequestDto.Company();
        company.setCompanyConst(CompanyConst.GREEK_TECHNOLOGY);
        company.setOffice(office);

        requestDto.setCompany(company);

        return requestDto;
    }

    @Test
    public void createEmployee() {
        EmployeeRequestDto data = mockData();

        EmployeeResponseDto response = employeeController.createEmployee(data);
        System.out.println(response.getId());
    }
}
