package pl.stanmarek.databasesproject.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.stanmarek.databasesproject.model.Passenger;

import java.util.Optional;

@Repository
public interface PassengerRepo extends CrudRepository<Passenger, Long> {

    @Query("select p from Passenger p where " +
            "p.email = ?1")
    Optional<Passenger> findByEmail(String email);

    @Query("select p from Passenger p where " +
            "p.name = :name and p.surname = :surname")
    Iterable<Passenger> findByFullname(String name, String surname);

    @Modifying
    @Query("update Passenger p " +
            "set p.name = :nameParam, p.surname = :surnameParam, p.email= :emailParam " +
            "where p.id = :idParam")
    boolean update(Long idParam, String nameParam, String surnameParam, String emailParam);


    @Modifying
    @Query("delete from Passenger p where " +
            "p.email = :email")
    boolean deleteByEmail(String email);

    @Query("select p from Passenger p where " +
            "p.surname = :surname")
    Iterable<Passenger> findBySurname(String surname);
}
