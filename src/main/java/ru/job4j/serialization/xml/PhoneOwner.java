package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "owner")
public class PhoneOwner {

    @XmlAttribute
    private String name;
    @XmlAttribute
    private String lastName;
    @XmlAttribute
    private int age;

    public PhoneOwner() {
    }

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
}