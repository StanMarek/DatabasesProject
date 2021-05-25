package pl.stanmarek.databasesproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.stanmarek.databasesproject.model.Plane;

@Repository
public interface PlaneRepo extends JpaRepository<Plane, Long> {
}
