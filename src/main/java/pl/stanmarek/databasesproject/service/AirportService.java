package pl.stanmarek.databasesproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.stanmarek.databasesproject.model.Airport;
import pl.stanmarek.databasesproject.repo.AirportRepo;

import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepo airportRepo;

    public Iterable<Airport> getAll() {
        return airportRepo.findAll();
    }

    public Optional<Airport> getById(Long id) {
        return airportRepo.findById(id);
    }

    public Optional<Airport> getByName(String name) {
        return airportRepo.findByName(name);
    }

    public Optional<Airport> getByAddressId(Long id) {
        return airportRepo.findByAddressId(id);
    }

    public Iterable<Airport> getByCountry(String country) {
        return airportRepo.findByCountry(country);
    }

    public Iterable<Airport> getByCity(String city) {
        return airportRepo.findByCity(city);
    }
}
