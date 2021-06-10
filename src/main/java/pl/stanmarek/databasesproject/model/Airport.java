package pl.stanmarek.databasesproject.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @OneToOne
    @JoinColumn(name = "address_id")
    @RestResource(path = "airport_address", rel = "address")
    private Address address;

    public Airport(Long id, String name, Address addressId) {
        this.id = id;
        this.name = name;
        this.address = addressId;
    }

    public Airport(String name, Address addressId) {
        this.name = name;
        this.address = addressId;
    }

    public Airport() {
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressId=" + address +
                '}';
    }
}
