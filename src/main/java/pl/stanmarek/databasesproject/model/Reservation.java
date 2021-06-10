package pl.stanmarek.databasesproject.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "passenger_id")
    @RestResource(path = "reservation_passenger", rel = "passenger")
    private Passenger passenger;

    @NotNull
    @OneToOne
    @JoinColumn(name = "flight_id")
    @RestResource(path = "reservation_flight", rel = "flight")
    private Flight flight;

    private int seat;

    private double luggage;

    public Reservation(){}

    public Reservation(Long id, Passenger passenger, Flight flight, int seat, double maxLuggageWeight) {
        this.id = id;
        this.passenger = passenger;
        this.flight = flight;
        this.seat = seat;
        this.luggage = maxLuggageWeight;
    }

    public Reservation(Passenger passenger, Flight flight, int seat, double maxLuggageWeight) {
        this.passenger = passenger;
        this.flight = flight;
        this.seat = seat;
        this.luggage = maxLuggageWeight;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", passenger=" + passenger +
                ", flight=" + flight +
                ", seat=" + seat +
                ", luggage=" + luggage +
                '}';
    }
}
