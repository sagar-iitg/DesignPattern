package com.sagar.example1;

// Product class
class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String address;

    // private constructor to enforce the use of the builder
    private Student() {}

    // getters

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    // Static Builder class
    public static class StudentBuilder {
        private Student student = new Student();

        // methods to set properties in the builder

        public StudentBuilder setFirstName(String firstName) {
            student.firstName = firstName;
            return this;
        }

        public StudentBuilder setLastName(String lastName) {
            student.lastName = lastName;
            return this;
        }

        public StudentBuilder setAge(int age) {
            student.age = age;
            return this;
        }

        public StudentBuilder setAddress(String address) {
            student.address = address;
            return this;
        }

        // method to build the final object
        public Student build() {
            return student;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Using the builder to construct a Student object
        Student student = new Student.StudentBuilder()
                .setFirstName("John")
                .setLastName("Doe")
                .setAge(25)
                .setAddress("123 Main Street")
                .build();

        // Displaying the details of the constructed Student object
        System.out.println("Student Details:");
        System.out.println("First Name: " + student.getFirstName());
        System.out.println("Last Name: " + student.getLastName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Address: " + student.getAddress());
    }
}
