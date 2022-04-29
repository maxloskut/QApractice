package practice4.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "address")
public class adrress {
    @Id
    private Integer id_address;
    private String country;
    private String city;

    @ManyToMany
    @JoinTable(
            name = "address_student",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_address")
    )
    private Set<student> studentSet;

    //address_student

    public Integer getId_address() {
        return id_address;
    }

    public void setId_address(Integer id_address) {
        this.id_address = id_address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "adrress{" +
                "id_address=" + id_address +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", studentSet=" + studentSet +
                '}';
    }
}
