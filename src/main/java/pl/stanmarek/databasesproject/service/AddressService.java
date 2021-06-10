package pl.stanmarek.databasesproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.stanmarek.databasesproject.model.Address;
import pl.stanmarek.databasesproject.repo.AddressRepo;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    public Iterable<Address> findAll() {
        return addressRepo.findAll();
    }

    public Optional<Address> findById(Long id) {
        return addressRepo.findById(id);
    }

    public Iterable<Address> findByCountry(String country) {
        return addressRepo.findByCountry(country);
    }

    public Iterable<Address> findByCity(String city) {
        return addressRepo.findByCity(city);
    }

    public Optional<Address> findByAirportId(Long id) {
        return addressRepo.findByAirportId(id);
    }
}
