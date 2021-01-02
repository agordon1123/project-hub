package com.alexrgordon.projecthub.api.model;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
public class Card {

    public Card() { }

    private String title;
    private String description;
    private Date dueDate;
    private Date createdDate;

}