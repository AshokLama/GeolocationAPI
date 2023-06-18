package com.example.IPGeolocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geolocation")
@Validated
public class GeolocationController {
    private final GeolocationService geolocationService;

    @Autowired
    public GeolocationController(GeolocationService geolocationService) {
        this.geolocationService = geolocationService;
    }

    @GetMapping("/{ipAddress}")
    public Geolocation getGeolocation(@PathVariable String ipAddress) {
        return geolocationService.getGeolocation(ipAddress);
    }
}
