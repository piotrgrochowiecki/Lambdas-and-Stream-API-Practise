package com.piotrgrochowiecki.service;

import com.piotrgrochowiecki.entitiy.Person;

import java.util.Comparator;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
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
}
