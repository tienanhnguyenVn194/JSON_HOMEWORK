package com.example.json_homework;

class Product {
    int id;
    String main;
    String description;
    String icon;

    public Product(int id, String main, String description, String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
