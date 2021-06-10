package pl.stanmarek.databasesproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.stanmarek.databasesproject.model.Opinion;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface OpinionRepo extends CrudRepository<Opinion, Long> {

    @Query("select o from Opinion o where " +
            "o.passenger.email = :email")
    Iterable<Opinion> findByPassengerEmail(String email);

    @Query("select o from Opinion o where " +
            "o.passenger.id = :id")
    Iterable<Opinion> findByPassengerId(Long id);

    @Query("select o from Opinion o where " +
            "o.flight.id = :id")
    Optional<Opinion> findByFlightId(Long id);

    @Query("select o from Opinion o where " +
            "o.flight.plane.airline = :airline")
    Iterable<Opinion> findByAirline(String airline);

    @Query("select o from Opinion o where " +
            "o.flight.plane.id = :id")
    Iterable<Opinion> findByPlane(Long id);

    @Query("select o from Opinion o where " +
            "o.flight.plane.seats = :seats")
    Iterable<Opinion> findByPlaneSeats(int seats);

    @Query("select o from Opinion o where " +
            "o.flight.startingAirport.address.country = :from " +
            "and " +
            "o.flight.destinationAirport.address.country = :to")
    Iterable<Opinion> findByFlightCountry(String from, String to);

    @Query("select o from Opinion o where " +
            "o.flight.startingAirport.address.city = :from " +
            "and " +
            "o.flight.destinationAirport.address.city = :to")
    Iterable<Opinion> findByFlightCity(String from, String to);

    @Query("select o from Opinion o where " +
            "o.flight.startingAirport.address.country = :country")
    Iterable<Opinion> findByStartCountry(String country);

    @Query("select o from Opinion o where " +
            "o.flight.startingAirport.address.city = :city")
    Iterable<Opinion> findByStartCity(String city);

    @Query("select o from Opinion o where " +
            "o.flight.destinationAirport.address.country = :country")
    Iterable<Opinion> findByDestinationCountry(String country);

    @Query("select o from Opinion o where " +
            "o.flight.destinationAirport.address.city = :city")
    Iterable<Opinion> findByDestinationCity(String city);

    @Query("select o from Opinion o where " +
            "o.flight.datetime = :date")
    Iterable<Opinion> findByDate(LocalDate date);
}
