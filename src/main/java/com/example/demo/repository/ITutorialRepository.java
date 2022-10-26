package com.example.demo.repository;


import com.example.demo.model.Tutorial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITutorialRepository extends CrudRepository<Tutorial, Long> {

    List<Tutorial> findByTitleIgnoreCaseContaining(String toContains);
    @Query("FROM Tutorial t WHERE t.situation = :situation")
    List<Tutorial> findTutorialBySituation(@Param("situation") String situation);
}
