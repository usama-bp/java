package com.usama.gettingstarted.datasource1.repository;

import com.usama.gettingstarted.datasource1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
}
