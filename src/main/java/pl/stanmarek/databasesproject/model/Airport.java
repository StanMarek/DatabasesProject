package pl.stanmarek.databasesproject.model;

import javax.persistence.*;

@Entity
@Table(name = "airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name = "address_id")
    private Long addressId;

    public Airport(Long id, String name, Long addressId) {
        this.id = id;
        this.name = name;
        this.addressId = addressId;
    }

    public Airport(String name, Long addressId) {
        this.name = name;
        this.addressId = addressId;
    }

    public Airport() {
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressId=" + addressId +
                '}';
    }
}
