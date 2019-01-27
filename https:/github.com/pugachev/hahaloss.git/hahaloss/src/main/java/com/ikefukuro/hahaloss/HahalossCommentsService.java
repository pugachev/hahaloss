package com.ikefukuro.hahaloss;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HahalossCommentsService {
    @Autowired
    HalalossCommentsRepository hahalossCommentsRepository;

    public List<Comments> findCommentsById(int id) {
        return hahalossCommentsRepository.findCommentsById(id);
    }

    public List<Comments> findAll() {
        return hahalossCommentsRepository.findAll();
    }


    public Comments findOne(Integer id) {
        return hahalossCommentsRepository.findOne(id);
    }

    public Comments create(Comments comments) {
        return hahalossCommentsRepository.save(comments);
    }

    public Comments update(Comments comments) {
        return hahalossCommentsRepository.save(comments);
    }

    public void delete(Integer id) {
    	hahalossCommentsRepository.delete(id);
    }
}