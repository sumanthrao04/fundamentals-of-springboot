package com.sumanth.fundamentals_of_springboot.project1.controller;


import com.sumanth.fundamentals_of_springboot.project1.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    //HTTP Get Request
    //http://localhost:8080/api/helloWorld

    @GetMapping("helloWorld")
    public String helloWorld(){
        return "Hello-Wolrd";
    }


    //Java Bean As Json
    // http://localhost:8080/api/singleStudent
    @GetMapping("/singleStudent")
    public ResponseEntity<Student>  getSingleStudent(){
        Student student = new Student(1,"Sumanth","Parashuram");
        return new ResponseEntity<>(student, HttpStatusCode.valueOf(200));
    }

    //List of student As Json
    // http://localhost/api/allStudents
    @GetMapping("/allStudents")
    public ResponseEntity<List<Student>>  getAllStudents(){
        List<Student> students  = new ArrayList<>();
       students.add(new Student(1,"Sumanth","Parashuram"));
       students.add(new Student(2,"Karthik","K"));
       students.add(new Student(3,"Pradeep","Dudani"));
        students.add(new Student(4,"Sanjay","Vamshi"));
       return ResponseEntity.ok(students);
    }

    //Spring boot REST API with Path Variable
    //{} - URI Template Variable
    //http://localhost:8080/api/dynamicStudent/{id}/{first-name}/{last-name}
    @GetMapping("/dynamicStudent/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student>  getDynamicStudent(@PathVariable("id") int studentId,
                                    @PathVariable("first-name") String FirstName,
                                    @PathVariable("last-name") String lastName){
        Student student = new Student(studentId,FirstName,lastName );
        return ResponseEntity.ok()
                .header("Student-Status","REST API with Path Variable")
                .body(student);

    }



    // springboot REST API with Request Param
    // http://localhost:8080/api/studentByQuery?id=1&firstname=sumanth&lastname=parashuram
    @GetMapping("/studentByQuery")
    public Student studentByQuery(@RequestParam int id,
                                  @RequestParam String firstname,
                                  @RequestParam String lastname){
        Student student = new Student(id,firstname,lastname);
        return student;
    }

    //what is the difference between pathVariable and requestParam


    //springboot REST API with Post Request - Creating new resource
    // http://localhost:8080/api/student/create
    //@PostMapping and @RequestBody
    //how post mapping work with @request body
    @PostMapping("/student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent( @RequestBody Student student){

        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;

    }

    //springboot REST API with Put Request - updating resource
    // http://localhost:8080/api/student/2/update
    @PutMapping("/student/{id}/update")
    public Student updateStudent( @RequestBody Student student, @PathVariable int id){

        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;

    }


    //springboot REST API with Delete Request - delete resource based on id
    // http://localhost:8080/api/student/2/delete

    @DeleteMapping("student/{id}/delete")
    public String deleteStudent( @PathVariable("id") int StudentId){

        System.out.println("Student got deleted:  ID -> "  +StudentId );
        return "Student got deleted";
    }



}
