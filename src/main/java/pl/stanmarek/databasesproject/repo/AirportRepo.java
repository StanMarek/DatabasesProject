package pl.stanmarek.databasesproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.stanmarek.databasesproject.model.Airport;

@Repository
public interface AirportRepo extends JpaRepository<Airport, Long> {
}
