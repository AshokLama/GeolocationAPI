package com.example.IPGeolocation;

import jakarta.persistence.*;

@Entity
@Table(name = "geolocation")
public class Geolocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ip_address")
    private String ipAddress;
    private String country;
    private String city;

    // Add other columns for geolocation data (e.g., country, city, latitude, longitude, etc.)

    public Geolocation() {
    }

    public Geolocation(Long id, String ipAddress, String country, String city) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.country = country;
        this.city = city;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
