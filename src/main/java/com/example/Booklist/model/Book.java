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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOKID")
    private int bookID;

    @NotNull
    @NotBlank
    @Column(name = "TITLE")
    private String title;

    @Column(name = "PAGES")
    private int pages;

    @Column(name = "PUBLISHED")
    private LocalDate published;

    @ManyToMany(mappedBy = "books")
    List<ReadingList> readingLists= new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHORID")
    private Author author;

    @ManyToMany(mappedBy = "books")
    List<Genre> genres = new ArrayList<>();
}
