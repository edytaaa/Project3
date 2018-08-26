package com.task.project3.repository;

import com.task.project3.model.Mieszkanie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MieszkanieRepository extends JpaRepository<Mieszkanie, Long> {
}