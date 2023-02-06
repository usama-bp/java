package com.usama.gettingstarted.datasource2.repository;

import com.usama.gettingstarted.datasource2.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}
