package org.tanuja.bookmanagementsystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import lombok.extern.flogger.Flogger;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Entity(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String isbn;
    @ManyToOne
    private Author author;
    @ManyToMany
    private List<Category> category=new ArrayList<>();
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Review> reviews;
}
