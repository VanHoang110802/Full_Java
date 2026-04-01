package model;

import java.time.LocalDate;

public class Person {

    private int id;
    private String name;
    private LocalDate dob;
    private boolean gender;
    private TyPe type;

    public enum TyPe {
        SINH_VIEN,
        NHAN_VIEN
    }

    public Person() {
    }

    public Person(int id, String name, LocalDate dob, boolean gender, TyPe type) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public TyPe getType() {
        return type;
    }

    public void setType(TyPe type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", type=" + type + '}';
    }
    
    
}
