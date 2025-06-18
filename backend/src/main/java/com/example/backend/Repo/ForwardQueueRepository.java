package com.example.backend.Repo;

import com.example.backend.Entity.ForwardQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForwardQueueRepository extends JpaRepository<ForwardQueue, Long> {
}
