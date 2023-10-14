package com.pavan.bookmark.service.impl;

import com.pavan.bookmark.model.user.Bookmark;
import com.pavan.bookmark.model.user.Tag;
import com.pavan.bookmark.model.user.User;
import com.pavan.bookmark.repository.user.BookmarkRepository;
import com.pavan.bookmark.requestdto.BookMarkRequestDTO;
import com.pavan.bookmark.responsedto.BookMarkResponseDTO;
import com.pavan.bookmark.responsedto.TagResponseDTO;
import com.pavan.bookmark.responsedto.UserResponseDTO;
import com.pavan.bookmark.service.BookmarkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BookmarkServiceImpl implements BookmarkService {
    @Autowired
    BookmarkRepository bookmarkRepository;
    @Override
    public BookMarkResponseDTO createBookmark(Bookmark newbookmark) {
        UserResponseDTO userResponseDTO=new UserResponseDTO();
        BookMarkResponseDTO bookMarkResponseDTO=new BookMarkResponseDTO();
        TagResponseDTO tagResponseDTO=new TagResponseDTO();
        Bookmark bookmark=bookmarkRepository.save(newbookmark);
        bookMarkResponseDTO.setId(bookmark.getId());
        bookMarkResponseDTO.setName(bookmark.getName());
        bookMarkResponseDTO.setDescription(bookmark.getDescription());
        bookMarkResponseDTO.setLink(bookmark.getLink());
        userResponseDTO.setEmail(bookmark.getUser().getEmail());
        userResponseDTO.setId(bookmark.getUser().getId());
        bookMarkResponseDTO.setUser(userResponseDTO);
        tagResponseDTO.setId(bookmark.getTag().getId());
        tagResponseDTO.setName(bookmark.getTag().getName());
        bookMarkResponseDTO.setTag(tagResponseDTO);
        return bookMarkResponseDTO;
    }

    @Override
    public Bookmark bookmarkmapping(BookMarkRequestDTO bookMarkRequestDTO) {
        Bookmark bookmark=new Bookmark();
        User user=new User();
        Tag tag=new Tag();
        bookmark.setName(bookMarkRequestDTO.getName());
        bookmark.setDescription(bookMarkRequestDTO.getDescription());
        bookmark.setLink(bookMarkRequestDTO.getLink());
        user.setId(bookMarkRequestDTO.getUser().getId());
        user.setEmail(bookMarkRequestDTO.getUser().getEmail());
        bookmark.setUser(user);
        tag.setId(bookMarkRequestDTO.getTag().getId());
        tag.setName(bookMarkRequestDTO.getTag().getName());
        bookmark.setTag(tag);
        return bookmark;
    }

    @Override
    public List<BookMarkResponseDTO> getallBookmarks(Pageable page) {
        Page<Bookmark> bookmarks=bookmarkRepository.findAll(page);
        List<BookMarkResponseDTO> res=new ArrayList<>();
        for(Bookmark bookmark:bookmarks){
            BookMarkResponseDTO brt=new BookMarkResponseDTO();
            UserResponseDTO urd=new UserResponseDTO();
            TagResponseDTO trd=new TagResponseDTO();
            brt.setId(bookmark.getId());
            brt.setName(bookmark.getName());
            brt.setLink(bookmark.getLink());
            brt.setDescription(bookmark.getDescription());
            urd.setId(bookmark.getUser().getId());
            urd.setEmail(bookmark.getUser().getEmail());
            brt.setUser(urd);
            trd.setName(bookmark.getTag().getName());
            trd.setId(bookmark.getTag().getId());
            brt.setTag(trd);
            res.add(brt);
        }
        return res;
    }

    @Override
    public BookMarkResponseDTO getBookmark(String bookmarkname) {
        Bookmark bookmark=bookmarkRepository.findByName(bookmarkname);
        BookMarkResponseDTO brt=new BookMarkResponseDTO();
        UserResponseDTO urd=new UserResponseDTO();
        TagResponseDTO trd=new TagResponseDTO();
        brt.setId(bookmark.getId());
        brt.setName(bookmark.getName());
        brt.setLink(bookmark.getLink());
        brt.setDescription(bookmark.getDescription());
        urd.setId(bookmark.getUser().getId());
        urd.setEmail(bookmark.getUser().getEmail());
        brt.setUser(urd);
        trd.setName(bookmark.getTag().getName());
        trd.setId(bookmark.getTag().getId());
        brt.setTag(trd);
        return brt;
    }

    @Override
    public List<BookMarkResponseDTO> searchBookmark(String searchTerm,Pageable page) {
        Page<Bookmark> bookmarks=bookmarkRepository.searchAllFields(searchTerm,page);
        List<BookMarkResponseDTO> res=new ArrayList<>();
        for(Bookmark bookmark:bookmarks){
            BookMarkResponseDTO brt=new BookMarkResponseDTO();
            UserResponseDTO urd=new UserResponseDTO();
            TagResponseDTO trd=new TagResponseDTO();
            brt.setId(bookmark.getId());
            brt.setName(bookmark.getName());
            brt.setLink(bookmark.getLink());
            brt.setDescription(bookmark.getDescription());
            urd.setId(bookmark.getUser().getId());
            urd.setEmail(bookmark.getUser().getEmail());
            brt.setUser(urd);
            trd.setName(bookmark.getTag().getName());
            trd.setId(bookmark.getTag().getId());
            brt.setTag(trd);
            res.add(brt);
        }
        return res;
    }
}
