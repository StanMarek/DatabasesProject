package pl.stanmarek.databasesproject.model;

import javax.persistence.*;

@Entity
@Table(name = "planes")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    @Column(name = "seats")
    private int numberOfSeats;

    public Plane() {
    }

    public Plane(String model, int numberOfSeats) {
        this.model = model;
        this.numberOfSeats = numberOfSeats;
    }

    public Plane(Long id, String model, int numberOfSeats) {
        this.id = id;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }
}
