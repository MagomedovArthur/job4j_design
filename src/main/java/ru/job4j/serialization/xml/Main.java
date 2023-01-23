package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        PhoneOwner phoneOwner = new PhoneOwner("Artur", "Magomedov", 22);
        Phone iphone13Pro = new Phone(true, 2022, "9595NMY005",
                phoneOwner, new String[]{"Safari", "Fitness", "Chrome", "Photo"});

        /* Получаем контекст для доступа к АПИ */
        JAXBContext context = JAXBContext.newInstance(Phone.class);
        /* Создаем сериализатор */
        Marshaller marshaller = context.createMarshaller();
        /* Указываем, что нам нужно форматирование */
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            /* Сериализуем */
            marshaller.marshal(iphone13Pro, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        /* Для десериализации нам нужно создать десериализатор */
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            /* десериализуем */
            Phone result = (Phone) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}