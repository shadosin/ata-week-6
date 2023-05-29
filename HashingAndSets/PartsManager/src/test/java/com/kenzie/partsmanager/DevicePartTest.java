package com.kenzie.partsmanager;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DevicePartTest {
    private String manufacturerName = "Knowles";
    private String manufacturerPartNumber = "SPH0655LM4H-1";
    private List<AmazonDevice> devices = Arrays.asList(AmazonDevice.ECHO_AUTO, AmazonDevice.ECHO_LOOP);
    private DevicePart devicePart = new DevicePart(manufacturerName, manufacturerPartNumber, devices);

    @Test
    public void equals_nullObject_notEqual() {
        // GIVEN - other object is null
        Object other = null;

        // WHEN - equals method called with other object
        boolean isEqual = devicePart.equals(other);

        // THEN - false returned
        assertFalse(isEqual);
    }

    @Test
    public void equals_sameObject_equal() {
        // GIVEN - other object is the same as the object equals is being called on
        Object other = devicePart;

        // WHEN - equals method called with other object
        boolean isEqual = devicePart.equals(other);

        // THEN - true returned
        assertTrue(isEqual);
    }

    @Test
    public void equals_differentClass_notEqual() {
        // GIVEN - other object is of a different class than device part
        Object other = "This is a string";

        // WHEN - equals method called with other object
        boolean isEqual = devicePart.equals(other);

        // THEN - false returned
        assertFalse(isEqual);
    }

    @Test
    public void equals_differentManufacturerPartNumber_notEqual() {
        // GIVEN - other object has a different manufacturer part number
        Object other = new DevicePart(manufacturerName, "ADK38KSK2KS89", devices);

        // WHEN - equals method called with other object
        boolean isEqual = devicePart.equals(other);

        // THEN - false returned
        assertFalse(isEqual);
    }

    @Test
    public void equals_differentManufacturer_notEqual() {
        // GIVEN - other object has a different manufacturer
        Object other = new DevicePart("Coolest Manufacturer", manufacturerPartNumber, devices);

        // WHEN - equals method called with other object
        boolean isEqual = devicePart.equals(other);

        // THEN - false returned
        assertFalse(isEqual);
    }

    @Test
    public void equals_sameManufacturerAndPartNumber_equal() {
        // GIVEN - other object has the same manufacturer and part number
        Object other = new DevicePart(manufacturerName, manufacturerPartNumber, new ArrayList<>());

        // WHEN - equals method called with other object
        boolean isEqual = devicePart.equals(other);

        // THEN - true returned
        assertTrue(isEqual);
    }

    @Test
    public void hashCode_equalObjects_returnSameHashCode() {
        // GIVEN - other object has the same manufacturer and part number
        DevicePart other = new DevicePart(manufacturerName, manufacturerPartNumber, new ArrayList<>());

        // WHEN - hashCode called on each object
        int devicePartHashCode = devicePart.hashCode();
        int otherHashCode = other.hashCode();

        // THEN - hashCode values are equal
        assertEquals(devicePartHashCode, otherHashCode);
    }

    @Test
    public void hashCode_notEqualObject_returnDifferentHashCodes() {
        // GIVEN - other object has different manufacturer
        DevicePart other = new DevicePart("Coolest Manufacturer", manufacturerPartNumber, devices);

        // WHEN - hashCode called on each object
        int devicePartHashCode = devicePart.hashCode();
        int otherHashCode = other.hashCode();

        // THEN - hashCode values are not equal
        assertNotEquals(devicePartHashCode, otherHashCode);
    }

}