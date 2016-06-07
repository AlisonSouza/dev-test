package com.goeuro.domain.mapping.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "geo_position")
public class GeoPosition {
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "GeoPosition{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
