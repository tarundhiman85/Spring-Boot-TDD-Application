package com.tarunspringboottldd.springboottldd.Repository;

import com.tarunspringboottldd.springboottldd.Models.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}
