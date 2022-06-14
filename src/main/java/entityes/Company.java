package entityes;

import consts.CompanyConst;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Company {
    private Long id;
    private CompanyConst companyName;
    private List<Employee> employees;
    private List<Office> offices;
}
