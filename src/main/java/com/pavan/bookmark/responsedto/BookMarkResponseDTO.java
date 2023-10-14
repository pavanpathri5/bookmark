package com.pavan.bookmark.responsedto;


public class BookMarkResponseDTO {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public UserResponseDTO getUser() {
        return user;
    }

    public void setUser(UserResponseDTO user) {
        this.user = user;
    }

    public TagResponseDTO getTag() {
        return tag;
    }

    public void setTag(TagResponseDTO tag) {
        this.tag = tag;
    }

    private Long id;
    private String name;
    private String description;
    private String link;
    private UserResponseDTO user;
    private TagResponseDTO tag;
}
