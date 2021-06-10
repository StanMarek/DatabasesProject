package pl.stanmarek.databasesproject.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "plane_id")
    @RestResource(path = "flight_plane_id", rel = "plane")
    private Plane plane;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "start_airport")
    @RestResource(path = "flight_start_airport", rel = "airport")
    private Airport startingAirport;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "destination_airport")
    @RestResource(path = "flight_dest_airport", rel = "airport")
    private Airport destinationAirport;

    private LocalDate datetime;

    public Flight(){
    }

    public Flight(Long id, Plane plane_id, Airport startingAirport, Airport destinationAirport, LocalDate datetime) {
        this.id = id;
        this.plane = plane_id;
        this.startingAirport = startingAirport;
        this.destinationAirport = destinationAirport;
        this.datetime = datetime;
    }

    public Flight(Plane plane_id, Airport startingAirport, Airport destinationAirport, LocalDate datetime) {
        this.plane = plane_id;
        this.startingAirport = startingAirport;
        this.destinationAirport = destinationAirport;
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", plane_id=" + plane +
                ", startingAirport=" + startingAirport +
                ", destinationAirport=" + destinationAirport +
                ", datetime=" + datetime +
                '}';
    }
}
