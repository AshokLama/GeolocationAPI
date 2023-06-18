package com.example.IPGeolocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeolocationService {
    private static final String GEOLOCATION_API_URL = "https://ip-api.com/json/";

    private final GeolocationRepository geolocationRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public GeolocationService(GeolocationRepository geolocationRepository, RestTemplate restTemplate) {
        this.geolocationRepository = geolocationRepository;
        this.restTemplate = restTemplate;
    }

    @Cacheable(cacheNames = "geolocationCache")
    public Geolocation getGeolocation(String ipAddress) {
        Geolocation geolocation = geolocationRepository.findByIpAddress(ipAddress);
        if (geolocation == null) {
            geolocation = fetchGeolocationFromApi(ipAddress);
            geolocationRepository.save(geolocation);
        }
        return geolocation;
    }

    private Geolocation fetchGeolocationFromApi(String ipAddress) {
        String apiUrl = GEOLOCATION_API_URL + ipAddress;
        return restTemplate.getForObject(apiUrl, Geolocation.class);
    }
}
