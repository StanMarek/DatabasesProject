package pl.stanmarek.databasesproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "planes")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String airline;

    private int seats;

    public Plane() {
    }

    public Plane(String model, int numberOfSeats) {
        this.airline = model;
        this.seats = numberOfSeats;
    }

    public Plane(Long id, String model, int numberOfSeats) {
        this.id = id;
        this.airline = model;
        this.seats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", model='" + airline + '\'' +
                ", numberOfSeats=" + seats +
                '}';
    }
}
