package com.pavan.bookmark.requestdto;

import jakarta.persistence.Column;

public class TagRequestDTO {
    private Long id;
    @Column(unique = true)
    private String name;
}
