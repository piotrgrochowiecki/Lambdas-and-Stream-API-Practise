package com.piotrgrochowiecki.service;

import com.piotrgrochowiecki.entitiy.Employee;

import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;

public class EmployeeService {

    Function<List<Employee>, Map<String, List<Employee>>> sortEmployeeByDepartmentFunction = employees -> employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));

    Function<List<Employee>, Double> calculateAverageSalaryFunction = employees -> employees.stream()
            .mapToDouble(Employee::getSalary)
            .average()
            .orElse(0.0);


    Function<List<Employee>, Map<String, Double>> getMapOfNamesAndSalariesFunction = employees -> employees.stream()
            .collect(Collectors.toMap(Employee::getName, Employee::getSalary));

    Function<List<Employee>, String> getMostCommonSkillFunction = employees -> employees.stream()
            .flatMap(employee -> employee.getSkills().stream())
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);

    BiFunction<Employee, Employee, List<String>> findCommonSkillsFunction = (e1 ,e2) -> e1.getSkills().stream()
            .filter(e2.getSkills()::contains)
            .collect(Collectors.toList());
}
