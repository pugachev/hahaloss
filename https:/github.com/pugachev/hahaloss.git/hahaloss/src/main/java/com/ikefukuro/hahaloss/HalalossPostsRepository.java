package com.ikefukuro.hahaloss;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface HalalossPostsRepository extends JpaRepository<Posts, Integer> {
    @Query("SELECT x FROM Posts x WHERE x.id =:id ORDER BY x.id")
    public Posts findPostsById(int id);
}

