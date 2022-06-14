package entityes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private Long id;
    private String address;
    private String city;
    private String country;
    private String postcode;
    private Employee employee;
}
