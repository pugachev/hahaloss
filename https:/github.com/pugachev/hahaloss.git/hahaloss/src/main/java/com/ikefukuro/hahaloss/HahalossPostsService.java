package com.ikefukuro.hahaloss;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HahalossPostsService {
    @Autowired
    HalalossPostsRepository hahalossPostsRepository;

    public Posts findPostsById(int id) {
        return hahalossPostsRepository.findPostsById(id);
    }


    public List<Posts> findAll() {
        return hahalossPostsRepository.findAll();
    }


    public Posts findOne(Integer id) {
        return hahalossPostsRepository.findOne(id);
    }

    public Posts create(Posts posts) {
        return hahalossPostsRepository.save(posts);
    }

    public Posts update(Posts posts) {
        return hahalossPostsRepository.save(posts);
    }

    public void delete(Integer id) {
    	hahalossPostsRepository.delete(id);
    }
}