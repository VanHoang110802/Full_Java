package service;

import java.util.ArrayList;
import model.Employee;

public class EmployeeService extends GenericService<Employee> implements ISearchable<Employee> {

    @Override
    public ArrayList<Employee> searchByName(String keyword) {
        ArrayList<Employee> result = new ArrayList<>();

        for (Employee e : list) {
            if (e.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(e);
            }
        }

        return result;
    }

    public ArrayList<Employee> filterSalaryRange(double min, double max) {
        ArrayList<Employee> result = new ArrayList<>();

        for (Employee e : list) {
            if (e.getSalary() > min && e.getSalary() < max) {
                result.add(e);
            }
        }

        return result;
    }
}
