package com.trilogyed;

import java.util.List;

public class IceCreamFactory {
    private String type;
    private String flavor;
    private List<String> ingredients;
    private List<String> nutritionFacts;
    private boolean nuts;
    private boolean sugarFree;
    private int batchesMade;
    private int batchesShipped;
    private int batchesSold;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getNutritionFacts() {
        return nutritionFacts;
    }

    public void setNutritionFacts(List<String> nutritionFacts) {
        this.nutritionFacts = nutritionFacts;
    }

    public boolean isNuts() {
        return nuts;
    }

    public void setNuts(boolean nuts) {
        this.nuts = nuts;
    }

    public boolean isSugarFree() {
        return sugarFree;
    }

    public void setSugarFree(boolean sugarFree) {
        this.sugarFree = sugarFree;
    }

    public int getBatchesMade() {
        return batchesMade;
    }

    public void setBatchesMade(int batchesMade) {
        this.batchesMade = batchesMade;
    }

    public int getBatchesShipped() {
        return batchesShipped;
    }

    public void setBatchesShipped(int batchesShipped) {
        this.batchesShipped = batchesShipped;
    }

    public int getBatchesSold() {
        return batchesSold;
    }

    public void setBatchesSold(int batchesSold) {
        this.batchesSold = batchesSold;
    }
}
