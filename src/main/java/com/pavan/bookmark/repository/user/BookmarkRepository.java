package com.pavan.bookmark.repository.user;

import com.pavan.bookmark.model.user.Bookmark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark,Long> {
    Page<Bookmark> findAll(Pageable page);
    Bookmark save(Bookmark bookmark);
    Bookmark findByName(String name);
}
