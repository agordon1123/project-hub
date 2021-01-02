package com.alexrgordon.projecthub.dal.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity 
@Table(name="Lists")
public class ListModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="Id")
    private int id;

    @Column(name="Name")
    private String name;

    @Column(name="SortOrder")
    private int sortOrder;

    // private List<Card> cards;

    public ListModel() { }

    public static ListModel toListModel(com.alexrgordon.projecthub.api.model.ListModel listModel) {
        ListModel mapped = new ListModel();
        mapped.setName(listModel.getName());
        mapped.setSortOrder(listModel.getSortOrder());
        return mapped;
    }

}
