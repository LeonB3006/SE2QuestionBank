package test.exercises.exercises03_collection_framework;

import exercises.exercise03_collection_framework.TheThinLine;
import exercises.exercise03_collection_framework.ThinLine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTheThinLine {
    @Test
    void testRead() {
        ThinLine<Integer> thinLine = new TheThinLine<>(0);
        thinLine.insert(5, 20);
        Assertions.assertEquals(20, thinLine.read(5));
    }

    @Test
    void testReadIllegalArgument() {
        ThinLine<Integer> thinLine = new TheThinLine<>(0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            thinLine.read(-1);
        });
    }

    @Test
    void testReplace() {
        ThinLine<Integer> thinLine = new TheThinLine<>(0);
        thinLine.replace(1, 1);
        thinLine.replace(1, 20);
        Assertions.assertEquals(20, thinLine.read(1));
    }

    @Test
    void testReplaceIllegalArgument() {
        ThinLine<Integer> thinLine = new TheThinLine<>(0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            thinLine.replace(-1, 20);
        });
    }

    @Test
    void testInsert() {
        ThinLine<Integer> thinLine = new TheThinLine<>(0);
        thinLine.insert(2, 25);
        Assertions.assertEquals(25, thinLine.read(2));
    }

    @Test
    void testInsertIllegalArgument() {
        ThinLine<Integer> thinLine = new TheThinLine<>(0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            thinLine.insert(-1, 20);
        });
    }

    @Test
    void testDelete() {
        ThinLine<Integer> thinLine = new TheThinLine<>(0);
        thinLine.insert(4, 20);
        thinLine.delete(4);
        Assertions.assertEquals(0, thinLine.read(4));
    }

    @Test
    void testDeleteIllegalArgument() {
        ThinLine<Integer> thinLine = new TheThinLine<>(0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            thinLine.delete(-1);
        });
    }

    @Test
    void testLastAtEmpty() {
        ThinLine<Integer> thinLine = new TheThinLine<>(0);
        Assertions.assertEquals(-1, thinLine.lastAt());
    }

    @Test
    void testLastAt() {
        ThinLine<Integer> thinLine = new TheThinLine<>(0);
        thinLine.insert(4, 20);
        Assertions.assertEquals(4, thinLine.lastAt());
    }
}
