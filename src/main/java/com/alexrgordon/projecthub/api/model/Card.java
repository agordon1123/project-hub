package com.alexrgordon.projecthub.api.model;

import java.util.DateTime;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
public class Card {

    public Card() { }

    private String title;
    private String description;
    private DateTime dueDate;
    private DateTime createdDate;
    // private List<Comment> comments;
    // private List<Activity> activity;

}