package com.khan.app.repos;

import com.khan.app.entities.Bills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillsRepo extends JpaRepository<Bills, Long> {
}
