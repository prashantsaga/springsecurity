package com.example.User_location;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public void createLocationTable() {
        locationRepository.save(new Location());
    }

    public void updateLocation(Long id, Location location) {
        Optional<Location> optionalLocation = locationRepository.findById(id);
        if (optionalLocation.isPresent()) {
            Location existingLocation = optionalLocation.get();
            existingLocation.setName(location.getName());
            existingLocation.setLatitude(location.getLatitude());
            existingLocation.setLongitude(location.getLongitude());
            locationRepository.save(existingLocation);
        } else {
            throw new IllegalArgumentException("Location not found with id: " + id);
        }
    }

    public List<Location> getNearestLocations(int limit) {
        List<Location> allLocations = locationRepository.findAll();
        List<Location> sortedLocations = allLocations.stream()
                .sorted(Comparator.comparingDouble(l -> Math.sqrt(Math.pow(l.getLatitude(), 2) + Math.pow(l.getLongitude(), 2))))
                .limit(limit)
                .collect(Collectors.toList());
        return sortedLocations;
    }
}

