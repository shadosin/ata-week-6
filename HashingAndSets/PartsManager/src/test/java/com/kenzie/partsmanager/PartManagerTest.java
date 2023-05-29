package com.kenzie.partsmanager;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

import com.kenzie.test.infrastructure.reflect.ClassQuery;
import com.kenzie.test.infrastructure.reflect.MethodQuery;
import com.kenzie.test.infrastructure.reflect.ConstructorQuery;

import static org.junit.jupiter.api.Assertions.*;

public class PartManagerTest {
    private static final String BASE_PACKAGE = "com.kenzie.partsmanager";

    private List<AmazonDevice> devices = Arrays.asList(AmazonDevice.ECHO_AUTO, AmazonDevice.ECHO_LOOP);
    private String manufacturerName = "Knowles";
    private String manufacturerPartNumber = "KAS-700-0147";
    private DevicePart devicePart = new DevicePart(manufacturerName, manufacturerPartNumber, devices);

    @Test
    public void partsmanager_removeSpecificPart_removesFoundPart() {
        // GIVEN

        // The Class Exists
        Class<?> partsManagerClass = assertDoesNotThrow( () -> ClassQuery.inContainingPackage(BASE_PACKAGE)
                .withExactSimpleName("PartManager")
                .findClassOrFail(), "The PartManager class must Exist");

        // The constructor exists
        Constructor constructor = assertDoesNotThrow( () -> ConstructorQuery.inClass(partsManagerClass).withNoArgs().findConstructor());

        // The removeSpecificPart Method in the Class Exists
        Method removeSpecificPartMethod = assertDoesNotThrow( () -> MethodQuery.inType(partsManagerClass)
                .withExactName("removeSpecificPart")
                .findMethodOrFail());
        
        PartManager partManager = new PartManager();
        partManager.addDevicePart(devicePart);

        assertEquals(partManager.getDeviceParts().size(), 1);

        partManager.removeSpecificPart(devicePart);
        assertEquals(partManager.getDeviceParts().size(), 0);
    }

    @Test
    public void partsmanager_class_isDevicePartIncluded_findsExistingPart() {
        // GIVEN

        // The Class Exists
        Class<?> partsManagerClass = assertDoesNotThrow( () -> ClassQuery.inContainingPackage(BASE_PACKAGE)
                .withExactSimpleName("PartManager")
                .findClassOrFail(), "The PartManager class must Exist");

        // The constructor exists
        Constructor constructor = assertDoesNotThrow( () -> ConstructorQuery.inClass(partsManagerClass).withNoArgs().findConstructor());

        // The removeSpecificPart Method in the Class Exists
        Method removeSpecificPartMethod = assertDoesNotThrow( () -> MethodQuery.inType(partsManagerClass)
                .withExactName("isDevicePartIncluded")
                .findMethodOrFail());

        PartManager partManager = new PartManager();
        partManager.addDevicePart(devicePart);

        assertTrue(partManager.isDevicePartIncluded(devicePart));
    }
}
