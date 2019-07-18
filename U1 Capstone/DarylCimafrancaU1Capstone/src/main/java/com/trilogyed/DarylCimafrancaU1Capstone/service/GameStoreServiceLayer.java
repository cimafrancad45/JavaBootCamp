package com.trilogyed.DarylCimafrancaU1Capstone.service;


import com.trilogyed.DarylCimafrancaU1Capstone.dao.*;
import com.trilogyed.DarylCimafrancaU1Capstone.dto.Console;
import com.trilogyed.DarylCimafrancaU1Capstone.dto.Game;
import com.trilogyed.DarylCimafrancaU1Capstone.dto.Invoice;
import com.trilogyed.DarylCimafrancaU1Capstone.dto.TShirt;
import com.trilogyed.DarylCimafrancaU1Capstone.viewmodel.ConsoleViewModel;
import com.trilogyed.DarylCimafrancaU1Capstone.viewmodel.GameViewModel;
import com.trilogyed.DarylCimafrancaU1Capstone.viewmodel.InvoiceViewModel;
import com.trilogyed.DarylCimafrancaU1Capstone.viewmodel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameStoreServiceLayer {

    GameDao gameDao;
    ConsoleDao consoleDao;
    TShirtDao tShirtDao;
    InvoiceDao invoiceDao;
    @Autowired
    ProcessingFeeDao processingFeeDao;
    @Autowired
    TaxRateDao taxRateDao;

    @Autowired
    public GameStoreServiceLayer(GameDao gameDao, ConsoleDao consoleDao, TShirtDao tShirtDao, InvoiceDao invoiceDao) {
        this.gameDao = gameDao;
        this.consoleDao = consoleDao;
        this.tShirtDao = tShirtDao;
        this.invoiceDao = invoiceDao;

    }
//
//    //Invoice
//
//
//    public InvoiceViewModel addInvoice(InvoiceViewModel invoiceViewModel) {
//
//        Invoice invoice = new Invoice();
//
//        invoice.setName(invoiceViewModel.getName());
//        invoice.setStreet(invoiceViewModel.getStreet());
//        invoice.setCity(invoiceViewModel.getCity());
//        invoice.setState(invoiceViewModel.getState());
//        invoice.setZipcode(invoiceViewModel.getZipcode());
//        invoice.setItemType(invoiceViewModel.getItemType());
//        invoice.setItemId(invoiceViewModel.getItemId());
//        invoice.setUnitPrice(invoiceViewModel.getUnitPrice());
//        invoice.setQuantity(invoiceViewModel.getQuantity());
//        invoice.setSubtotal(invoiceViewModel.getSubtotal());
//        invoice.setTax(invoiceViewModel.getTax());
//        invoice.setProcessingFee(invoiceViewModel.getProcessingFee());
//        invoice.setTotal(invoiceViewModel.getTotal());
//
//        invoice = invoiceDao.addInvoice(invoice);
//
//        invoiceViewModel.setInvoiceId(invoice.getInvoiceId());
//
//        return invoiceViewModel;
//    }
//
//    public void updateInvoice(InvoiceViewModel invoiceViewModel) {
//
//        Invoice invoice = new Invoice();
//        invoice.setInvoiceId(invoiceViewModel.getInvoiceId());
//        invoice.setName(invoiceViewModel.getName());
//        invoice.setStreet(invoiceViewModel.getStreet());
//        invoice.setCity(invoiceViewModel.getCity());
//        invoice.setState(invoiceViewModel.getState());
//        invoice.setZipcode(invoiceViewModel.getZipcode());
//        invoice.setItemType(invoiceViewModel.getItemType());
//        invoice.setItemId(invoiceViewModel.getItemId());
//        invoice.setUnitPrice(invoiceViewModel.getUnitPrice());
//        invoice.setQuantity(invoiceViewModel.getQuantity());
//        invoice.setSubtotal(invoiceViewModel.getSubtotal());
//        invoice.setTax(invoiceViewModel.getTax());
//        invoice.setProcessingFee(invoiceViewModel.getProcessingFee());
//        invoice.setTotal(invoiceViewModel.getTotal());
//
//        invoiceDao.updateInvoice(invoice);
//    }
//
//    public InvoiceViewModel getInvoiceById(int id) {
//        Invoice invoice = invoiceDao.getInvoice(id);
//        if (invoice == null)
//            return null;
//        else
//            return buildInvoiceViewModel(invoice);
//    }
//
//    public void deleteInvoice(int id) {
//        invoiceDao.deleteInvoice(id);
//    }

    //Consoles

    public ConsoleViewModel saveConsole(ConsoleViewModel consoleViewModel) {
        Console console = new Console();

        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setConsoleId(console.getConsoleId());

        console = consoleDao.addConsole(console);

        consoleViewModel.setConsoleId(console.getConsoleId());

        return consoleViewModel;

    }

    public ConsoleViewModel getConsoleById(int id) {
        Console console = consoleDao.getConsole(id);
        if (console == null)
            return null;
        else
            return buildConsoleViewModel(console);
    }

    public List<ConsoleViewModel> getConsolesByManufacturer(String manufacturer){
        List<Console> cList = consoleDao.getConsoleByManufacturer(manufacturer);
        List<ConsoleViewModel> cvmList = new ArrayList<>();

        for (Console c : cList){
            cvmList.add(buildConsoleViewModel(c));
        }
        if (cList.size() == 0)
            return null;
        else
            return cvmList;
    }

    public void updateConsole(ConsoleViewModel consoleViewModel) {
        Console console = new Console();
        console.setConsoleId(consoleViewModel.getConsoleId());
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setConsoleId(console.getConsoleId());

        consoleDao.updateConsole(console);
    }

    public void deleteConsole(int id) {
        consoleDao.deleteConsole(id);
    }


    //Games
    public GameViewModel addGame(GameViewModel gameViewModel) {
        Game game = new Game();
        game.setTitle(gameViewModel.getTitle());
        game.setErsbRating(gameViewModel.getErsbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());

        game = gameDao.addGame(game);

        gameViewModel.setGameId(game.getGameId());

        return gameViewModel;
    }

    public GameViewModel getGameById(int id) {
        Game game = gameDao.getGame(id);
        if (game == null)
            return null;
        else
            return buildGameViewModel(game);
    }

    public void updateGame(GameViewModel gameViewModel) {
        Game game = new Game();
        game.setGameId(gameViewModel.getGameId());
        game.setTitle(gameViewModel.getTitle());
        game.setErsbRating(gameViewModel.getErsbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());

        gameDao.updateGame(game);
    }

    public void deleteGame(int id) {
        gameDao.deleteGame(id);
    }


    //T-Shirts

    public TShirtViewModel addTShirt(TShirtViewModel tShirtViewModel) {
        TShirt tShirt = new TShirt();

        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());

        tShirt = tShirtDao.addTShirt(tShirt);

        tShirtViewModel.settShirtId(tShirt.getTShirtId());

        return tShirtViewModel;
    }

    public TShirtViewModel getTShirt(int id) {
        TShirt tshirt = tShirtDao.getTShirt(id);
        if (tshirt == null)
            return null;
        else
            return buildTShirtViewModel(tshirt);
    }

    public void updateTShirt(TShirtViewModel tShirtViewModel) {
        TShirt tShirt = new TShirt();
        tShirt.settShirtId(tShirtViewModel.getTShirtId());
        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());

        tShirtDao.updateTShirt(tShirt);
    }

    public void deleteTShirt(int id) {
        tShirtDao.deleteTShirt(id);
    }


    // ------------------------------------------------------------------------------

    //builds
    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setInvoiceId(invoice.getInvoiceId());
        invoiceViewModel.setName(invoice.getName());
        invoiceViewModel.setStreet(invoice.getStreet());
        invoiceViewModel.setCity(invoice.getCity());
        invoiceViewModel.setState(invoice.getState());
        invoiceViewModel.setZipcode(invoice.getZipcode());
        invoiceViewModel.setItemType(invoice.getItemType());
        invoiceViewModel.setItemId(invoice.getItemId());
        invoiceViewModel.setUnitPrice(invoice.getUnitPrice());
        invoiceViewModel.setQuantity(invoice.getQuantity());
        invoiceViewModel.setSubtotal(invoice.getSubtotal());
        invoiceViewModel.setTax(invoice.getTax());
        invoiceViewModel.setProcessingFee(invoice.getProcessingFee());
        invoiceViewModel.setTotal(invoice.getTotal());

        return invoiceViewModel;
    }

    private ConsoleViewModel buildConsoleViewModel(Console console) {

        ConsoleViewModel consoleViewModel = new ConsoleViewModel();
        consoleViewModel.setConsoleId(console.getConsoleId());
        consoleViewModel.setModel(console.getModel());
        consoleViewModel.setManufacturer(console.getManufacturer());
        consoleViewModel.setMemoryAmount(console.getMemoryAmount());
        consoleViewModel.setProcessor(console.getProcessor());
        consoleViewModel.setPrice(console.getPrice());
        consoleViewModel.setQuantity(console.getQuantity());

        return consoleViewModel;

    }

    private GameViewModel buildGameViewModel(Game game) {

        GameViewModel gameViewModel = new GameViewModel();
        gameViewModel.setGameId(game.getGameId());
        gameViewModel.setTitle(game.getTitle());
        gameViewModel.setErsbRating(game.getErsbRating());
        gameViewModel.setDescription(game.getDescription());
        gameViewModel.setPrice(game.getPrice());
        gameViewModel.setStudio(game.getStudio());
        gameViewModel.setQuantity(game.getQuantity());

        return gameViewModel;

    }

    private TShirtViewModel buildTShirtViewModel(TShirt tShirt) {

        TShirtViewModel tShirtViewModel = new TShirtViewModel();
        tShirtViewModel.settShirtId(tShirt.getTShirtId());
        tShirtViewModel.setSize(tShirt.getSize());
        tShirtViewModel.setColor(tShirt.getColor());
        tShirtViewModel.setDescription(tShirt.getDescription());
        tShirtViewModel.setPrice(tShirt.getPrice());
        tShirtViewModel.setQuantity(tShirt.getQuantity());

        return tShirtViewModel;

    }


}
