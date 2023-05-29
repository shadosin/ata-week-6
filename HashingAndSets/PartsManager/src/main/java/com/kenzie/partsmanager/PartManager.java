package com.kenzie.partsmanager;

import java.util.HashSet;
import java.util.Set;

public class PartManager {
    private Set<DevicePart> deviceParts = new HashSet<>();

    public void addDevicePart(DevicePart devicePart) {
        boolean isAdded = deviceParts.add(devicePart);
    }

    public void printDeviceParts() {
        for (DevicePart devicePart: deviceParts) {
            System.out.println(devicePart);
        }
    }

    public boolean isDevicePartIncluded(DevicePart toCheck){
        //TODO: Update this method to return true if a devicePart is included in the set
        return false;
    }

    public boolean removeSpecificPart(DevicePart toRemove){
        //TODO: Update this method to actually remove the devicePart
        return false;
    }

    public Set<DevicePart> getDeviceParts() {
        return deviceParts;
    }
}
