package com.praveen.springguru.rest_app.rest;

import com.praveen.springguru.rest_app.entity.Student;
import com.praveen.springguru.rest_app.error.exceptions.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;


    /**
     * This method is responsible for loading the list of students.
     * It initializes the "students" list with three pre-defined Student objects.
     *
     * The method is annotated with @PostConstruct, indicating that it should be
     * called after the bean initialization is complete.
     *
     * Example usage:
     *
     *   StudentRestController studentController = new StudentRestController();
     *   studentController.loadStudents();
     *
     * After calling this method, the "students" list in the StudentRestController
     * object will contain three Student objects with pre-defined details.
     *
     * Note: This method does not return anything.
     */
    @PostConstruct
    public void loadStudents() {
        students = new ArrayList<>();
        students.add(new Student(1,"Praveen","Kumar"));
        students.add(new Student(2,"Manu","Prasad"));
        students.add(new Student(3, "Paul","Pradeep"));
    }

    /**
     * Retrieves the list of students.
     *
     * This method returns a List of Student objects. It retrieves the "students" list,
     * which contains the pre-defined Student objects. The list is initialized by the
     * loadStudents() method, which is called after the bean initialization is complete.
     *
     * Example usage:
     * <pre>{@code
     * StudentRestController studentController = new StudentRestController();
     * List<Student> students = studentController.getStudents();
     * }</pre>
     *
     * @return a List of Student objects representing the students.
     */
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Retrieves a student with the specified ID.
     *
     * This method takes in an integer value representing the student's ID and returns the corresponding Student object.
     * It searches for the student in the "students" list by filtering the list based on the student ID. If a match is found,
     * the first matching student object is returned. If no student is found with the specified ID, a StudentNotFoundException
     * is thrown.
     *
     * Example usage:
     * <pre>{@code
     * StudentRestController studentController = new StudentRestController();
     * int studentId = 1;
     * Student student = studentController.getStudent(studentId);
     * }</pre>
     *
     * @param studentId the ID of the student to retrieve.
     * @return the Student object corresponding to the given student ID.
     * @throws StudentNotFoundException if no student is found with the specified ID.
     */
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        Student studentOb = students.stream()
                .filter(student -> student.getId() == studentId)
                .findFirst()
                .orElse(null);
        if(studentOb == null)
                throw new StudentNotFoundException("student id not found : " + studentId);
        return studentOb;
    }

}
