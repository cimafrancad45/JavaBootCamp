package com.trilogyed.DarylCimafrancaU1Capstone.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class Game {
    private int gameId;
    private String title;
    private String ersbRating;
    private String description;
    private BigDecimal price;
    private String studio;
    private int quantity;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getErsbRating() {
        return ersbRating;
    }

    public void setErsbRating(String ersbRating) {
        this.ersbRating = ersbRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object g) {
        if (this == null) return true;
        if (g == null || getClass() != g.getClass()) return false;
        Game game = (Game) g;

        return getGameId() == game.getGameId() &&
                Objects.equals(getTitle(), game.getTitle()) &&
                Objects.equals(getErsbRating(), game.getErsbRating()) &&
                Objects.equals(getDescription(), game.getDescription()) &&
                Objects.equals(getPrice(), game.getPrice()) &&
                Objects.equals(getStudio(), game.getStudio()) &&
                getQuantity() == game.getQuantity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGameId(), getTitle(), getErsbRating(), getDescription(), getPrice(),getStudio(),getQuantity());
    }
}
