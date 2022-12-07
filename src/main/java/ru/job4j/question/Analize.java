package ru.job4j.question;

import java.util.HashMap;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        final HashMap<Integer, User> mapCurrent = new HashMap<>(current.size());
        current.forEach(user -> mapCurrent.put(user.getId(), user));
        int added = current.size();
        int deleted = 0;
        int changed = 0;
        for (User prev : previous) {
            final User user = mapCurrent.get(prev.getId());
            if (user != null) {
                added--;
                if (!prev.equals(user)) {
                    changed++;
                }
            } else {
                deleted++;
            }
        }
        return new Info(added, changed, deleted);
    }
}