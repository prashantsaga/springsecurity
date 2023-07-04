package com.example.userlocation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserLocation, Long>{

}
