package com.alexrgordon.projecthub.api.model;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
public class Board {

    public Board() { }

    private Integer id;
    private String name;

    public static Board toBoard(com.alexrgordon.projecthub.dal.dao.model.Board board) {
        Board mapped = new Board();
        mapped.setId(board.getId());
        mapped.setName(board.getName());
        return mapped;
    }

}