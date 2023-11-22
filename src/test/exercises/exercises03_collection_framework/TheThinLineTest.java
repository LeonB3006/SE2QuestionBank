package test.exercises.exercises03_collection_framework;



import exercises.exercise03_collection_framework.TheThinLine;
import exercises.exercise03_collection_framework.ThinLine;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

public class TheThinLineTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(1_000);

    final ThinLine<Integer> many = new TheThinLine<>(0);


    @Test
    public void replaceSuccessfully(){
        final int want = 1;
        final ThinLine<Integer> many = new TheThinLine<>(0);

        many.replace(1, 1);
        int have = many.read(1);

        assertEquals(want, have);
    }

    @Test
    public void insert(){
        final int want1 = 2;
        final int want2 = 1;
        final ThinLine<Integer> many = new TheThinLine<>(0);

        many.replace(2_000_000, 1);
        many.insert(2_000_000, 2);

        int have1 = many.read(2_000_000);
        int have2 = many.read(2_000_001);


        assertEquals(want1, have1);
        assertEquals(want2, have2);
    }

    @Test
    public void readNull(){
        final String want = null;
        final ThinLine<String> many = new TheThinLine<>();
        String have = many.read(1);

        assertEquals(want, have);
    }

    @Test
    public void deleteAndAtLast(){
        final int want1 = 2;
        final int want2 = 0;
        final int want3 = 2_000_000;
        final ThinLine<Integer> many = new TheThinLine<>(0);

        many.replace(2_000_000, 1);
        many.insert(2_000_000, 2);
        many.delete(5);


        int have1 = many.read(1_999_999);
        int have2 = many.read(2_000_001);
        int have3 = many.lastAt();


        assertEquals(want1, have1);
        assertEquals(want2, have2);
        assertEquals(want3, have3);
    }

    @Test
    public void delete(){
        final int want = 2;
        final ThinLine<Integer> many = new TheThinLine<>(0);

        many.replace(2_000_000, 1);
        many.insert(2_000_000, 2);


        int have = many.delete(2_000_000);

        assertEquals(want, have);

    }





}

