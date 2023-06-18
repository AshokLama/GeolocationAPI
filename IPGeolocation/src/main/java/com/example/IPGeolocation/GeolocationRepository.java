package com.example.IPGeolocation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeolocationRepository extends CrudRepository<Geolocation, Long> {
    Geolocation findByIpAddress(String ipAddress);
}
