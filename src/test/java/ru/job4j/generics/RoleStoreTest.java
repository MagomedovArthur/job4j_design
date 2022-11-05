package ru.job4j.generics;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RoleStoreTest {

    @Test
    void whenAddAndFindRoleName() {
        RoleStore store = new RoleStore();
        store.add(new Role("05", "Husband"));
        Role rsl = store.findById("05");
        assertThat(rsl.getName()).isEqualTo("Husband");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("06", "Wife"));
        Role rsl = store.findById("05");
        assertThat(rsl).isNull();
    }

    @Test
    void whenReplaceRoleOfDaughterToSon() {
        RoleStore store = new RoleStore();
        store.add(new Role("7", "Daughter"));
        store.replace("7", new Role("7", "Son"));
        Role rsl = store.findById("7");
        assertThat(rsl.getName()).isEqualTo("Son");
    }

    @Test
    void whenDeleteRole() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Wife"));
        store.delete("1");
        Role rsl = store.findById("1");
        assertThat(rsl).isNull();
    }
}