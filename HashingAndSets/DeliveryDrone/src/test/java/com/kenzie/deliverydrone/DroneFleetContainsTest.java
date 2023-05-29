package com.kenzie.deliverydrone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DroneFleetContainsTest {

    @Test
    void containsDroneFromLocation_checkingForContainedLocation_returnsTrue() {
        // GIVEN
        DroneFleet drones = new DroneFleet();
        drones.addDrone(new DeliveryDrone("123", "US"));
        drones.addDrone(new DeliveryDrone("456", "UK"));
        drones.addDrone(new DeliveryDrone("789", "JP-TOKYO"));

        // WHEN
        boolean result = drones.containsDroneFromLocation("JP-TOKYO");

        // THEN
        assertTrue(result, "DroneFleet containing a drone from a " +
                "particular location returns true if containsDroneFromLocation is passed that location code");
    }

    @Test
    void containsDroneFromLocation_checkingForMissingLocation_returnsFalse() {
        // GIVEN
        DroneFleet drones = new DroneFleet();
        drones.addDrone(new DeliveryDrone("123", "US"));
        drones.addDrone(new DeliveryDrone("456", "UK"));
        drones.addDrone(new DeliveryDrone("789", "JP-TOKYO"));


        // WHEN
        boolean result = drones.containsDroneFromLocation("US-NYC");

        // THEN
        assertFalse(result, "DroneFleet that doesn't contain a drone from" +
                " a particular location returns false if containsDroneFromLocation is passed that location code");
    }
}
