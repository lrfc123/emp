package com.baizhi.entity;

public class Dept {
    private String id;
    private String name;
    private String createDate;

    public Dept() {
    }

    public Dept(String id, String name, String createDate) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
