package com.first.servlet.domain;

import javax.persistence.*;

@Entity
@Table(name = "skill")
public class Skill {
    @Column(name = "idSkill")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nameSkill")
    private String nameSkill;

    @Column(name = "levelSkill")
    private String levelSkill;

    @ManyToOne
    @JoinColumn(name = "idDeveloper")
    private Developer developer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameSkill() {
        return nameSkill;
    }

    public void setNameSkill(String nameSkill) {
        this.nameSkill = nameSkill;
    }

    public String getLevelSkill() {
        return levelSkill;
    }

    public void setLevelSkill(String levelSkill) {
        this.levelSkill = levelSkill;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

}
