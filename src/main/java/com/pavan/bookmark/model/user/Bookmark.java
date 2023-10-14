package com.pavan.bookmark.model.user;

import com.pavan.bookmark.responsedto.UserResponseDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@Table(name="bookmark",uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
@Data
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The name is required.")
    @Column(unique = true,nullable=false,length = 512)
    private String name;

    @Column(length = 512)
    private String description;

    @Column(length = 512)
    private String link;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

}
