package pl.stanmarek.databasesproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.stanmarek.databasesproject.model.Opinion;

@Repository
public interface ReservationRepo extends JpaRepository<Opinion, Long> {
}
