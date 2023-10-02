package org.example.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 模板模式在 Collections 类中的应用
 * @author chensh
 * @datetime 2023/10/2 3:02 PM
 */
public class CollectionSort {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 19, 89));
        students.add(new Student("Peter", 20, 78));
        students.add(new Student("Leo", 18, 99));

        Collections.sort(students, new AgeAscComparator());
        print(students);

        Collections.sort(students, new NameAscComparator());
        print(students);

        Collections.sort(students, new ScoreDescComparator());
        print(students);
    }

    public static void print(List<Student> students) {
        for (Student s : students) {
            System.out.println(s.getName() + " " + s.getAge() + " " + s.getScore());
        }
    }

    public static class AgeAscComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getAge() - o2.getAge();
        }
    }

    public static class NameAscComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public static class ScoreDescComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            if (Math.abs(o1.getScore() - o2.getScore()) < 0.001) {
                return 0;
            } else if (o1.getScore() < o2.getScore()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    private static class Student {
        private Integer age;
        private String name;
        private Integer score;
        public Student(String name, Integer age, Integer score) {
            this.age = age;
            this.name = name;
            this.score = score;
        }
        public Integer getAge() {
            return age;
        }
        public void setAge(Integer age) {
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Integer getScore() {
            return score;
        }
        public void setScore(Integer score) {
            this.score = score;
        }
    }
}