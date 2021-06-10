package pl.stanmarek.databasesproject.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "opinions")
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "passenger_id")
    @RestResource(path = "opinion_passenger", rel = "passenger")
    private Passenger passenger;

    @NotNull
    private String text;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    public Opinion(){}

    public Opinion(Long id, String text, Flight flightId, Passenger passengerId) {
        this.id = id;
        this.text = text;
        this.flight = flightId;
        this.passenger= passengerId;
    }

    public Opinion(String text, Flight flightId, Passenger passengerId) {
        this.text = text;
        this.flight = flightId;
        this.passenger = passengerId;
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", flightId=" + flight +
                '}';
    }
}
