package com.example.Booklist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Users")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
public class BookUser {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    @NotBlank
    private String username;
    @NotNull
    @NotBlank
    private String password;

    @OneToMany(mappedBy = "bookUser")
    private List<ReadingList> readingLists = new ArrayList<>();
}
