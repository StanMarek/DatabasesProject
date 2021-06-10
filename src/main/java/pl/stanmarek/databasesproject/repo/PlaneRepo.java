package pl.stanmarek.databasesproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.stanmarek.databasesproject.model.Plane;

@Repository
public interface PlaneRepo extends CrudRepository<Plane, Long> {

    @Query("select p from Plane p where " +
            "p.airline = :airline")
    Iterable<Plane> findByAirline(String airline);

    @Query("select p from Plane p where " +
            "p.seats = :seats")
    Iterable<Plane> findBySeats(int seats);

    @Query("select p from Plane p where " +
            "p.airline = :airline and p.seats = :seats")
    Iterable<Plane> findByAirlineAndSeats(String airline, int seats);
}
