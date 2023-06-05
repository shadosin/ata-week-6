package com.kenzie.partsmanager;

import java.util.List;
import java.util.Objects;

public class DevicePart {
    private String manufacturer;
    private String manufacturersPartNumber;
    private List<AmazonDevice> devicesUsedIn;

    public DevicePart(String manufacturer, String manufacturersPartNumber, List<AmazonDevice> devicesUsedIn) {
        this.manufacturer = manufacturer;
        this.manufacturersPartNumber = manufacturersPartNumber;
        this.devicesUsedIn = devicesUsedIn;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getManufacturersPartNumber() {
        return manufacturersPartNumber;
    }

    public List<AmazonDevice> getDevicesUsedIn() {
        return devicesUsedIn;
    }

    public void setDevicesUsedIn(List<AmazonDevice> devicesUsedIn) {
        this.devicesUsedIn = devicesUsedIn;
    }

    public void addDeviceUsedIn(AmazonDevice amazonDevice) {
        devicesUsedIn.add(amazonDevice);
    }

    public void removeDeviceUsedIn(AmazonDevice amazonDevice) {
        devicesUsedIn.remove(amazonDevice);
    }

    @Override

    public String toString() {
        return String.format("Device Part: {manufacturer: %s, manufacturersPartNumber: %s, devicesUsedIn: %s}",
                manufacturer, manufacturersPartNumber, devicesUsedIn);
    }

    //TODO: Implement this method


    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        DevicePart that = (DevicePart) o;
        return Objects.equals(manufacturer, that.manufacturer) &&
                Objects.equals(manufacturersPartNumber, that.manufacturersPartNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getManufacturer(), getManufacturersPartNumber());
    }
}
