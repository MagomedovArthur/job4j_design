package ru.job4j.ood.srp.hr;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.report.Report;
import ru.job4j.ood.srp.store.Store;

import java.util.*;
import java.util.function.Predicate;

public class HRDepartament implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public HRDepartament(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> listEmployees = store.findBy(filter);
        Collections.sort(listEmployees, Comparator.comparingDouble(Employee::getSalary)
                .reversed());
        for (Employee employee : listEmployees) {
            text.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}