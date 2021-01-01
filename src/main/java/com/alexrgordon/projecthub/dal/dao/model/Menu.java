package com.alexrgordon.projecthub.dal.dao.model;

import lombok.Data;

@Data
public class Menu {

    private String backGroundColor;

    public Menu() { }

    public static Menu toMenu(com.alexrgordon.projecthub.api.model.Menu menu) {
        Menu mapped = new Menu();
        mapped.setBackgroundColor(men.getBackgroundColor());
        return mapped;
    }

}
