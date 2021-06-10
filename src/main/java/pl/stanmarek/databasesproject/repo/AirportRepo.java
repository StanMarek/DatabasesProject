package pl.stanmarek.databasesproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.stanmarek.databasesproject.model.Airport;

import java.util.Optional;

@Repository
public interface AirportRepo extends CrudRepository<Airport, Long> {

    @Query("select a from Airport a where " +
            "a.name = :name")
    Optional<Airport> findByName(String name);

    @Query("select a from Airport a where " +
            "a.address.id = :id")
    Optional<Airport> findByAddressId(Long id);

    @Query("select a from Airport a where " +
            "a.address.country = :country")
    Iterable<Airport> findByCountry(String country);

    @Query("select a from Airport a where " +
            "a.address.city = :city")
    Iterable<Airport> findByCity(String city);
}
