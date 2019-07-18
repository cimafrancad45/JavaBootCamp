package com.trilogyed.DarylCimafrancaU1Capstone.service;

import com.trilogyed.DarylCimafrancaU1Capstone.dao.*;
import com.trilogyed.DarylCimafrancaU1Capstone.dto.Console;
import com.trilogyed.DarylCimafrancaU1Capstone.dto.Game;
import com.trilogyed.DarylCimafrancaU1Capstone.dto.Invoice;
import com.trilogyed.DarylCimafrancaU1Capstone.dto.TShirt;
import com.trilogyed.DarylCimafrancaU1Capstone.viewmodel.InvoiceViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {
    GameDao gameDao;
    ConsoleDao consoleDao;
    TShirtDao tShirtDao;
    InvoiceDao invoiceDao;
    ServiceLayer service;
    TaxRateDao taxRateDao;
    ProcessingFeeDao processingFeeDao;

    @Before
    public void setUp() throws Exception{

        setUpConsoleMock();
        setUpGameMock();
        setUpTShirtMock();
        setUpInvoiceMock();

        service = new ServiceLayer(gameDao,consoleDao,tShirtDao,invoiceDao,processingFeeDao,taxRateDao);
    }

    private void setUpConsoleMock(){

        consoleDao = mock(ConsoleDaoImpl.class);

        Console console = new Console();

        console.setConsoleId(4);
        console.setModel("Playstation 4");
        console.setManufacturer("Sony");
        console.setProcessor("ARM processor");
        console.setMemoryAmount("32GB");
        console.setPrice(new BigDecimal("499.99"));
        console.setQuantity(25);

        Console console2 = new Console();

        console2.setModel("Switch");
        console2.setManufacturer("Nintendo");
        console2.setProcessor("ARM processor");
        console.setMemoryAmount("16GB");
        console2.setPrice(new BigDecimal("299.99"));
        console2.setQuantity(24);

        List<Console> cList = new ArrayList<>();

        cList.add(console);

        doReturn(console).when(consoleDao).addConsole(console);
        doReturn(console).when(consoleDao).getConsole(4);
        doReturn(cList).when(consoleDao).getAllConsoles();

    }

    private void setUpGameMock(){

        gameDao = mock(GameDaoImpl.class);


        Game game = new Game();

        game.setGameId(3);
        game.setTitle("Samurai Showdown");
        game.setErsbRating("M");
        game.setDescription("A return of an arcade classic fighting game!");
        game.setStudio("SNK");
        game.setPrice(new BigDecimal ("59.99"));
        game.setQuantity(10);

        Game game2 = new Game();

        game2.setTitle("Street Fighter V: Arcade Edition");
        game2.setErsbRating("T");
        game2.setDescription("The latest addition to Capcom's legendary fighting game series, Street Fighter.");
        game2.setStudio("Capcom");
        game2.setPrice(new BigDecimal ("19.99"));
        game2.setQuantity(5);

        List<Game> gList = new ArrayList<>();
        gList.add(game);

        doReturn(game).when(gameDao).addGame(game);
        doReturn(game).when(gameDao).getGame(3);
        doReturn(gList).when(gameDao).getAllGames();

    }


    private void setUpTShirtMock(){
        tShirtDao = mock(TShirtDaoImpl.class);

        TShirt shirt = new TShirt();
        shirt.settShirtId(65);
        shirt.setSize("M");
        shirt.setColor("Blue");
        shirt.setDescription("A Sonic T-shirt");
        shirt.setPrice(new BigDecimal("9.99"));
        shirt.setQuantity(4);

        TShirt shirt2 = new TShirt();
        shirt2.setSize("M");
        shirt2.setColor("Blue");
        shirt2.setDescription("A Sonic T-shirt");
        shirt2.setPrice(new BigDecimal("9.99"));
        shirt2.setQuantity(4);

        List<TShirt> tList = new ArrayList<>();
        tList.add(shirt);

        doReturn(shirt).when(tShirtDao).addTShirt(shirt);
        doReturn(shirt).when(tShirtDao).getTShirt(65);
        doReturn(tList).when(tShirtDao).getAllTShirts();
    }

    private void setUpInvoiceMock(){

        invoiceDao = mock(InvoiceDaoImpl.class);


        Invoice invoice = new Invoice();
        invoice.setInvoiceId(3);
        invoice.setName("Justin");
        invoice.setStreet("24 Lotus Ave");
        invoice.setCity("Princeton Junction");
        invoice.setState("NJ");
        invoice.setZipcode("08550");
        invoice.setItemType("Consoles");
        invoice.setItemId(29);
        invoice.setUnitPrice(new BigDecimal("499.99"));
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal("499.99"));
        invoice.setTax(new BigDecimal("0.05"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        invoice.setTotal(invoice.getSubtotal().
                add(invoice.getProcessingFee()).setScale(2, BigDecimal.ROUND_HALF_UP));

        Invoice invoice2 = new Invoice();
        invoice2.setInvoiceId(3);
        invoice2.setName("Daryl");
        invoice2.setStreet("39 Magical Ln");
        invoice2.setCity("Princeton Junction");
        invoice2.setState("NJ");
        invoice2.setZipcode("08550");
        invoice2.setItemType("Consoles");
        invoice2.setItemId(39);
        invoice2.setUnitPrice(new BigDecimal("299.99"));
        invoice2.setQuantity(1);
        invoice2.setSubtotal(new BigDecimal("299.99"));
        invoice2.setTax(new BigDecimal("0.05"));
        invoice2.setProcessingFee(new BigDecimal("14.99"));
        invoice2.setTotal(invoice2.getSubtotal().
                add(invoice2.getProcessingFee()).setScale(2, BigDecimal.ROUND_HALF_UP));

        List<Invoice> ivcList = new ArrayList<>();
        ivcList.add(invoice);

        doReturn(invoice).when(invoiceDao).addInvoice(invoice2);
        doReturn(invoice).when(invoiceDao).getInvoice(3);
        doReturn(ivcList).when(invoiceDao).getAllInvoices();

    }

    @Test
    public void saveFindInvoice(){
        InvoiceViewModel invoice = new InvoiceViewModel();

        invoice.setInvoiceId(3);
        invoice.setName("Justin");
        invoice.setStreet("24 Lotus Ave");
        invoice.setCity("Princeton Junction");
        invoice.setState("NJ");
        invoice.setZipcode("08550");
        invoice.setItemType("Consoles");
        invoice.setItemId(29);
        invoice.setUnitPrice(new BigDecimal("499.99"));
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal("499.99"));
        invoice.setTax(new BigDecimal("0.05"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        invoice.setTotal(invoice.getSubtotal().
                add(invoice.getProcessingFee()).setScale(2, BigDecimal.ROUND_HALF_UP));

        invoice = service.addInvoice(invoice);

        InvoiceViewModel invoiceFromService = service.getInvoiceById(invoice.getInvoiceId());

        assertEquals(invoice, invoiceFromService);
    }

    @Test
    public void updateInvoice(){

    }

    @Test
    public void deleteInvoice(){

    }

    @Test
    public void addGetConsole(){

    }

    @Test
    public void updateConsole(){

    }

    @Test
    public void deleteConsole(){

    }

    @Test
    public void addGetGame(){

    }

    @Test
    public void updateGame(){

    }

    @Test
    public void deleteGame(){

    }

    @Test
    public void addGetTShirt(){

    }

    @Test
    public void updateTShirt(){

    }

    @Test
    public void deleteTShirt(){

    }
}
