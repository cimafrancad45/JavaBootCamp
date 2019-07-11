package com.trilogyed.DarylCimafrancaU1Capstone.dao;

import com.trilogyed.DarylCimafrancaU1Capstone.dto.TShirt;

import java.util.List;

public interface TshirtDao {

    TShirt addTShirt(TShirt tShirt);

    TShirt getTShirt(int id);

    List<TShirt> getAllTShirts();

    void updateTShirt(TShirt tShirt);

    void deleteTShirt(int id);

    TShirt getTShirtBySize(String size);

    TShirt getTShirtByColor(String Color);
}
