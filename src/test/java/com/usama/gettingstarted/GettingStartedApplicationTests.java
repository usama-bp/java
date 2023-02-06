package com.usama.gettingstarted;

import com.usama.gettingstarted.datasource1.model.Student;
import com.usama.gettingstarted.datasource1.repository.StudentRepo;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
class GettingStartedApplicationTests {

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void create_check_student() {
        Student student = new Student();
        student.setName("Muhammad");
        student.setAge(25);
        student.setSalary(1000);
        student = studentRepo.save(student);

        if(student != null) {
            System.out.println("Test passes");
        }else {
            System.out.println("Test fail");
        }
    }
}
