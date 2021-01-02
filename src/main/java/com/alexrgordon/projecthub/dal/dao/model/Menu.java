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
@Table(name="Menus")
public class Menu {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="Id")
    private int id;

    @Column(name="BackgroundColor")
    private String backgroundColor;

    public Menu() { }

    public static Menu toMenu(com.alexrgordon.projecthub.api.model.Menu menu) {
        Menu mapped = new Menu();
        mapped.setBackgroundColor(menu.getBackgroundColor());
        return mapped;
    }

}
