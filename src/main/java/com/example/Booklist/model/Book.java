package com.example.Booklist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Books")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private int pages;
    private LocalDate published;

    @ManyToMany(mappedBy = "books")
    List<ReadingList> readingLists= new ArrayList<>();

    @ManyToOne
    private Author author;

    @ManyToMany(mappedBy = "books")
    List<Genre> genres = new ArrayList<>();
}
