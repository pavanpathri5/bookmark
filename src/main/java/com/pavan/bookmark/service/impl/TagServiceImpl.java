package com.pavan.bookmark.service.impl;

import com.pavan.bookmark.model.user.Tag;
import com.pavan.bookmark.repository.user.TagRepository;
import com.pavan.bookmark.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    @Autowired
    private final TagRepository tagRepository;

    @Override
    public Tag findTag(String name) {
        return tagRepository.findByName(name);
    }
}
