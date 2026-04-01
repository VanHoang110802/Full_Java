package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import model.Employee;
import model.Person;
import model.Student;
import service.EmployeeService;
import service.StudentService;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StudentService studentService = new StudentService();
        EmployeeService employeeService = new EmployeeService();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them");
            System.out.println("2. Hien thi");
            System.out.println("3. Tim theo ten");
            System.out.println("4. Loc");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Ten: ");
                    String name = sc.nextLine();

                    System.out.print("Nam sinh (yyyy-mm-dd): ");
                    LocalDate dob = LocalDate.parse(sc.nextLine());

                    System.out.print("Gioi tinh (true=Nam, false=Nu): ");
                    boolean gender = Boolean.parseBoolean(sc.nextLine());

                    System.out.println("1. Sinh vien | 2. Nhan vien");
                    int type = Integer.parseInt(sc.nextLine());

                    if (type == 1) {
                        System.out.print("Diem: ");
                        double score = Double.parseDouble(sc.nextLine());

                        studentService.add(new Student(score, id, name, dob, gender, Person.TyPe.SINH_VIEN));
                    } else {
                        System.out.print("Luong: ");
                        double salary = Double.parseDouble(sc.nextLine());

                        employeeService.add(new Employee(salary, id, name, dob, gender, Person.TyPe.NHAN_VIEN));
                    }
                    break;

                case 2:
                    System.out.println("=== Sinh vien ===");
                    for (Student s : studentService.getAll()) {
                        System.out.println(s);
                    }

                    System.out.println("=== Nhan vien ===");
                    for (Employee e : employeeService.getAll()) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    System.out.print("Nhap ten can tim: ");
                    String keyword = sc.nextLine();

                    System.out.println("=== Sinh vien ===");
                    ArrayList<Student> svList = studentService.searchByName(keyword);
                    for (Student s : svList) {
                        System.out.println(s);
                    }

                    System.out.println("=== Nhan vien ===");
                    ArrayList<Employee> nvList = employeeService.searchByName(keyword);
                    for (Employee e : nvList) {
                        System.out.println(e);
                    }
                    break;

                case 4:
                    System.out.println("1. Loc SV (diem > 5)");
                    System.out.println("2. Loc NV (luong trong khoang)");
                    int sub = Integer.parseInt(sc.nextLine());

                    if (sub == 1) {
                        for (Student s : studentService.filterScoreAbove5()) {
                            System.out.println(s);
                        }
                    } else {
                        System.out.print("Min: ");
                        double min = Double.parseDouble(sc.nextLine());

                        System.out.print("Max: ");
                        double max = Double.parseDouble(sc.nextLine());

                        for (Employee e : employeeService.filterSalaryRange(min, max)) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }
            if (choice == 0) {
                break;
            }
        }
    }
}
