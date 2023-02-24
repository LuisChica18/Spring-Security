package com.example.springsecurityjpauserrole.service;

import com.example.springsecurityjpauserrole.model.Users;
import com.example.springsecurityjpauserrole.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Users> usersList() {
        return usersRepository.findAll();
    }
}
