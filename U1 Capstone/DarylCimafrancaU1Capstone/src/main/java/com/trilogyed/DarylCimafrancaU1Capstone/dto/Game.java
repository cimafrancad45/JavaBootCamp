package com.trilogyed.DarylCimafrancaU1Capstone.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class Game {
    private int gameId;
    @NotNull(message = "Title cannot be blank!")
    private String title;
    @NotNull(message = "Needs a valid input")
    private String ersbRating;
    @NotNull(message = "Needs a valid input!")
    private String description;
    @NotNull(message = "Needs a valid price!")
    private BigDecimal price;
    @NotNull(message = "Needs a valid input!")
    private String studio;
    @Min(value = 0, message = "Quantity must be a non-negative number.")
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

        return false;
}

    @Override
    public int hashCode() {
        return Objects.hash();
    }
}
