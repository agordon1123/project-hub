package com.alexrgordon.projecthub.dal.dao.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity 
@Table(name="project_hub_db.Cards")
public class Card {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;
    
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name="ListId")
    private ListModel list;

    @Column(name="Title")
    private String title;

    @Column(name="Description")
    private String description;

    @Column(name="DueDate")
    private Date dueDate;

    @Column(name="CreatedDate")
    private Date createdDate;

    // private User assignedTo;
    // private List<Comment> comments;
    // private List<Activity> activity; // could maybe be a shared component (Board could have activity)

    public Card () { }

    // CREATE 
    public static Card toCard(com.alexrgordon.projecthub.api.model.Card card, Integer listId) {
        Card mapped = new Card();
        ListModel listFK = new ListModel();
        listFK.setId(listId);
        mapped.setList(listFK);
        mapped.setTitle(card.getTitle());
        mapped.setDescription(card.getDescription());
        mapped.setDueDate(card.getDueDate());
        mapped.setCreatedDate(card.getCreatedDate());
        return mapped;
    }

    // UPDATE
    public static Card toCard(com.alexrgordon.projecthub.api.model.Card card) {
        Card mapped = new Card();
        mapped.setId(card.getId());
        mapped.setTitle(card.getTitle());
        mapped.setDescription(card.getDescription());
        mapped.setDueDate(card.getDueDate());
        mapped.setCreatedDate(card.getCreatedDate());
        return mapped;
    }

}
