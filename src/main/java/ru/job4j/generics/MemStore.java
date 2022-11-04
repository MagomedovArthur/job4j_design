package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> storage = new HashMap<>();

    @Override
    public void add(T model) {
        if (!storage.containsValue(model) && !storage.containsKey(model.getId())) {
            storage.put(model.getId(), model);
        }
    }

    @Override
    public boolean replace(String id, T model) {
//        if (!storage.containsValue(model) && storage.containsKey(id)) {
//            storage.put(id, model);
//            return true;
//        }
//        return false;
        // return delete(id) && mem.put(model.getId(), model) == model;
        //return delete(id) && storage.put(model.getId(), model) == model;
        return storage.put(id, model) == storage.get(id);
    }

    @Override
    public boolean delete(String id) {
        return storage.remove(id) != null;
    }

    @Override
    public T findById(String id) {
        return storage.get(id);
    }
}