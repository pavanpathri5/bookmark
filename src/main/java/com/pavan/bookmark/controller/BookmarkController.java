package com.pavan.bookmark.controller;

import com.pavan.bookmark.model.user.Bookmark;
import com.pavan.bookmark.requestdto.BookMarkRequestDTO;
import com.pavan.bookmark.responsedto.BookMarkResponseDTO;
import com.pavan.bookmark.service.BookmarkService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class BookmarkController {
    @Autowired
    BookmarkService bookmarkService;
    @RequestMapping(value = "/createbookmark",method = RequestMethod.POST)
    public ResponseEntity<?> createProduct(@Valid @RequestBody BookMarkRequestDTO newbookmark) {
        Bookmark bookmark=bookmarkService.bookmarkmapping(newbookmark);
        BookMarkResponseDTO bookmarresponse=bookmarkService.createBookmark(bookmark);
        return ResponseEntity.status(HttpStatus.OK).body(bookmarresponse);
    }

    @RequestMapping(value = "/getallbookmarks",method = RequestMethod.GET)
    public ResponseEntity<?> getAllBookmarks(@RequestParam("page") int page,
                                             @RequestParam("pageSize") int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<BookMarkResponseDTO> bookmarkres=bookmarkService.getallBookmarks(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(bookmarkres);
    }

    @RequestMapping(value = "/getbookmark/{bookmarkname}",method = RequestMethod.GET)
    public ResponseEntity<?> getBookmark(@PathVariable String bookmarkname) {
        BookMarkResponseDTO bookmarkres=bookmarkService.getBookmark(bookmarkname);
        return ResponseEntity.status(HttpStatus.OK).body(bookmarkres);
    }

    @RequestMapping(value = "/{bookmarkname}",method = RequestMethod.GET)
    public String StringRedirectionURL(@PathVariable String bookmarkname, HttpServletResponse response) {
        BookMarkResponseDTO bookmarkres=bookmarkService.getBookmark(bookmarkname);
        if(bookmarkres.getTag().getName().equals("link")){
            //response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", bookmarkres.getLink());
            return "";
        }
        else
            return bookmarkres.getLink();
    }

    @RequestMapping(value = "/searchbookmarks",method = RequestMethod.GET)
    public ResponseEntity<?> getAllBookmarks(@RequestParam("page") int page,
                                             @RequestParam("pageSize") int pageSize,@RequestParam("searchterm") String searchTerm) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<BookMarkResponseDTO> bookmarkres=bookmarkService.searchBookmark(searchTerm,pageable);
        return ResponseEntity.status(HttpStatus.OK).body(bookmarkres);
    }
}
