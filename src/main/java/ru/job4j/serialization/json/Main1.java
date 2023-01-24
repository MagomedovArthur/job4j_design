package ru.job4j.serialization.json;

import org.json.JSONObject;

public class Main1 {

    public static void main(String[] args) {
        PhoneOwner phoneOwner = new PhoneOwner("Artur", "Magomedov", 22);
        Phone iphone13Pro = new Phone(true, 2022, "9595NMY005",
                phoneOwner, new String[]{"Safari", "Fitness", "Chrome", "Photo"});

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("activated", iphone13Pro.isActivated());
        jsonObject.put("yearOfManufacture", iphone13Pro.getYearOfManufacture());
        jsonObject.put("serialNumber", iphone13Pro.getSerialNumber());
        jsonObject.put("phoneOwner", iphone13Pro.getPhoneOwner());
        jsonObject.put("installedApplications", iphone13Pro.getInstalledApplications());

        System.out.println(jsonObject.toString());
    }
}