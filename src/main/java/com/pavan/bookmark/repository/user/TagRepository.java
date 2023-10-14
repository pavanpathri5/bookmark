package com.pavan.bookmark.repository.user;

import com.pavan.bookmark.model.user.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByName(String name);
}
