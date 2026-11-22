package com.Project.CollegeBus.services;

import com.Project.CollegeBus.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    private  final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //create User

}
