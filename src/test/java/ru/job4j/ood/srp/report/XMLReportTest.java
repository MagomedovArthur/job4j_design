package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class XMLReportTest {

    @Test
    void generate() throws Exception {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee ivan = new Employee("Ivan", now, now, 1000);
        store.add(ivan);
        Employee artur = new Employee("Arthur", now, now, 2000);
        store.add(artur);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        String formattedDate = dateFormat.format(now.getTime());
        XMLReport xml = new XMLReport(store);
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<employees>\n"
                + "    <employees>\n"
                + "        <fired>" + formattedDate + "</fired>\n"
                + "        <hired>" + formattedDate + "</hired>\n"
                + "        <name>" + ivan.getName() + "</name>\n"
                + "        <salary>" + ivan.getSalary() + "</salary>\n"
                + "    </employees>\n"
                + "    <employees>\n"
                + "        <fired>" + formattedDate + "</fired>\n"
                + "        <hired>" + formattedDate + "</hired>\n"
                + "        <name>" + artur.getName() + "</name>\n"
                + "        <salary>" + artur.getSalary() + "</salary>\n"
                + "    </employees>\n"
                + "</employees>\n";
        assertThat(xml.generate(e -> true)).isEqualTo(expected);
    }
}