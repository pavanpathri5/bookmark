package com.pavan.bookmark.requestdto;

import com.pavan.bookmark.model.user.Tag;
import com.pavan.bookmark.model.user.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class BookMarkRequestDTO {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @NotEmpty(message = "The name is required.")
    @Column(unique = true,nullable=false,length = 512)
    private String name;

    @Column(length = 512)
    private String description;

    @Column(length = 512)
    private String link;
    private String user;
    private String tag;
}
