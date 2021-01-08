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
@Table(name="project_hub_db.Menus")
public class Menu {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @Column(name="BackgroundColor")
    private String backgroundColor;

    // @JoinColumn(name="BoardId")
    // @OneToOne 
    // private Board board;

    public Menu() { }

    // CREATE 
    public static Menu toMenu(com.alexrgordon.projecthub.api.model.Menu menu, Integer boardId) {
        Menu mapped = new Menu();
        // Board boardFK = new Board();
        // boardFK.setId(boardId);
        // mapped.setBoard(boardFK);
        mapped.setBackgroundColor(menu.getBackgroundColor());
        return mapped;
    }

    // UPDATE
    public static Menu toMenu(com.alexrgordon.projecthub.api.model.Menu menu) {
        Menu mapped = new Menu();
        // Board boardFK = new Board();
        // boardFK.setId(menu.getBoard().getId());
        // mapped.setBoard(boardFK);
        mapped.setId(menu.getId());
        mapped.setBackgroundColor(menu.getBackgroundColor());
        return mapped;
    }

}
