import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import consts.CompanyConst;
import consts.DepartmentConst;
import consts.OfficeConst;
import controllers.CompanyController;
import dtos.CompanyDto;
import entityes.Employee;
import org.junit.Test;
import services.CompanyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmployeeTest {
    private final CompanyController companyController;

    public EmployeeTest() {
        CompanyService companyService = new CompanyService();
        companyController = new CompanyController(companyService);
    }

    public CompanyDto mockData() {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(1L);
        companyDto.setCompanyName(CompanyConst.GREEK_TECHNOLOGY);

        CompanyDto.DepartmentDto departmentDto = new CompanyDto.DepartmentDto();
        departmentDto.setId(1L);
        departmentDto.setDepartmentName(DepartmentConst.ZEUS);

        CompanyDto.OfficeDto officeDto = new CompanyDto.OfficeDto();
        officeDto.setId(1L);
        officeDto.setOfficeName(OfficeConst.KUBERNETES_CAMPUS);
        officeDto.setDepartment(departmentDto);

        List<CompanyDto.AddressDto> addressesDto = new ArrayList<>();
        CompanyDto.AddressDto addressDto = new CompanyDto.AddressDto();
        addressDto.setAddress("1112");
        addressDto.setCity("Thai");
        addressDto.setCountry("Thailand");
        addressDto.setPostcode("11000");
        addressesDto.add(addressDto);

        CompanyDto.EmployeeDto employeeDto = new CompanyDto.EmployeeDto();
        employeeDto.setTitleName("Mr");
        employeeDto.setFirstName("demo");
        employeeDto.setSurName("demodemo");
        employeeDto.setAge(20);
        employeeDto.setAddresses(addressesDto);
        employeeDto.setOffice(officeDto);

        companyDto.setEmployee(employeeDto);

        return companyDto;
    }

    @Test
    public void createEmployee() throws JsonProcessingException {
        CompanyDto data = mockData();
        CompanyDto companyDto = companyController.createEmployee(data);

       assertEquals(Long.valueOf(1), companyDto.getId());
       assertTrue(companyDto.getEmployee().getAddresses().size() > 0);
    }
}
