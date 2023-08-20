package com.piotrgrochowiecki.entitiy;

import java.util.List;

public class Employee {

    private String name;
    private int age;
    private String department;
    private double salary;
    private List<String> skills;

    public Employee(String name, int age, String department, double salary, List<String> skills) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;

        if (getAge() != employee.getAge()) return false;
        if (Double.compare(getSalary(), employee.getSalary()) != 0) return false;
        if (getName() != null ? !getName().equals(employee.getName()) : employee.getName() != null) return false;
        if (getDepartment() != null ? !getDepartment().equals(employee.getDepartment()) : employee.getDepartment() != null)
            return false;
        return getSkills() != null ? getSkills().equals(employee.getSkills()) : employee.getSkills() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getAge();
        result = 31 * result + (getDepartment() != null ? getDepartment().hashCode() : 0);
        temp = Double.doubleToLongBits(getSalary());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getSkills() != null ? getSkills().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", skills=" + skills +
                '}';
    }
}
