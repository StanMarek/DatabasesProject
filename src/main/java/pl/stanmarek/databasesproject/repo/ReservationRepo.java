package pl.stanmarek.databasesproject.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.stanmarek.databasesproject.model.Reservation;

@Repository
public interface ReservationRepo extends CrudRepository<Reservation, Long> {
}
