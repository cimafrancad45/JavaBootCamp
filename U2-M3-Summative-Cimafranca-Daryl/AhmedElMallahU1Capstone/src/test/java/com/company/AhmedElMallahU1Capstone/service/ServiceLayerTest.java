package com.company.AhmedElMallahU1Capstone.service;

import com.company.AhmedElMallahU1Capstone.dao.*;
import com.company.AhmedElMallahU1Capstone.dto.*;
import com.company.AhmedElMallahU1Capstone.viewmodel.ConsoleViewModel;
import com.company.AhmedElMallahU1Capstone.viewmodel.GameViewModel;
import com.company.AhmedElMallahU1Capstone.viewmodel.InvoiceViewModel;
import com.company.AhmedElMallahU1Capstone.viewmodel.TShirtViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    ServiceLayer service;
    GameDao gameDao;
    ConsoleDao consoleDao;
    TShirtDao tShirtDao;
    InvoiceDao invoiceDao;
    TaxRateDao taxRateDao;
    ProcessingFeeDao processingFeeDao;

    @Before
    public void setUp() throws Exception {
        setUpGameDaoMock();
        setUpConsoleDaoMock();
        setUpTShirtDaoMock();
        setUpInvoiceDaoMock();
        setUpTaxRateDaoMock();
        setUpProcessingFeeDaoMock();

        service = new ServiceLayer(gameDao, consoleDao, tShirtDao, invoiceDao, taxRateDao, processingFeeDao);
    }

    //
    // Game Service Test
    //
    @Test
    public void saveFindUpdateGame() {
        GameViewModel gvm = new GameViewModel();
        gvm.setTitle("Tomb Raider");
        gvm.setDescription("Tomb Raider Desc");
        gvm.setStudio("Feral");
        gvm.setErsbRating("R");
        gvm.setPrice(new BigDecimal("59.99").setScale(2));
        gvm.setQuantity(500);

        //Add Game
        gvm = service.saveGame(gvm);

        //Find Game
        GameViewModel gameFromService = service.findGame(gvm.getId());

        assertEquals(gvm, gameFromService);

        //Update Game
        gvm.setPrice(new BigDecimal("29.99").setScale(2));
        GameViewModel updatedGameFromService = service.updateGame(gvm);

        assertEquals(gvm, updatedGameFromService);
    }

    @Test
    public void findAllGamesAndByStudioErsbAndTitle() {

        List<GameViewModel> games = service.findAllGames();

        assertEquals(games.size(), 3);

        games = service.findGamesByStudio("Feral");

        assertEquals(games.size(), 2);

        games = service.findGamesByErsbRating("M");

        assertEquals(games.size(), 1);

        games = service.findGamesByTitle("Tomb Raider 3");

        assertEquals(games.size(), 1);
    }

    //
    // Console Service Test
    //
    @Test
    public void saveFindUpdateConsole() {
        ConsoleViewModel cvm = new ConsoleViewModel();
        cvm.setModel("PS4 Pro");
        cvm.setManufacturer("Sony");
        cvm.setMemoryAmount("16GB");
        cvm.setProcessor("Quad core i-678");
        cvm.setPrice(new BigDecimal("399.99").setScale(2));
        cvm.setQuantity(250);

        //Add Console
        cvm = service.saveConsole(cvm);

        //Find Console
        ConsoleViewModel consoleFromService = service.findConsole(cvm.getId());

        assertEquals(cvm, consoleFromService);

        //Update Console
        cvm.setPrice(new BigDecimal("349.99").setScale(2));
        ConsoleViewModel updatedConsoleFromService = service.updateConsole(cvm);

        assertEquals(cvm, updatedConsoleFromService);
    }

    @Test
    public void findAllConsolesAndByManufacturer() {
        List<ConsoleViewModel> consoles = service.findAllConsoles();

        assertEquals(consoles.size(), 2);

        consoles = service.findConsolesByManufacturer("Sony");

        assertEquals(consoles.size(), 1);
    }

    //
    // TShirt Service Test
    //
    @Test
    public void saveFindUpdateTShirt() {
        TShirtViewModel tvm = new TShirtViewModel();
        tvm.setColor("Red");
        tvm.setSize("L");
        tvm.setDescription("Large Red T-Shirt");
        tvm.setPrice(new BigDecimal("29.99").setScale(2));
        tvm.setQuantity(350);

        //Add T-Shirt
        tvm = service.saveTShirt(tvm);

        //Find T-Shirt
        TShirtViewModel TShirtFromService = service.findTShirt(tvm.getId());

        assertEquals(tvm, TShirtFromService);

        //Update Console
        tvm.setColor("Blue");
        TShirtViewModel updatedTShirtFromService = service.updateTShirt(tvm);

        assertEquals(tvm, updatedTShirtFromService);
    }

    @Test
    public void findAllTShirtsAndByColorAndSize() {
        List<TShirtViewModel> tShirts = service.findAllTShirts();

        assertEquals(tShirts.size(), 2);

        tShirts = service.findTShirtsByColor("Red");

        assertEquals(tShirts.size(), 1);

        tShirts = service.findTShirtsBySize("M");

        assertEquals(tShirts.size(), 1);
    }

    //
    // Invoice Service Test
    //
    @Test
    public void saveInvoice() {
        // Test Case 1
        //// Add Invoice
        InvoiceViewModel ivmFromService = new InvoiceViewModel();
        ivmFromService.setName("Ahmed ElMallah");
        ivmFromService.setStreet("18Th Street");
        ivmFromService.setCity("Bayonne");
        ivmFromService.setState("NJ");
        ivmFromService.setZipcode("07002");
        ivmFromService.setItemType("T-Shirts");
        ivmFromService.setItemId(31);
        ivmFromService.setQuantity(5);

        ivmFromService = service.saveInvoice(ivmFromService);

        ////Expected Output
        InvoiceViewModel expectedInvoice = new InvoiceViewModel();
        expectedInvoice.setId(41);
        expectedInvoice.setName("Ahmed ElMallah");
        expectedInvoice.setStreet("18Th Street");
        expectedInvoice.setCity("Bayonne");
        expectedInvoice.setState("NJ");
        expectedInvoice.setZipcode("07002");
        expectedInvoice.setItemType("T-Shirts");
        expectedInvoice.setItemId(31);
        expectedInvoice.setQuantity(5);
        expectedInvoice.setUnitPrice(new BigDecimal("29.99").setScale(2));
        expectedInvoice.setProcessingFee(new BigDecimal("1.98").setScale(2));
        expectedInvoice.setTax(new BigDecimal("7.50").setScale(2));
        expectedInvoice.setSubtotal(new BigDecimal("149.95").setScale(2));
        expectedInvoice.setTotal(new BigDecimal("159.43").setScale(2));

        assertEquals(expectedInvoice,ivmFromService);

        //Test Case: Quantity Greater than 10
        ////Add Invoice
        InvoiceViewModel ivmFromService2 = new InvoiceViewModel();
        ivmFromService2.setName("Ahmed ElMallah");
        ivmFromService2.setStreet("18Th Street");
        ivmFromService2.setCity("Bayonne");
        ivmFromService2.setState("NJ");
        ivmFromService2.setZipcode("07002");
        ivmFromService2.setItemType("T-Shirts");
        ivmFromService2.setItemId(31);
        ivmFromService2.setQuantity(15);

        ivmFromService2 = service.saveInvoice(ivmFromService2);

        ////Expected Output
        expectedInvoice.setQuantity(15);
        expectedInvoice.setUnitPrice(new BigDecimal("29.99").setScale(2));
        expectedInvoice.setProcessingFee(new BigDecimal("17.47").setScale(2));
        expectedInvoice.setTax(new BigDecimal("22.49").setScale(2));
        expectedInvoice.setSubtotal(new BigDecimal("449.85").setScale(2));
        expectedInvoice.setTotal(new BigDecimal("489.81").setScale(2));

        assertEquals(ivmFromService2, expectedInvoice);
    }

    //
    // Helper methods
    //
    private void setUpTaxRateDaoMock() {
        taxRateDao = mock(TaxRateDaoJdbcTemplateImpl.class);

        TaxRate taxRate = new TaxRate();
        taxRate.setState("NJ");
        taxRate.setRate(new BigDecimal("0.05").setScale(2));

        doReturn(taxRate).when(taxRateDao).getByState("NJ");
    }

    private void setUpProcessingFeeDaoMock() {
        processingFeeDao = mock(ProcessingFeeDaoJdbcTemplateImpl.class);

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType("T-Shirts");
        processingFee.setFee(new BigDecimal("1.98").setScale(2));

        doReturn(processingFee).when(processingFeeDao).getByItemType("T-Shirts");
    }

    private void setUpGameDaoMock() {
        gameDao = mock(GameDaoJdbcTemplateImpl.class);

        //Response Game
        Game game0 = new Game();
        game0.setTitle("Tomb Raider");
        game0.setDescription("Tomb Raider Desc");
        game0.setStudio("Feral");
        game0.setErsbRating("R");
        game0.setPrice(new BigDecimal("59.99").setScale(2));
        game0.setQuantity(500);

        //Request Game
        Game game1 = new Game();
        game1.setId(11);
        game1.setTitle("Tomb Raider");
        game1.setDescription("Tomb Raider Desc");
        game1.setStudio("Feral");
        game1.setErsbRating("R");
        game1.setPrice(new BigDecimal("59.99").setScale(2));
        game1.setQuantity(500);

        //Updated Game
        Game game1Updated = new Game();
        game1Updated.setId(11);
        game1Updated.setTitle("Tomb Raider");
        game1Updated.setDescription("Tomb Raider Desc");
        game1Updated.setStudio("Feral");
        game1Updated.setErsbRating("R");
        game1Updated.setPrice(new BigDecimal("29.99").setScale(2));
        game1Updated.setQuantity(500);

        //Additional Games
        //Adding 2nd Game
        Game game2 = new Game();
        game2.setId(12);
        game2.setTitle("Tomb Raider 2");
        game2.setDescription("Tomb Raider 2 Desc");
        game2.setStudio("Feral");
        game2.setErsbRating("M");
        game2.setPrice(new BigDecimal("59.99").setScale(2));
        game2.setQuantity(500);

        //Adding 3rd Game
        Game game3 = new Game();
        game3.setId(13);
        game3.setTitle("Tomb Raider 3");
        game3.setDescription("Tomb Raider 3 Desc");
        game3.setStudio("Sony");
        game3.setErsbRating("R");
        game3.setPrice(new BigDecimal("59.99").setScale(2));
        game3.setQuantity(500);

        List<Game> games = new ArrayList<>();
        List<Game> gamesByStudio = new ArrayList<>();
        List<Game> gamesByERSB = new ArrayList<>();
        List<Game> gamesByTitle = new ArrayList<>();

        games.add(game1); games.add(game2); games.add(game3);
        gamesByStudio.add(game1); gamesByStudio.add(game2);
        gamesByERSB.add(game2);
        gamesByTitle.add(game3);

        doReturn(game1).when(gameDao).addGame(game0);
        doReturn(game1).when(gameDao).getGame(11);
        doReturn(game1Updated).when(gameDao).updateGame(game1Updated);
        doReturn(games).when(gameDao).getAllGames();
        doReturn(gamesByStudio).when(gameDao).getGameByStudio("Feral");
        doReturn(gamesByERSB).when(gameDao).getGameByErsbRating("M");
        doReturn(gamesByTitle).when(gameDao).getGameByTitle("Tomb Raider 3");
    }

    private void setUpConsoleDaoMock() {
        consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);

        //Request Console
        Console console0 = new Console();
        console0.setModel("PS4 Pro");
        console0.setManufacturer("Sony");
        console0.setMemoryAmount("16GB");
        console0.setProcessor("Quad core i-678");
        console0.setPrice(new BigDecimal("399.99").setScale(2));
        console0.setQuantity(250);

        //Response Console
        Console console1 = new Console();
        console1.setModel("PS4 Pro");
        console1.setManufacturer("Sony");
        console1.setMemoryAmount("16GB");
        console1.setProcessor("Quad core i-678");
        console1.setPrice(new BigDecimal("399.99").setScale(2));
        console1.setQuantity(250);
        console1.setId(21);

        //Updated Console
        Console console1Updated = new Console();
        console1Updated.setModel("PS4 Pro");
        console1Updated.setManufacturer("Sony");
        console1Updated.setMemoryAmount("16GB");
        console1Updated.setProcessor("Quad core i-678");
        console1Updated.setPrice(new BigDecimal("349.99").setScale(2));
        console1Updated.setQuantity(250);
        console1Updated.setId(21);

        //Adding 2nd Console
        Console console2 = new Console();
        console2.setId(22);
        console2.setModel("xbox One");
        console2.setManufacturer("Microsoft");
        console2.setMemoryAmount("16GB");
        console2.setProcessor("Quad core i-678");
        console2.setPrice(new BigDecimal("399.99").setScale(2));
        console2.setQuantity(250);

        List<Console> consoles = new ArrayList<>();
        List<Console> consolesByManufacturer = new ArrayList<>();

        consoles.add(console1); consoles.add(console2);
        consolesByManufacturer.add(console1);

        doReturn(console1).when(consoleDao).addConsole(console0);
        doReturn(console1).when(consoleDao).getConsole(21);
        doReturn(console1Updated).when(consoleDao).updateConsole(console1Updated);
        doReturn(consoles).when(consoleDao).getAllConsoles();
        doReturn(consolesByManufacturer).when(consoleDao).getConsoleByManufacturer("Sony");
    }

    private void setUpTShirtDaoMock() {
        tShirtDao = mock(TShirtDaoJdbcTemplateImpl.class);

        // Request T-Shirt
        TShirt tShirt0 = new TShirt();
        tShirt0.setColor("Red");
        tShirt0.setSize("L");
        tShirt0.setDescription("Large Red T-Shirt");
        tShirt0.setPrice(new BigDecimal("29.99").setScale(2));
        tShirt0.setQuantity(350);

        // Response T-Shirt
        TShirt tShirt1 = new TShirt();
        tShirt1.setId(31);
        tShirt1.setColor("Red");
        tShirt1.setSize("L");
        tShirt1.setDescription("Large Red T-Shirt");
        tShirt1.setPrice(new BigDecimal("29.99").setScale(2));
        tShirt1.setQuantity(350);

        // Updated T-Shirt
        TShirt tShirt1Updated =  new TShirt();
        tShirt1Updated.setId(31);
        tShirt1Updated.setColor("Blue");
        tShirt1Updated.setSize("L");
        tShirt1Updated.setDescription("Large Red T-Shirt");
        tShirt1Updated.setPrice(new BigDecimal("29.99").setScale(2));
        tShirt1Updated.setQuantity(350);

        // Additional T-Shirts
        TShirt tShirt2 = new TShirt();
        tShirt2.setId(32);
        tShirt2.setColor("Green");
        tShirt2.setSize("M");
        tShirt2.setDescription("Medium Green T-Shirt");
        tShirt2.setPrice(new BigDecimal("24.99").setScale(2));
        tShirt2.setQuantity(250);

        List<TShirt> tShirts = new ArrayList<>();
        List<TShirt> tShirtsByColor = new ArrayList<>();
        List<TShirt> tShirtsBySize = new ArrayList<>();

        tShirts.add(tShirt1); tShirts.add(tShirt2);
        tShirtsByColor.add(tShirt1);
        tShirtsBySize.add(tShirt2);

        doReturn(tShirt1).when(tShirtDao).addTShirt(tShirt0);
        doReturn(tShirt1).when(tShirtDao).getTShirt(31);
        doReturn(tShirt1Updated).when(tShirtDao).updateTShirt(tShirt1Updated);
        doReturn(tShirts).when(tShirtDao).getAllTShirts();
        doReturn(tShirtsByColor).when(tShirtDao).getTShirtByColor("Red");
        doReturn(tShirtsByColor).when(tShirtDao).getTShirtBySize("M");
    }

    private void setUpInvoiceDaoMock() {
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);

        //Request Invoice
        Invoice invoice0 = new Invoice();
        invoice0.setName("Ahmed ElMallah");
        invoice0.setStreet("18Th Street");
        invoice0.setCity("Bayonne");
        invoice0.setState("NJ");
        invoice0.setZipcode("07002");
        invoice0.setItemType("T-Shirts");
        invoice0.setItemId(31);
        invoice0.setQuantity(5);
        invoice0.setUnitPrice(new BigDecimal("29.99").setScale(2));
        invoice0.setProcessingFee(new BigDecimal("1.98").setScale(2));
        invoice0.setTax(new BigDecimal("7.50").setScale(2));
        invoice0.setSubtotal(new BigDecimal("149.95").setScale(2));
        invoice0.setTotal(new BigDecimal("159.43").setScale(2));

        //Response Invoice
        Invoice invoice1 = new Invoice();
        invoice1.setName("Ahmed ElMallah");
        invoice1.setStreet("18Th Street");
        invoice1.setCity("Bayonne");
        invoice1.setState("NJ");
        invoice1.setZipcode("07002");
        invoice1.setItemType("T-Shirts");
        invoice1.setItemId(31);
        invoice1.setQuantity(5);
        invoice1.setUnitPrice(new BigDecimal("29.99").setScale(2));
        invoice1.setProcessingFee(new BigDecimal("1.98").setScale(2));
        invoice1.setTax(new BigDecimal("7.50").setScale(2));
        invoice1.setSubtotal(new BigDecimal("149.95").setScale(2));
        invoice1.setTotal(new BigDecimal("159.43").setScale(2));
        invoice1.setId(41);

        //Test Case 2
        //Request Invoice
        Invoice invoice10 = new Invoice();
        invoice10.setName("Ahmed ElMallah");
        invoice10.setStreet("18Th Street");
        invoice10.setCity("Bayonne");
        invoice10.setState("NJ");
        invoice10.setZipcode("07002");
        invoice10.setItemType("T-Shirts");
        invoice10.setItemId(31);
        invoice10.setQuantity(15);
        invoice10.setUnitPrice(new BigDecimal("29.99").setScale(2));
        invoice10.setProcessingFee(new BigDecimal("17.47").setScale(2));
        invoice10.setTax(new BigDecimal("22.49").setScale(2));
        invoice10.setSubtotal(new BigDecimal("449.85").setScale(2));
        invoice10.setTotal(new BigDecimal("489.81").setScale(2));

        //Response Invoice
        Invoice invoice11 = new Invoice();
        invoice11.setName("Ahmed ElMallah");
        invoice11.setStreet("18Th Street");
        invoice11.setCity("Bayonne");
        invoice11.setState("NJ");
        invoice11.setZipcode("07002");
        invoice11.setItemType("T-Shirts");
        invoice11.setItemId(31);
        invoice11.setQuantity(15);
        invoice11.setUnitPrice(new BigDecimal("29.99").setScale(2));
        invoice11.setProcessingFee(new BigDecimal("17.47").setScale(2));
        invoice11.setTax(new BigDecimal("22.49").setScale(2));
        invoice11.setSubtotal(new BigDecimal("449.85").setScale(2));
        invoice11.setTotal(new BigDecimal("489.81").setScale(2));
        invoice11.setId(41);

        doReturn(invoice1).when(invoiceDao).addInvoice(invoice0);
        doReturn(invoice11).when(invoiceDao).addInvoice(invoice10);
    }
}