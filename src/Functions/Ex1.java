package Functions;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex1 {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = i -> i%2 ==0;
        Predicate<Integer> isNegative = i -> i<0;
       boolean b= isPositive.or(isNegative).test(3);
        System.out.println(b);


        /*Person person = new Person("Zheka");
        Function<Person, String> getName = Person::getName;
        String s =getName.apply(person);*/

        //Supplier поставщик ()-> Person
        Supplier<Person> createPerson= Person::new;
        Person person = createPerson.get();
        System.out.println(person.toString());


        //Consumer
        Consumer<Person> hello = p-> System.out.printf("Hello %s!%n", p.getName());
        hello.accept(new Person("Ivan "));

        Comparator<Person> comparator = (p1, p2)-> p1.getName().compareTo(p2.getName());
        Person person1 = new Person("John");
        Person person2 = new Person("Alice");

        System.out.println(comparator.compare(person1,person2));


        //Optional контейнер
        Optional<String> empty = Optional.empty();
        if(!empty.isEmpty())
            System.out.println(empty.get());

        Optional<String> noEmpty= Optional.of("");
        System.out.println(noEmpty.isPresent());

        Optional<String>  nullable = Optional.ofNullable(null);
        System.out.println(nullable.isPresent());





    }
}
class Person{
    String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
         return name;
    }
    public Person() {

    }


}