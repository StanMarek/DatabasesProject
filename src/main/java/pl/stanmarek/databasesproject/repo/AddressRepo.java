package pl.stanmarek.databasesproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.stanmarek.databasesproject.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
}
