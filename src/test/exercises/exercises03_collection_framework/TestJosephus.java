package test.exercises.exercises03_collection_framework;

import exercises.exercise03_collection_framework.Josephus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestJosephus {
    @Test
    void testNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            final Josephus josephus = new Josephus(null);
        });
    }

    @Test
    void testBadIllegalArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            final Josephus josephus = new Josephus(List.of("Alberich", "Brunhild"));
            final List<String> result = josephus.hailTheKing(0, 1);
        });
    }

    @Test
    void testHappyIllegalArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            final Josephus josephus = new Josephus(List.of("Alberich", "Brunhild"));
            final List<String> result = josephus.hailTheKing(1, 0);
        });
    }

    @Test
    void testBasic() {
        final Josephus josephus = new Josephus(List.of("Alberich", "Brunhild", "Claudius", "Dieter", "Edda", "Friedrich", "Gudrun", "Hagen"));

        final List<String> fst = josephus.hailTheKing(2, 1);
        Assertions.assertEquals(List.of("Alberich"), fst);

        final List<String> snd = josephus.hailTheKing(2, 1);
        Assertions.assertEquals(List.of("Alberich", "Edda"), snd);

        final List<String> thd = josephus.hailTheKing(1, 1);
        Assertions.assertEquals(List.of("Hagen"), thd);

        final List<String> fth = josephus.hailTheKing(1, 2);
        Assertions.assertEquals(List.of("Gudrun", "Hagen"), fth);
    }

    @Test
    void testSinglePrisoner() {
        final Josephus josephus = new Josephus(List.of("Alberich"));
        final List<String> result = josephus.hailTheKing(666, 42);
        Assertions.assertEquals(List.of("Alberich"), result);
    }

    @Test
    void testNoPrisoner() {
        final Josephus josephus = new Josephus(List.of());
        final List<String> result = josephus.hailTheKing(10, 10);
        Assertions.assertEquals(List.of(), result);
    }

    @Test
    void testTrick() {
        List<String> names = new ArrayList<>();
        names.add("Alberich");
        names.add("Brunhild");
        Josephus josephus = new Josephus(names);
        names.clear();

        final List<String> result = josephus.hailTheKing(3, 1);
        Assertions.assertEquals(List.of("Brunhild"), result);
    }
}
