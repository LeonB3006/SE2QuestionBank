package presentations.streams;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsSummary {



    public static void main(String[] args) {

        List<Integer> myList = List.of(1,2,3,4);

        // Generator -> Inter. -> Terminal

        /*** How to use Optional<*> ***/

//        Optional<Person> myDude = Optional.of(null);

        Optional<Person> myGuy = Optional.of(new Person(19));

//        if (myDude.isPresent()) {
//            System.out.println(myDude.get().age()); // Won't Print
//        }

//        if (myGuy.isPresent()) {
//            System.out.println(myGuy.get().age()); // WIll Print
//        }

//        System.out.println(myDude.isPresent());

//        IntStream.range(20,30).mapToObj(Person::new).filter(obj -> obj.age() < 10).findAny().orElse(new Person(0));




        /*** Generator ***/

        myList.stream().forEach(System.out::println);

        Stream.of("hi", "im", "a", "stream").forEach(System.out::println);

        Stream.iterate(1, i -> i +1).limit(100).forEach(System.out::println);

        Stream.generate(ArrayList<Integer>::new).limit(10).forEach(aList -> System.out.println(aList.size()));


        /*** Intermediate ***/

        // Map
        Stream.iterate(0, num -> num +2).takeWhile(theNum -> theNum <= 100).map(aNum -> aNum -1).forEach(System.out::println);

        // Flatmap
        List<List<Integer>> unflattenedList = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(1,3,3),
                Arrays.asList(1,2,3,4,5)
                );

        unflattenedList.stream().forEach(System.out::println);
        unflattenedList.stream().flatMap(listItem -> listItem.stream()).forEach(System.out::println);

        Stream.iterate(1, num -> num*10).filter(num -> num > 1000).limit(5).flatMap(num ->
                Stream.of(new ArrayList<>(Arrays.asList(num)))).forEach(System.out::println);


        // Peek

        Stream.of("im", "a", "Stream").filter(word -> word.length() > 2).peek(System.out::println).findAny();

        //Limit

        Stream.generate( ArrayList<Integer>::new).limit(5).forEach(System.out::println);


        //Skip

        unflattenedList.stream().skip(1).forEach(System.out::println);

        //Sorted()

        new Random().ints(100, 1, 100).sorted().boxed().toList();

        //Distinct()
        new Random().ints(100, 1, 100).distinct().boxed().toList();


        /*** Terminal ***/

        // Findfirst vs FindAny: The difference only becomes noticeable when working with Parallel Streams
        List<String> lst1 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill","Dany","Julia","Jenish","Divya");
        List<String> lst2 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill","Dany","Julia","Jenish","Divya");

        lst1.parallelStream().filter(s -> s.startsWith("D")).findFirst().stream().forEach(System.out::println);
        lst2.parallelStream().filter(s -> s.startsWith("J")).findAny().stream().forEach(System.out::println);


        // toList()
        Stream.iterate(1, i -> i*2 + 1 ).limit(100).toList().stream().forEach(System.out::println);

        // collect()
        IntStream.range(10, 30).mapToObj(Person::new).collect(Collectors.toCollection(ArrayList::new)).stream().forEach(System.out::println);

        // Reduce()
        System.out.println(IntStream.range(1, 6).reduce(1, (a, b) -> a + b)); // = 5!




    }





}
