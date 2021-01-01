package com.alexrgordon.projecthub.dal.dao.model;

import java.util.List;

import lombok.Data;

@Data
public class Board {

    public Board() { }

    private String name;
    // @OneToMany
    // @MappedBy("users")
    // private List<User> users;
    // @OneToMany
    // @MappedBy("users")
    // private List<ListModel> lists;


    public static Board toBoard(com.alexrgordon.projecthub.api.model.Board board) {
        Board mapped = new Board();
        mapped.setName(board.getName());
        return mapped;
    }

}
