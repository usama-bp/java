package com.usama.gettingstarted;

import com.usama.gettingstarted.datasource1.model.Student;
import com.usama.gettingstarted.datasource1.repository.StudentRepo;
import com.usama.gettingstarted.datasource2.model.Department;
import com.usama.gettingstarted.datasource2.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class GettingStartedApplication implements CommandLineRunner {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(GettingStartedApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Student student = new Student();
        student.setName("Muhammad");
        student.setAge(25);
        student.setSalary(1000);
        studentRepo.save(student);

        Department department = new Department();
        department.setName("physics");
        department.setTotalFaculties(10);

        departmentRepo.save(department);

    }
}
