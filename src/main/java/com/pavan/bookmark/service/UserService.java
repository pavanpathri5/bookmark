package com.pavan.bookmark.service;

import com.pavan.bookmark.model.user.User;
import com.pavan.bookmark.requestdto.UserRequestDTO;
import com.pavan.bookmark.responsedto.UserResponseDTO;

public interface UserService {
   User usermapping(UserRequestDTO user);
   UserResponseDTO saveUser(User user);

   User finduser(String email);
}
