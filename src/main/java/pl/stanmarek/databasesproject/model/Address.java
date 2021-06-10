package pl.stanmarek.databasesproject.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String country;

    @NotNull
    private String city;

    @NotNull
    @Column(name = "street_name")
    private String streetName;

    @OneToOne(mappedBy = "address")
    private Airport airport;

    private int number;

    public Address(Long id, String country, String city, String streetName, int number) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.number = number;
    }

    public Address(String country, String city, String streetName, int number) {
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.number = number;
    }

    public Address(){
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", streetName='" + streetName + '\'' +
                ", number=" + number +
                '}';
    }
}
