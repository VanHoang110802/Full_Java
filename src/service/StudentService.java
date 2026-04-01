package service;

import java.util.ArrayList;
import model.Student;

public class StudentService extends GenericService<Student> implements ISearchable<Student> {

    @Override
    public ArrayList<Student> searchByName(String keyword) {
        ArrayList<Student> result = new ArrayList<>();

        for (Student s : list) {
            if (s.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(s);
            }
        }

        return result;
    }

    public ArrayList<Student> filterScoreAbove5() {
        ArrayList<Student> result = new ArrayList<>();

        for (Student s : list) {
            if (s.getScore() > 5) {
                result.add(s);
            }
        }

        return result;
    }
}
