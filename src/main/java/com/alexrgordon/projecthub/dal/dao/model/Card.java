package com.alexrgordon.projecthub.dal.dao.model;

import java.util.DateTime;
import java.util.List;

import lombok.Data;

@Data
public class Card {

    public Card () { }

    private String title;
    private String description;
    private DateTime dueDate;
    private DateTime createdDate;
    // private User assignedTo;
    // private List<Comment> comments;
    // private List<Activity> activity; // could maybe be a shared component (Board could have activity)

    public static Card toCard(com.alexrgordon.projecthub.api.model.Card card) {
        Card mapped = new Card();
        mapped.setTitle(card.getTitle());
        mapped.setDescription(card.getDescription());
        return mapped;
    }

}
