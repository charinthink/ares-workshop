package entityes;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Employee {
    private Long id;
    private String titleName;
    private String firstName;
    private String surName;
    private Integer age;
    private List<Address> addresses;
    private Department department;
    private Company company;
    private Office office;
}
