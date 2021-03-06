package com.alexrgordon.projecthub.dal.dao.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
// @Entity 
// @Table(name="Teams")
public class Team {

    // @Id
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    // @Column(name="Id")
    private int id;

    public Team() { }

    private String name;
    // private List<User> users;

    public static Team toTeam(com.alexrgordon.projecthub.api.model.Team team) {
        Team mapped = new Team();
        mapped.setName(team.getName());
        return mapped;
    }

}
