package com.piotrgrochowiecki.service;

import com.piotrgrochowiecki.entitiy.Person;

import java.util.Comparator;
import java.util.Random;
import java.util.function.*;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class PersonService {

    Comparator<Person> PeopleByAgeAscendingComparator = (Person p1, Person p2) -> Integer.compare(p1.getAge(), p2.getAge());

    Function<Person, String> PersonToNameFunction = Person::getName;

    Supplier<Person> randomPersonSupplier = () -> {
        String[] names = {"Alice", "Bob", "Charlie", "Dave", "Eve"};
        String[] addresses = {"123 Main St", "456 Elm St", "789 Oak St", "246 Maple St", "135 Pine St"};

        Random random = new Random();

        String name = names[random.nextInt(names.length)];
        String address = addresses[random.nextInt(addresses.length)];
        Integer age = random.nextInt(12, 75);

        return new Person(name, age, address);
    };

    BiFunction<Person, Person, Double> averageAgeOfTwoPeopleFunction = (p1, p2) -> (double) (Math.addExact(p1.getAge(), p2.getAge())/ 2);

    BiConsumer<Person, Person> swapPeoplesNamesConsumer = (person1, person2) -> {
        String personOneName = person1.getName();
        String personTwoName = person2.getName();
        person1.setName(personTwoName);
        person2.setName(personOneName);
    };

    ToLongBiFunction<Person, Person> differenceInPeoplesAgeFunction = ((person1, person2) -> Math.abs(person1.getAge() - person2.getAge()));

    ObjIntConsumer<Person> setPersonAgeConsumer = (person, age) -> person.setAge(age);

}
