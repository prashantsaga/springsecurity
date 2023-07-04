package com.example.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLocationService {

    @Autowired
    private UserLocationRepository userLocationRepository;

    public UserLocation create(UserLocation userLocation) {
        return userLocationRepository.save(userLocation);
    }

    public UserLocation update(Long id, UserLocation userLocation) {
        UserLocation existingUserLocation = userLocationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User Location not found with id: " + id));
        existingUserLocation.setName(userLocation.getName());
        existingUserLocation.setLatitude(userLocation.getLatitude());
        existingUserLocation.setLongitude(userLocation.getLongitude());
        return userLocationRepository.save(existingUserLocation);
    }

    public void delete(Long id) {
        userLocationRepository.deleteById(id);
    }

    public List<UserLocation> getAll() {
        return userLocationRepository.findAll();
    }

    public UserLocation getById(Long id) {
        return userLocationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User Location not found with id: " + id));
    }

}

