package model;

import java.time.LocalDate;

public class Student extends Person {

    private double score;

    public Student() {
    }

    public Student(double score) {
        this.score = score;
    }

    public Student(double score, int id, String name, LocalDate dob, boolean gender, TyPe type) {
        super(id, name, dob, gender, type);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" + "score=" + score + '}';
    }
    
    
}
