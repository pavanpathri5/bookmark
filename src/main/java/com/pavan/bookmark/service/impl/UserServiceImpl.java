package com.pavan.bookmark.service.impl;

import com.pavan.bookmark.model.user.User;
import com.pavan.bookmark.repository.user.UserRepository;
import com.pavan.bookmark.requestdto.UserRequestDTO;
import com.pavan.bookmark.responsedto.UserResponseDTO;
import com.pavan.bookmark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User usermapping(UserRequestDTO newuser) {
        User user=new User();
        user.setEmail(newuser.getEmail());
        user.setPassword(newuser.getPassword());
        return user;
    }

    @Override
    public UserResponseDTO saveUser(User newuser) {
        User user=userRepository.save(newuser);
        UserResponseDTO userResponseDTO=new UserResponseDTO();
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setId(user.getId());
        return userResponseDTO;
    }
}
