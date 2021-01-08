package com.alexrgordon.projecthub.dal.dao.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

import com.alexrgordon.projecthub.dal.dao.model.Board;
import com.alexrgordon.projecthub.dal.dao.model.Card;

@Data
@Entity 
@Table(name="project_hub_db.Lists")
public class ListModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name="BoardId")
    private Board board;

    @Column(name="Name")
    private String name;

    @Column(name="SortOrder")
    private int sortOrder;

    @OneToMany(mappedBy="list")
    @ToString.Exclude
    private List<Card> cards;

    public ListModel() { }

    // CREATE
    public static ListModel toListModel(com.alexrgordon.projecthub.api.model.ListModel listModel, Integer boardId) {
        ListModel mapped = new ListModel();
        Board boardFK = new Board();
        boardFK.setId(boardId);
        mapped.setBoard(boardFK);
        mapped.setName(listModel.getName());
        mapped.setSortOrder(listModel.getSortOrder());
        return mapped;
    }

    // UPDATE
    public static ListModel toListModel(com.alexrgordon.projecthub.api.model.ListModel listModel) {
        ListModel mapped = new ListModel();
        mapped.setId(listModel.getId());
        Board boardFK = new Board();
        boardFK.setId(listModel.getBoardId());
        mapped.setBoard(boardFK);
        mapped.setName(listModel.getName());
        mapped.setSortOrder(listModel.getSortOrder());
        return mapped;
    }

}
