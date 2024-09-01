package com.task.LoadManagement.Repo;

import com.task.LoadManagement.Model.Load;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoadRepository extends JpaRepository<Load, Integer> {
    List<Load> findByShipperId(String shipperId);

    void deleteById(int loadId);

}
