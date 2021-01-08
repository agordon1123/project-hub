package com.alexrgordon.projecthub.api.model;

import lombok.Data;

@Data
public class ListModel {

    public ListModel() { }

    private Integer id;
    private Integer boardId;
    private String name;
    private Integer sortOrder;

    public static ListModel toListModel(com.alexrgordon.projecthub.dal.dao.model.ListModel list) {
        ListModel mapped = new ListModel();
        mapped.setId(list.getId());
        mapped.setBoardId(list.getBoard().getId());
        mapped.setName(list.getName());
        mapped.setSortOrder(list.getSortOrder());
        return mapped;
    }

}
