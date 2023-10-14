package com.pavan.bookmark.repository.user;

import com.pavan.bookmark.model.user.User;
import com.pavan.bookmark.responsedto.UserResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User save(User user);
}
