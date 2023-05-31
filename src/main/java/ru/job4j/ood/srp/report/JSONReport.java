package ru.job4j.ood.srp.report;

import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.function.Predicate;

public class JSONReport implements Report {

    private final Store store;

    public JSONReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        var result = new GsonBuilder()
                .setDateFormat("dd:MM:yyyy HH:mm")
                .setPrettyPrinting().
                create();
        return result.toJson(store.findBy(filter));
    }
}