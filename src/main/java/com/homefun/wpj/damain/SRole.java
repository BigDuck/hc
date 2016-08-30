package com.homefun.wpj.damain;

import javax.persistence.*;

@Table(name = "s_role")
public class SRole extends BaseDamain {
    private static final long serialVersionUID = -2385108509625056987L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer uid;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "SRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", uid=" + uid +
                '}';
    }
}