package com.ikefukuro.hahaloss;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HalalossCommentsRepository extends JpaRepository<Comments, Integer> {
    @Query("SELECT x FROM Comments x WHERE x.post_id =:id ORDER BY x.id")
    public List<Comments> findCommentsById(int id);

}

