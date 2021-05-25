package pl.stanmarek.databasesproject.model;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long passenger;
    private Long flight;
    private int seat;
    @Column(name = "max_luggage")
    private double maxLuggageWeight;

    public Reservation(){}

    public Reservation(Long id, Long passenger, Long flight, int seat, double maxLuggageWeight) {
        this.id = id;
        this.passenger = passenger;
        this.flight = flight;
        this.seat = seat;
        this.maxLuggageWeight = maxLuggageWeight;
    }

    public Reservation(Long passenger, Long flight, int seat, double maxLuggageWeight) {
        this.passenger = passenger;
        this.flight = flight;
        this.seat = seat;
        this.maxLuggageWeight = maxLuggageWeight;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", passenger=" + passenger +
                ", flight=" + flight +
                ", seat=" + seat +
                ", maxLuggageWeight=" + maxLuggageWeight +
                '}';
    }
}
