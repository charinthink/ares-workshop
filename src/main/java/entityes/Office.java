package entityes;

import consts.OfficeConst;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Office {
    private Long id;
    private OfficeConst officeName;
    private List<Department> departments;
    private List<Employee> employees;
    private Company company;
}
