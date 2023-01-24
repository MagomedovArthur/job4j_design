package ru.job4j.serialization.json;

public class PhoneOwner {

    private final String name;
    private final String lastName;
    private final int age;

    public PhoneOwner(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "PhoneOwner{"
                + "name='" + name + '\''
                + ", lastName='" + lastName + '\''
                + ", age=" + age
                + '}';
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}