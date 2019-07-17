package com.trilogyed.DarylCimafrancaU1Capstone.service;

import com.trilogyed.DarylCimafrancaU1Capstone.dao.*;
import com.trilogyed.DarylCimafrancaU1Capstone.dto.Console;
import com.trilogyed.DarylCimafrancaU1Capstone.dto.Game;
import com.trilogyed.DarylCimafrancaU1Capstone.dto.Invoice;
import com.trilogyed.DarylCimafrancaU1Capstone.dto.TShirt;
import com.trilogyed.DarylCimafrancaU1Capstone.viewmodel.InvoiceViewModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
    InvoiceServiceLayer service;

    @Autowired
    TaxRateDao taxRateDao;
    @Autowired
    ProcessingFeeDao processingFeeDao;

    @Before
    public void setUp() throws Exception{

        setUpConsoleMock();
        setUpGameMock();
        setUpTShirtMock();
        setUpInvoiceMock();

        service = new InvoiceServiceLayer(gameDao,consoleDao,tShirtDao,invoiceDao,processingFeeDao,taxRateDao);
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
        doReturn(console).when(consoleDao).getAllConsoles();

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
        doReturn(game).when(gameDao).getAllGames();

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
        doReturn(shirt).when(tShirtDao).getAllTShirts();
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
        invoice.setSubtotal(invoice.getUnitPrice().
                add(invoice.getUnitPrice().multiply(taxRateDao.getTax(invoice.getState())))
                .multiply(new BigDecimal(invoice.getQuantity())).setScale(2, BigDecimal.ROUND_HALF_UP));
        invoice.setTax(taxRateDao.getTax(invoice.getState()));
        invoice.setProcessingFee(processingFeeDao.getProcessingFee(invoice.getItemType()));
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
        invoice2.setSubtotal(invoice2.getUnitPrice().
                add(invoice2.getUnitPrice().multiply(taxRateDao.getTax(invoice2.getState())))
                .multiply(new BigDecimal(invoice2.getQuantity())).setScale(2, BigDecimal.ROUND_HALF_UP));
        invoice2.setTax(taxRateDao.getTax(invoice2.getState()));
        invoice2.setProcessingFee(processingFeeDao.getProcessingFee(invoice2.getItemType()));
        invoice2.setTotal(invoice2.getSubtotal().
                add(invoice2.getProcessingFee()).setScale(2, BigDecimal.ROUND_HALF_UP));

        List<Invoice> ivcList = new ArrayList<>();
        ivcList.add(invoice);

        doReturn(invoice).when(invoiceDao).addInvoice(invoice2);
        doReturn(invoice).when(invoiceDao).getInvoice(3);
        doReturn(invoice).when(invoiceDao).getAllInvoices();

    }

    @Test
    public void saveFindInvoice(){
        InvoiceViewModel invoice = new InvoiceViewModel();

        invoice.setInvoiceId(3);
        invoice.setName("Daryl");
        invoice.setStreet("39 Magical Ln");
        invoice.setCity("Princeton Junction");
        invoice.setState("NJ");
        invoice.setZipcode("08550");
        invoice.setItemType("Consoles");
        invoice.setItemId(39);
        invoice.setUnitPrice(new BigDecimal("299.99"));
        invoice.setQuantity(1);
        invoice.setSubtotal(invoice.getUnitPrice().
                add(invoice.getUnitPrice().multiply(taxRateDao.getTax(invoice.getState())))
                .multiply(new BigDecimal(invoice.getQuantity())).setScale(2, BigDecimal.ROUND_HALF_UP));
        invoice.setTax(taxRateDao.getTax(invoice.getState()));
        invoice.setProcessingFee(processingFeeDao.getProcessingFee(invoice.getItemType()));
        invoice.setTotal(invoice.getSubtotal().
                add(invoice.getProcessingFee()).setScale(2, BigDecimal.ROUND_HALF_UP));

        invoice = service.addInvoice(invoice);
        InvoiceViewModel invoice2 = service.getInvoiceById(invoice.getInvoiceId());

        assertEquals(invoice, invoice2);
    }
}
