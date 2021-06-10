package pl.stanmarek.databasesproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.stanmarek.databasesproject.model.Passenger;
import pl.stanmarek.databasesproject.repo.PassengerRepo;

import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepo repo;

    public Iterable<Passenger> findAll() {
        return repo.findAll();
    }

    public boolean add(Passenger passenger) {
        Passenger p = new Passenger();
        p.setName(passenger.getName());
        p.setSurname(passenger.getSurname());
        p.setEmail(passenger.getEmail());

        repo.save(p);

        return true;
    }

    public Optional<Passenger> findById(Long id) {
        return repo.findById(id);
    }

    public Optional<Passenger> findByEmail(String email) {
        return repo.findByEmail(email);
    }

    public boolean deleteById(Long id) {
        repo.deleteById(id);
        return true;
    }

    public Iterable<Passenger> findByFullname(String name, String surname) {
        return repo.findByFullname(name, surname);
    }

    public boolean initRepo() {
        for (int i = 0; i < 50; i++){
            Passenger p = new Passenger();
            p.setName("Name" + i);
            p.setSurname("Surname"+i);
            p.setEmail("email"+i+"@email.com");
            repo.save(p);
        }
        return true;
    }

    public boolean update(Long id, Passenger passenger) {
        if (repo.existsById(id)) {
            return repo.update(id, passenger.getName(), passenger.getSurname(), passenger.getEmail());
        }
        return false;
    }

    public boolean deleteByEmail(String email) {
        return repo.deleteByEmail(email);
    }

    public boolean add(String name, String surname, String email) {
        Passenger p = new Passenger();
        p.setName(name);
        p.setSurname(surname);
        p.setEmail(email);
        repo.save(p);

        return true;
    }

    public Iterable<Passenger> findBySurname(String surname) {
        return repo.findBySurname(surname);
    }
}
