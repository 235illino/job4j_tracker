package stream;

import java.util.*;
import java.util.stream.Collectors;

public class Student {

    private int score;
    private String surname;

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    public Student(String surname, int score) {
        this.score = score;
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score &&
                surname.equals(student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surname);
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Aaaa", 99),
                new Student("Bbbb", 51),
                new Student("Cccc", 48),
                new Student("Ffff", 66),
                new Student("Gggg", 33),
                new Student("Kkkk", 77)
        );
        Map<String, Student> studentMap = students.stream().distinct().collect(Collectors.toMap(
                Student::getSurname,
                value -> value
        ));

        Collection<Student> st = studentMap.values();

        for (Student stu : st) {
            System.out.println(stu.score);
        }

        for (Map.Entry<String, Student> item : studentMap.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue().getScore());
        }
    }

}
