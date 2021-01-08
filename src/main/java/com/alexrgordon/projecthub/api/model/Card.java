package com.alexrgordon.projecthub.api.model;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
public class Card {

    public Card() { }

    private Integer id;
    private Integer listId;
    private String title;
    private String description;
    private Date dueDate;
    private Date createdDate;

    public static Card toCard(com.alexrgordon.projecthub.dal.dao.model.Card card) {
        Card mapped = new Card();
        mapped.setId(card.getId());
        mapped.setTitle(card.getTitle());
        mapped.setDescription(card.getDescription());
        mapped.setDueDate(card.getDueDate());
        mapped.setCreatedDate(card.getCreatedDate());
        return mapped;
    }

}