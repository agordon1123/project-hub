package com.alexrgordon.projecthub.dal.dao.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity 
@Table(name="Cards")
public class Card {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="Id")
    private int id;

    @Column(name="Title")
    private String title;

    @Column(name="Description")
    private String description;

    @Column(name="DueDate")
    private Date dueDate;

    @Column(name="CreateDate")
    private Date createdDate;

    // private User assignedTo;
    // private List<Comment> comments;
    // private List<Activity> activity; // could maybe be a shared component (Board could have activity)

    public Card () { }

    public static Card toCard(com.alexrgordon.projecthub.api.model.Card card) {
        Card mapped = new Card();
        mapped.setTitle(card.getTitle());
        mapped.setDescription(card.getDescription());
        mapped.setDueDate(card.getDueDate());
        mapped.setCreatedDate(card.getCreatedDate());
        return mapped;
    }

}
