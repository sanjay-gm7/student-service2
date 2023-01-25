package com.sample.javab3.studentservice.controller;

import com.sample.javab3.studentservice.db.model.Student;
import com.sample.javab3.studentservice.db.repository.StudentRepository;
import com.sample.javab3.studentservice.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class StudentController {
    @Autowired
   private StudentRepository studentRepo;

    private StudentService studentService;

     @GetMapping("/students/{rollNum}")
    public ResponseEntity<Object> fetchStudentByID(@PathVariable int rollNum) {
         log.info("fetch studentById called with rollNumber- {}",rollNum);
         System.out.println("inside fetchstudentid");

         var response = studentRepo.findById(rollNum);

         if (response.isPresent()) {
             return new ResponseEntity<>(response.get(), HttpStatus.OK);
         } else{
             log.error("no record found for rollnum - {}",rollNum);
             return new ResponseEntity<>("no matching record found", HttpStatus.OK);
         }
     }

     @GetMapping("/students")
     public ResponseEntity<Object> fetchAllStudents(){
         System.out.println("inside fetchAllStudents");
         return new ResponseEntity<>(studentService.fetchAllStudents(),HttpStatus.OK);
     }

     @PostMapping("/students")
     public ResponseEntity<Object> saveStudent(@RequestBody Student obj){
         var ret=studentRepo.save(obj);
         return new ResponseEntity<>("student stored into DB",HttpStatus.OK);
     }

     @PutMapping("/students")
     public ResponseEntity<Object> updateStudent(@RequestBody Student obj){
        var ret= studentRepo.save(obj);
        return new ResponseEntity<>("student object updated",HttpStatus.OK);
     }

  /*  @GetMapping("/students")
     public ResponseEntity<Object> fetchStudentByID(@RequestBody Student obj){
         return new ResponseEntity<>(studentRepo.findAll(),HttpStatus.OK);
     }*/

     @DeleteMapping("/students/{rollNum}")
     public ResponseEntity<Object> deleteByID(@PathVariable int rollNum){
         studentRepo.deleteById(rollNum);
         return new ResponseEntity<>("student deleted",HttpStatus.OK);
     }


}

