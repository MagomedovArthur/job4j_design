package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class JSONReportTest {

    @Test
    void whenGetEmployee() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee ivan = new Employee("Ivan", now, now, 1000);
        store.add(ivan);
        Employee artur = new Employee("Arthur", now, now, 2000);
        store.add(artur);
        JSONReport js = new JSONReport(store);
        String expected = "[\n"
                + "  {\n"
                + "    \"name\": \"" + ivan.getName() + "\",\n"
                + "    \"hired\": {\n"
                + "      \"year\": " + now.get(Calendar.YEAR) + ",\n"
                + "      \"month\": " + now.get(Calendar.MONTH) + ",\n"
                + "      \"dayOfMonth\": " + now.get(Calendar.DAY_OF_MONTH) + ",\n"
                + "      \"hourOfDay\": " + now.get(Calendar.HOUR_OF_DAY) + ",\n"
                + "      \"minute\": " + now.get(Calendar.MINUTE) + ",\n"
                + "      \"second\": " + now.get(Calendar.SECOND) + "\n"
                + "    },\n"
                + "    \"fired\": {\n"
                + "      \"year\": " + now.get(Calendar.YEAR) + ",\n"
                + "      \"month\": " + now.get(Calendar.MONTH) + ",\n"
                + "      \"dayOfMonth\": " + now.get(Calendar.DAY_OF_MONTH) + ",\n"
                + "      \"hourOfDay\": " + now.get(Calendar.HOUR_OF_DAY) + ",\n"
                + "      \"minute\": " + now.get(Calendar.MINUTE) + ",\n"
                + "      \"second\": " + now.get(Calendar.SECOND) + "\n"
                + "    },\n"
                + "    \"salary\": " + ivan.getSalary() + "\n"
                + "  },\n"
                + "  {\n"
                + "    \"name\": \"" + artur.getName() + "\",\n"
                + "    \"hired\": {\n"
                + "      \"year\": " + now.get(Calendar.YEAR) + ",\n"
                + "      \"month\": " + now.get(Calendar.MONTH) + ",\n"
                + "      \"dayOfMonth\": " + now.get(Calendar.DAY_OF_MONTH) + ",\n"
                + "      \"hourOfDay\": " + now.get(Calendar.HOUR_OF_DAY) + ",\n"
                + "      \"minute\": " + now.get(Calendar.MINUTE) + ",\n"
                + "      \"second\": " + now.get(Calendar.SECOND) + "\n"
                + "    },\n"
                + "    \"fired\": {\n"
                + "      \"year\": " + now.get(Calendar.YEAR) + ",\n"
                + "      \"month\": " + now.get(Calendar.MONTH) + ",\n"
                + "      \"dayOfMonth\": " + now.get(Calendar.DAY_OF_MONTH) + ",\n"
                + "      \"hourOfDay\": " + now.get(Calendar.HOUR_OF_DAY) + ",\n"
                + "      \"minute\": " + now.get(Calendar.MINUTE) + ",\n"
                + "      \"second\": " + now.get(Calendar.SECOND) + "\n"
                + "    },\n"
                + "    \"salary\": " + artur.getSalary() + "\n"
                + "  }\n"
                + "]";
        assertThat(js.generate(e -> true)).isEqualTo(expected);
    }
}