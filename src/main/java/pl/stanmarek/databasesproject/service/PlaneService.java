package pl.stanmarek.databasesproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.stanmarek.databasesproject.model.Plane;
import pl.stanmarek.databasesproject.repo.PlaneRepo;

import java.util.Optional;

@Service
public class PlaneService {

    @Autowired
    private PlaneRepo repo;

    public Iterable<Plane> getAll() {
        return repo.findAll();
    }

    public Optional<Plane> findById(Long id) {
        return repo.findById(id);
    }

    public Iterable<Plane> findByAirline(String airline) {
        return repo.findByAirline(airline);
    }

    public Iterable<Plane> findBySeats(int numberOfSeats) {
        return repo.findBySeats(numberOfSeats);
    }

    public Iterable<Plane> findByAirlineAndSeats(String airline, int seats) {
        return repo.findByAirlineAndSeats(airline, seats);
    }

    public boolean addPlane(Plane plane) {
        Plane p = new Plane();
        p.setAirline(plane.getAirline());
        p.setSeats(plane.getSeats());
        repo.save(p);
        return true;
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
