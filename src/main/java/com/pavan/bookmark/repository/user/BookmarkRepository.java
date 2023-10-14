package com.pavan.bookmark.repository.user;

import com.pavan.bookmark.model.user.Bookmark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookmarkRepository extends JpaRepository<Bookmark,Long> {
    Page<Bookmark> findAll(Pageable page);
    Bookmark save(Bookmark bookmark);
    Bookmark findByName(String name);
   // Page<Bookmark> findByFieldContaining(String searchTerm, Pageable pageable);

    @Query("SELECT e FROM Bookmark e JOIN e.user u JOIN e.tag t WHERE " +
            "CONCAT(e.name, e.link, e.description, u.email,t.name) LIKE %:searchTerm%")
    Page<Bookmark> searchAllFields(String searchTerm,Pageable pageable);
}

