package entityes;

import consts.DepartmentConst;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Department {
    private Long id;
    private DepartmentConst departmentName;
    private List<Employee> employees;
    private Office office;
}
