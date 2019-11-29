package com.example.mysuggestfood;

public class ListFood {

    int id;
    String nameFood;
    float nutritionalValue;
    String resource;
    String tutorials;
    String kindFood;
    int executionTime;
    String imageFood;
    float price;
    String difficultLevel;

    public ListFood(String nameFood, String resource, String tutorials, String kindFood) {
        super();
        this.id = id;
        this.nameFood = nameFood;
        this.nutritionalValue = nutritionalValue;
        this.resource = resource;
        this.tutorials = tutorials;
        this.kindFood = kindFood;
        this.executionTime = executionTime;
        this.imageFood = imageFood;
        this.price = price;
        this.difficultLevel = difficultLevel;
    }

    public ListFood(String nameFood, float nutritionalValue, String resource, String tutorials, String kindFood, int executionTime, String imageFood, float price, String difficultLevel) {
        super();
        this.nameFood = nameFood;
        this.nutritionalValue = nutritionalValue;
        this.resource = resource;
        this.tutorials = tutorials;
        this.kindFood = kindFood;
        this.executionTime = executionTime;
        this.imageFood = imageFood;
        this.price = price;
        this.difficultLevel = difficultLevel;
    }

    public int getId(){
        return id;
    }

    public void setId(){
        this.id = id;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public float getNutritionalValue() {
        return nutritionalValue;
    }

    public void setNutritionalValue(float nutritionalValue) {
        this.nutritionalValue = nutritionalValue;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getTutorials() {
        return tutorials;
    }

    public void setTutorials(String tutorials) {
        this.tutorials = tutorials;
    }

    public String getKindFood() {
        return kindFood;
    }

    public void setKindFood(String kindFood) {
        this.kindFood = kindFood;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public String getImageFood() {
        return imageFood;
    }

    public void setImageFood(String imageFood) {
        this.imageFood = imageFood;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDifficultLevel() {
        return difficultLevel;
    }

    public void setDifficultLevel(String difficultLevel) {
        this.difficultLevel = difficultLevel;
    }
}
