package com.kenzie.deliverydrone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeliveryDroneTest {

    @Test
    void equals_inputObjectNull_returnsFalse() {
        //GIVEN
        DeliveryDrone usa1 = new DeliveryDrone("123", "US");
        DeliveryDrone usa2 = null;

        //WHEN
        boolean result = usa1.equals(usa2);

        //THEN
        assertFalse(result, "Expected checking for equality to a null object to return false.");
    }

    @Test
    void equals_inputObjectDifferentType_returnsFalse() {
        //GIVEN
        DeliveryDrone usa1 = new DeliveryDrone("123", "US");
        DroneFleet usa2 = new DroneFleet();

        //WHEN
        boolean result = usa1.equals(usa2);

        //THEN
        assertFalse(result, "Expected checking for equality between objects of different type to return false.");
    }


    @Test
    void equals_sameObject_returnsTrue() {
        //GIVEN
        DeliveryDrone usa1 = new DeliveryDrone("123", "US");
        DeliveryDrone usa2 = usa1;

        //WHEN
        boolean result = usa1.equals(usa2);

        //THEN
        assertTrue(result, "Expected a DeliveryDrone to be equal to itself.");
    }

    @Test
    void equals_equalAttributes_returnsTrue() {
        //GIVEN
        DeliveryDrone usa1 = new DeliveryDrone("123", "US");
        DeliveryDrone usa2 = new DeliveryDrone("123", "US");

        //WHEN
        boolean result = usa1.equals(usa2);

        //THEN
        assertTrue(result, "DeliveryDrones with the same registrationNumber and locationCode should be equal.");
    }

    @Test
    void equals_notEqualLocationCode_returnsFalse() {
        //GIVEN
        DeliveryDrone usa1 = new DeliveryDrone("123", "US");
        DeliveryDrone ca2 = new DeliveryDrone("123", "CA");

        //WHEN
        boolean result = usa1.equals(ca2);

        //THEN
        assertFalse(result, "DeliveryDrones with different locationCodes should not be equal.");
    }

    @Test
    void equals_notEqualRegistrationNumber_returnsFalse() {
        //GIVEN
        DeliveryDrone usa1 = new DeliveryDrone("123", "US");
        DeliveryDrone usa2 = new DeliveryDrone("456", "USA");

        //WHEN
        boolean result = usa1.equals(usa2);

        //THEN
        assertFalse(result, "DeliveryDrones with different registration numbers should not be equal.");
    }

    @Test
    void hashCode_equalDeliveryDroneObjects_returnsSame() {
        //GIVEN
        DeliveryDrone usa1 = new DeliveryDrone("123", "US");
        DeliveryDrone usa2 = new DeliveryDrone("123", "US");
        
        //WHEN
        int usa1hash = usa1.hashCode();
        int usa2hash = usa2.hashCode();

        //THEN
        assertEquals(usa1hash, usa2hash, "Equal DeliveryDrones should have the same hash codes.");
    }

}
