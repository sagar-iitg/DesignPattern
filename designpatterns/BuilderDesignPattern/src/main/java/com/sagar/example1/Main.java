package com.sagar.example1;



public class Main {
    public static void main(String[] args) {
        // Using the builder to construct a Student object
        Student student = new Student.StudentBuilder().setLastName("Doe")
                .setFirstName("John").setAddress("Ranchi")

                .setAge(25)
                .build();

        Student student1= Student.builder().setLastName("Doe")
                .setFirstName("Sagar").setAddress("Ranchi")

                .setAge(25)
                .build();

        // Displaying the details of the constructed Student object
        System.out.println(student);
        System.out.println(student1);

    }
}
