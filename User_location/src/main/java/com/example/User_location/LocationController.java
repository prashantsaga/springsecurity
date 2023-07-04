package com.example.User_location;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/create_data")
    public ResponseEntity<String> createTable() {
        locationService.createLocationTable();
        return ResponseEntity.ok("Table created successfully.");
    }

    @PatchMapping("/update_data/{id}")
    public ResponseEntity<String> updateLocation(@PathVariable Long id, @RequestBody Location location) {
        locationService.updateLocation(id, location);
        return ResponseEntity.ok("Location updated successfully.");
    }

    @GetMapping("/get_users/{limit}")
    public ResponseEntity<List<Location>> getNearestLocations(@PathVariable int limit) {
        List<Location> locations = locationService.getNearestLocations(limit);
        return ResponseEntity.ok(locations);
    }
}

