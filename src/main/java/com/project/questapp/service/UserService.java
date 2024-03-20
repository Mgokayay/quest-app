package com.project.questapp.service;

import com.project.questapp.entity.User;
import com.project.questapp.repository.UserRepository;

import java.util.List;

public interface UserService{


    List<User>  findAll();

    User findById(Long id);

    User save(User user);

    User update(User user,Long id);

    User delete (Long id);
}
