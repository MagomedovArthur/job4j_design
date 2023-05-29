package ru.job4j.ood.ocp.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.report.Report;
import ru.job4j.ood.srp.store.Store;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class JSONSerializationFormat implements Report {

    private final String PATH = "src/main/java/ru/job4j/ood/ocp/serialization/files/inputoutput.json";
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public JSONSerializationFormat(Store store, DateTimeParser<Calendar> dateTimeParser,
                                   Predicate<Employee> filter) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        writingDataToJsonFile(filter);
    }

    private void writingDataToJsonFile(Predicate<Employee> filter) {
        List<Employee> listEmployees = store.findBy(filter);
        var createJson = new GsonBuilder().setPrettyPrinting().create();
        String json = createJson.toJson(listEmployees);
        try (FileWriter writer = new FileWriter(PATH)) {
            writer.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*      Считываем JSON файл и клеим строку     */
    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder result = new StringBuilder();
        var gson = new Gson();
        try (FileReader reader = new FileReader(PATH)) {
            var employeeListType = new TypeToken<List<Employee>>(){}.getType();
            List<Employee> employees = gson.fromJson(reader, employeeListType);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

/*
        for (Employee employee : store.findBy(filter)) {
            result.append(employee.getName()).append(" ")
                    .append(dateTimeParser.parse(employee.getHired())).append(" ")
                    .append(dateTimeParser.parse(employee.getFired())).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }

 */
        return result.toString();
    }
}