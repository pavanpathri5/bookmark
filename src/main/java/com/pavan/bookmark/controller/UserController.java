package com.pavan.bookmark.controller;

import com.pavan.bookmark.model.user.User;
import com.pavan.bookmark.repository.user.UserRepository;
import com.pavan.bookmark.requestdto.UserRequestDTO;
import com.pavan.bookmark.responsedto.UserResponseDTO;
import com.pavan.bookmark.service.UserService;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private final UserService userService;
    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public ResponseEntity<?> signUp(@Valid @RequestBody UserRequestDTO newUser) {
            User user=userService.usermapping(newUser);
            UserResponseDTO userresponse= userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.OK).body(userresponse);
    }
}
