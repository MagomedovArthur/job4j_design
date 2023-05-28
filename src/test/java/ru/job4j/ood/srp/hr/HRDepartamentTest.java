package ru.job4j.ood.srp.hr;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

class HRDepartamentTest {
    @Test
    void listingEmployeesInDescendingOrderBySalary() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee ivan = new Employee("Ivan", now, now, 900);
        Employee magomed = new Employee("Magomed", now, now, 975);
        Employee ali = new Employee("Ali", now, now, 1000);
        Employee stepan = new Employee("Stepan", now, now, 899);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(ivan);
        store.add(magomed);
        store.add(ali);
        store.add(stepan);
        HRDepartament hr = new HRDepartament(store, parser);
        StringBuilder expected = new StringBuilder()
                .append(ali.getName()).append(" ").append(ali.getSalary())
                .append(System.lineSeparator())
                .append(magomed.getName()).append(" ").append(magomed.getSalary())
                .append(System.lineSeparator())
                .append(ivan.getName()).append(" ").append(ivan.getSalary())
                .append(System.lineSeparator())
                .append(stepan.getName()).append(" ").append(stepan.getSalary())
                .append(System.lineSeparator());
        assertThat(hr.generate(em -> true)).isEqualTo(expected.toString());
    }
}