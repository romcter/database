package com.example.sql.app;

import com.example.sql.app.entity.Building;
import com.example.sql.app.entity.Person;
import com.example.sql.app.entity.Student;
import com.example.sql.app.repository.BuidingRepository;
import com.example.sql.app.repository.PersonRepository;
import com.example.sql.app.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EnableScheduling
@SpringBootApplication
public class SqlApplication {

    static StudentRepository studentRepository;

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(SqlApplication.class, args);

        BuidingRepository buidingRepository = app.getBean(BuidingRepository.class);
        studentRepository = app.getBean(StudentRepository.class);
//        PersonRepository personRepository = app.getBean(PersonRepository.class);
//        personRepository.saveAll(List.of(
//                Person.builder().name("Rom").created(LocalDateTime.now()).deleted(LocalDateTime.now()).updated(LocalDateTime.now()).build(),
//                Person.builder().name("Ten").created(LocalDateTime.now()).deleted(LocalDateTime.now()).updated(LocalDateTime.now()).build(),
//                Person.builder().name("Kos").created(LocalDateTime.now()).deleted(LocalDateTime.now()).updated(LocalDateTime.now()).build(),
//                Person.builder().name("Pos").created(LocalDateTime.now()).deleted(LocalDateTime.now()).updated(LocalDateTime.now()).build(),
//                Person.builder().name("Vis").created(LocalDateTime.now()).deleted(LocalDateTime.now()).updated(LocalDateTime.now()).build()
//        ));

//        String[] studentData = {"Peter Oven", "Allan Norman", "Motsart", "Kiano", "Piano"};
//        String[] buildingData = {"IT Project", "Networking Project", "ERT", "JSD", "OAS"};
//        List<Building> projects = new ArrayList<>();
//
//        for (String buiding : buildingData) {
//            projects.add(new Building(buiding));
//        }
//
//        for (String student : studentData) {
//            Student employee = new Student(student);
//            employee.setBuildings(projects);
//
//            for (Building proj : projects) {
//                proj.getStudents().add(employee);
//            }
//
//            studentRepository.save(employee);
//            System.out.println("====================================");
//            System.out.println(studentRepository.findAll());
//        }


    }

//    @Transactional
//    @Scheduled(fixedRate = 1000)
//    public void sche(){
//        var stu = studentRepository.findAll();
//        System.out.println(stu);
//    }

}
