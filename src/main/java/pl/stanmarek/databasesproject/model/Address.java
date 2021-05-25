package pl.stanmarek.databasesproject.model;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String country;
    private String city;
    @Column(name = "street_name")
    private String streetName;
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
