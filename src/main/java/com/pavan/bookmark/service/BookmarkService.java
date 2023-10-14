package com.pavan.bookmark.service;

import com.pavan.bookmark.model.user.Bookmark;
import com.pavan.bookmark.requestdto.BookMarkRequestDTO;
import com.pavan.bookmark.responsedto.BookMarkResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookmarkService {
    BookMarkResponseDTO createBookmark(Bookmark bookmark);
    Bookmark bookmarkmapping(BookMarkRequestDTO bookMarkRequestDTO);

    List<BookMarkResponseDTO> getallBookmarks(Pageable page);

    BookMarkResponseDTO getBookmark(String bookmarkname);
}
