package ru.job4j.serialization.xml;

import ru.job4j.serialization.json.PhoneOwner;

import java.util.Arrays;

public class Phone {

    private final boolean activated;
    private final int yearOfManufacture;
    private final String serialNumber;
    private final PhoneOwner phoneOwner;
    private final String[] installedApplicationses;

    public Phone(boolean activated, int yearOfManufacture,
                 String serialNumber, PhoneOwner phoneOwner,
                 String[] installedApplicationses) {
        this.activated = activated;
        this.yearOfManufacture = yearOfManufacture;
        this.serialNumber = serialNumber;
        this.phoneOwner = phoneOwner;
        this.installedApplicationses = installedApplicationses;
    }

    @Override
    public String toString() {
        return "Phone{"
                + "activated=" + activated
                + ", yearOfManufacture=" + yearOfManufacture
                + ", serialNumber='" + serialNumber + '\''
                + ", phoneOwner=" + phoneOwner
                + ", installedApplications=" + Arrays.toString(installedApplicationses)
                + '}';
    }

    public static void main(String[] args) {
        PhoneOwner phoneOwner = new PhoneOwner("Artur", "Magomedov", 22);
        Phone iphone13Pro = new Phone(true, 2022, "9595NMY005",
                phoneOwner, new String[]{"Safari", "Fitness", "Chrome", "Photo"});
    }
}