package pl.stanmarek.databasesproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.stanmarek.databasesproject.model.Opinion;
import pl.stanmarek.databasesproject.repo.OpinionRepo;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class OpinionService {

    @Autowired
    private OpinionRepo opinionRepo;

    public Iterable<Opinion> getAll() {
        return opinionRepo.findAll();
    }

    public Optional<Opinion> getById(Long id) {
        return opinionRepo.findById(id);
    }

    public Iterable<Opinion> getBypassengerEmail(String email) {
        return opinionRepo.findByPassengerEmail(email);
    }

    public Iterable<Opinion> getByPassengerId(Long id) {
        return opinionRepo.findByPassengerId(id);
    }

    public Optional<Opinion> getByFlightId(Long id) {
        return opinionRepo.findByFlightId(id);
    }

    public Iterable<Opinion> getByAirline(String airline) {
        return opinionRepo.findByAirline(airline);
    }

    public Iterable<Opinion> getByPlane(Long id) {
        return opinionRepo.findByPlane(id);
    }

    public Iterable<Opinion> getByPlaneSeats(int seats) {
        return opinionRepo.findByPlaneSeats(seats);
    }

    public Iterable<Opinion> findByFlightCountry(String from, String to) {
        return opinionRepo.findByFlightCountry(from, to);
    }

    public Iterable<Opinion> findByFlightCity(String from, String to) {
        return opinionRepo.findByFlightCity(from, to);
    }

    public Iterable<Opinion> getByStartCountry(String country) {
        return opinionRepo.findByStartCountry(country);
    }

    public Iterable<Opinion> getByStartCity(String city) {
        return opinionRepo.findByStartCity(city);
    }

    public Iterable<Opinion> getByDestinationCountry(String country) {
        return opinionRepo.findByDestinationCountry(country);
    }

    public Iterable<Opinion> getByDestinationCity(String city) {
        return opinionRepo.findByDestinationCity(city);
    }

    public Iterable<Opinion> getByDate(LocalDate date) {
        return opinionRepo.findByDate(date);
    }
}
