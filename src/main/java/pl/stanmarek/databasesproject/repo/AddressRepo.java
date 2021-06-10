package pl.stanmarek.databasesproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.stanmarek.databasesproject.model.Address;

import java.util.Optional;

@Repository
public interface AddressRepo extends CrudRepository<Address, Long> {

    @Query("select a from Address a where " +
            "a.country = :country")
    Iterable<Address> findByCountry(String country);

    @Query("select a from Address a where " +
            "a.city = :city")
    Iterable<Address> findByCity(String city);

    @Query("select a from Address a where " +
            "a.airport.id = :id")
    Optional<Address> findByAirportId(Long id);
}
