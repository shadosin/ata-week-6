package com.kenzie.deliverydrone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DroneFleetTest {

    @Test
    void add_addingDuplicateDrone_droneNotAddedToFleet() {
        // GIVEN
        DroneFleet drones = new DroneFleet();
        drones.addDrone(new DeliveryDrone("123", "US"));
        int sizeBeforeAdd = drones.getSize();

        // WHEN
        boolean addResult = drones.addDrone(new DeliveryDrone("123", "US"));

        // THEN
        int sizeResult = drones.getSize();
        assertEquals(sizeBeforeAdd, sizeResult, "Adding a duplicate Delivery Drone should not increase the fleet " +
                "size.");
        assertFalse(addResult, "Adding a duplicate DeliveryDrone using addDrone should return false.");

    }

    @Test
    void add_addingUniqueDrone_droneAddedToFleet() {
        // GIVEN
        DroneFleet drones = new DroneFleet();
        drones.addDrone(new DeliveryDrone("123", "US"));
        int sizeBeforeAdd = drones.getSize();

        // WHEN
        boolean addResult = drones.addDrone(new DeliveryDrone("456", "US"));

        // THEN
        int sizeResult = drones.getSize();
        assertEquals(sizeBeforeAdd + 1, sizeResult, "Adding a unique Delivery Drone should increase " +
                "the fleet size by 1.");
        assertTrue(addResult, "Adding a unique DeliveryDrone using addDrone should return true.");

    }

    @Test
    void remove_droneInFleet_returnsTrue() {
        // GIVEN
        DroneFleet drones = new DroneFleet();
        drones.addDrone(new DeliveryDrone("123", "US"));
        int sizeBeforeRemove = drones.getSize();

        // WHEN
        boolean removeResult = drones.removeDrone(new DeliveryDrone("123", "US"));

        // THEN
        int sizeResult = drones.getSize();
        assertEquals(sizeBeforeRemove -1, sizeResult, "Removing a Delivery Drone should decrease the DroneFleet " +
                "size by 1.");
        assertTrue(removeResult, "Removing a DeliveryDrone using removeDrone should return true.");

    }

    @Test
    void remove_droneNotInFleet_returnsFalse() {
        // GIVEN
        DroneFleet drones = new DroneFleet();
        drones.addDrone(new DeliveryDrone("123", "US"));
        int sizeBeforeRemove = drones.getSize();

        // WHEN
        boolean removeResult = drones.removeDrone(new DeliveryDrone("456", "US"));

        // THEN
        int sizeResult = drones.getSize();
        assertEquals(sizeBeforeRemove, sizeResult, "Removing a Delivery Drone that isn't in the fleet" +
                " should not affect the fleet size.");
        assertFalse(removeResult, "Removing a DeliveryDrone not in the fleet using removeDrone should return false.");

    }

}
