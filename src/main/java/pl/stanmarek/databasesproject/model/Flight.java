package pl.stanmarek.databasesproject.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long plane_id;
    private Long startingAirport;
    private Long destinationAirport;
    private Date datetime;

    public Flight(){
    }

    public Flight(Long id, Long plane_id, Long startingAirport, Long destinationAirport, Date datetime) {
        this.id = id;
        this.plane_id = plane_id;
        this.startingAirport = startingAirport;
        this.destinationAirport = destinationAirport;
        this.datetime = datetime;
    }

    public Flight(Long plane_id, Long startingAirport, Long destinationAirport, Date datetime) {
        this.plane_id = plane_id;
        this.startingAirport = startingAirport;
        this.destinationAirport = destinationAirport;
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", plane_id=" + plane_id +
                ", startingAirport=" + startingAirport +
                ", destinationAirport=" + destinationAirport +
                ", datetime=" + datetime +
                '}';
    }
}
