package com.alexrgordon.projecthub.api.model;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
public class Board {

    public Board() { }

    private String name;
    private List<String> users;
    private List<String> lists;
    // todo: build out sub classes for lists, users, etc
    // @ToString.Exclude

    public static Board toBoard(com.alexrgordon.projecthub.dal.dao.model.Board board) {
        Board mapped = new Board();
        mapped.setName(board.getName());
        mapped.setUsers(board.getUsers());
        mapped.setLists(board.getLists());
        return mapped;
    }

}