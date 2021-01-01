package com.alexrgordon.projecthub.dal.dao.model;

import lombok.Data;

@Data
public class ListModel {

    public ListModel() { }

    private String name;
    private int sortOrder;
    // private List<Card> cards;

    public static ListModel toListModel(com.alexrgordon.projecthub.api.model.ListModel listModel) {
        ListModel mapped = new ListModel();
        mapped.setName(listModel.getName);
        mapped.setSortOrder(listModel.getSortOrder);
        return mapped;
    }

}
