package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "phone")
@XmlAccessorType(XmlAccessType.FIELD)
public class Phone {

    @XmlAttribute
    private boolean activated;
    @XmlAttribute
    private int yearOfManufacture;
    @XmlAttribute
    private String serialNumber;
    private PhoneOwner phoneOwner;
    private String[] installedApplicationses;

    public Phone() {
    }

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

    public static void main(String[] args) throws JAXBException {
        PhoneOwner phoneOwner = new PhoneOwner("Artur", "Magomedov", 22);
        Phone iphone13Pro = new Phone(true, 2022, "9595NMY005",
                phoneOwner, new String[]{"Safari", "Fitness", "Chrome", "Photo"});

        JAXBContext context = JAXBContext.newInstance(Phone.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(iphone13Pro, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}