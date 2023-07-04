package com.example.userlocation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Transactional
    public UserLocation createUser(UserLocation userLocation) {
        return userRepository.save(userLocation);
    }
    
    @Transactional
    public UserLocation updateUser(Long userId, UserLocation userLocation) {
        UserLocation existingUser = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found with id " + userId));
        
        existingUser.setName(userLocation.getName());
        existingUser.setLatitude(userLocation.getLatitude());
        existingUser.setLongitude(userLocation.getLongitude());
        
        return userRepository.save(existingUser);
    }
    
    public List<UserLocation> getNearestUsers(int n) {
        return userRepository.findAll().stream()
                .sorted(Comparator.comparingDouble(user -> calculateDistance(user.getLatitude(), user.getLongitude())))
                .limit(n)
                .collect(Collectors.toList());
    }
    
    private double calculateDistance(double lat, double lon) {
        double distanceSq = Math.pow(lat - 0, 2) + Math.pow(lon - 0, 2);
        return Math.sqrt(distanceSq);
    }
}
