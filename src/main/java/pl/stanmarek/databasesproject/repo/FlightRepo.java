package pl.stanmarek.databasesproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.stanmarek.databasesproject.model.Flight;

import java.time.LocalDate;

@Repository
public interface FlightRepo extends CrudRepository<Flight, Long> {

    @Query("select f from Flight f where " +
            "f.plane.id = :plane")
    Iterable<Flight> findByPlane(Long plane);

    @Query("select f from Flight f where " +
            "f.startingAirport.id = :id")
    Iterable<Flight> findByDepartureAirport(Long id);

    @Query("select f from Flight f where " +
            "f.destinationAirport.id = :id")
    Iterable<Flight> findByArrivalAirport(Long id);

    @Query("select f from Flight f where " +
            "f.datetime = :date")
    Iterable<Flight> getByDate(LocalDate date);

    @Query("select f from Flight f where " +
            "f.destinationAirport.address.country = :country")
    Iterable<Flight> getByDestination(String country);

    @Query("select f from Flight f where " +
            "f.startingAirport.address.country = :country")
    Iterable<Flight> findByStartingCountry(String country);

    @Query("select f from Flight f where " +
            "f.destinationAirport.address.city = :city")
    Iterable<Flight> findByDestinationCity(String city);

    @Query("select f from Flight f where " +
            "f.startingAirport.address.city = :city")
    Iterable<Flight> findByStartingCity(String city);

    @Query("select f from Flight f where " +
            "f.startingAirport.id = :startId and " +
            "f.destinationAirport.id = :toId")
    Iterable<Flight> findByStartAndDestination(Long startId, Long toId);
    
    @Query("select f from Flight f where " +
            "f.startingAirport.address.country = :from and " +
            "f.destinationAirport.address.country = :to")
    Iterable<Flight> findByStartAndDestinationCountry(String from, String to);

    @Query("select f from Flight f where " +
            "f.startingAirport.address.city = :from and " +
            "f.destinationAirport.address.city = :to")
    Iterable<Flight> findByStartAndDestinationCity(String from, String to);

    @Query("select f from Flight f where " +
            "f.startingAirport.address.city = :from and " +
            "f.destinationAirport.address.country = :to")
    Iterable<Flight> getByCityToCountry(String from, String to);

    @Query("select f from Flight f where " +
            "f.startingAirport.address.country = :from and " +
            "f.destinationAirport.address.city = :to")
    Iterable<Flight> findByCountryToCity(String from, String to);
}
