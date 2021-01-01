package com.alexrgordon.projecthub.api.model;

import lombok.Data;

@Data
public class ListModel {

    public ListModel() { }

    private String name;
    private int sortOrder;
    // private List<Card> cards;

}
