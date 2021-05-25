package pl.stanmarek.databasesproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.stanmarek.databasesproject.model.Passenger;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger, Long> {
}
