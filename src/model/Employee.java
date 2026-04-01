package model;

import java.time.LocalDate;

public class Employee extends Person {

    private double salary;

    public Employee() {
    }

    public Employee(double salary) {
        this.salary = salary;
    }

    public Employee(double salary, int id, String name, LocalDate dob, boolean gender, TyPe type) {
        super(id, name, dob, gender, type);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "salary=" + salary + '}';
    }

    

}
