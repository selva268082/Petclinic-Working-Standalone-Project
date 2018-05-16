package org.springframework.samples.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.test.bean.Bus;


public interface BusRepo extends JpaRepository<Bus, Integer> {

}
