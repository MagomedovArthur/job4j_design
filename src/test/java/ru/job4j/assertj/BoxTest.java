package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isNotNull()
                .startsWith("Sp")
                .isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 12);
        String name = box.whatsThis();
        assertThat(name).startsWith("Cu")
                .isNotNull()
                .isEqualTo("Cube");
    }

    @Test
    void numberOfVerticesIs8() {
        Box box = new Box(8, 12);
        int numberOfVertices = box.getNumberOfVertices();
        assertThat(numberOfVertices).isNotZero()
                .isEqualTo(8);
    }

    @Test
    void numberOfVerticesIsZero() {
        Box box = new Box(0, 10);
        int numberOfVertices = box.getNumberOfVertices();
        assertThat(numberOfVertices).isZero()
                .isEqualTo(0);
    }

    @Test
    void isExist() {
        Box box = new Box(0, 10);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void isNotExist() {
        Box box = new Box(12, 12);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void cubeArea() {
        Box box = new Box(8, 12);
        double area = box.getArea();
        assertThat(area).isEqualTo(864.0D);
    }

}