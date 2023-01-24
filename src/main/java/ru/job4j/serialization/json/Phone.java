package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Phone {

    private final boolean activated;
    private final int yearOfManufacture;
    private final String serialNumber;
    private final PhoneOwner phoneOwner;
    private final String[] installedApplications;

    public Phone(boolean activated, int yearOfManufacture,
                 String serialNumber, PhoneOwner phoneOwner,
                 String[] installedApplications) {
        this.activated = activated;
        this.yearOfManufacture = yearOfManufacture;
        this.serialNumber = serialNumber;
        this.phoneOwner = phoneOwner;
        this.installedApplications = installedApplications;
    }

    @Override
    public String toString() {
        return "Phone{"
                + "activated=" + activated
                + ", yearOfManufacture=" + yearOfManufacture
                + ", serialNumber='" + serialNumber + '\''
                + ", phoneOwner=" + phoneOwner
                + ", installedApplications=" + Arrays.toString(installedApplications)
                + '}';
    }

    public boolean isActivated() {
        return activated;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public PhoneOwner getPhoneOwner() {
        return phoneOwner;
    }

    public String[] getInstalledApplications() {
        return installedApplications;
    }

    public static void main(String[] args) {
        PhoneOwner phoneOwner = new PhoneOwner("Artur", "Magomedov", 22);
        Phone iphone13Pro = new Phone(true, 2022, "9595NMY005",
                                       phoneOwner, new String[]{"Safari", "Fitness", "Chrome", "Photo"});

        /* Преобразовние объекта iphone13Pro в json-строку. */
        Gson gson = new GsonBuilder().create();
        final String phoneJSON = gson.toJson(iphone13Pro);
        System.out.println(gson.toJson(iphone13Pro));

        /* Извлечение объекта iphone13Pro из json-строки. */
        Phone phone = gson.fromJson(phoneJSON, Phone.class);
        System.out.println(phone);
    }
}
