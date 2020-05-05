package Files;

import base.BaseTests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import parabank.pages.FindTransactionsPage;
import parabank.pages.Page;
import utils.SpreadsheetUtil;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileTests extends BaseTests {

    @BeforeAll
    public static void launchApp(){
        driver.get("http://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    public void checkTransaction(){
        String user = "john", password = "demo";
        String fileName = "C:/Users/hp/Desktop/Input.xlsx";
        var page = new Page(driver);
        page.login(user, password);
        page.clickMenuLink("Find Transactions");

        var spreadsheet = new SpreadsheetUtil(new File(fileName));
        spreadsheet.switchToSheet("John");

        int row = 1;
        String accountID = spreadsheet.getCellData("Account ID", row);
        String transactionID = spreadsheet.getCellData("Transaction ID", row);


        var findTransactionPage = new FindTransactionsPage(driver);
        var transactionPage = findTransactionPage.searchByTransactionID(accountID, transactionID);

        var results = transactionPage.getTransactionResults();
        System.out.println("results are " + results);

        assertEquals(spreadsheet.getCellData("Date", row), results.get(0));
        assertEquals(spreadsheet.getCellData("Description", row), results.get(1));
        assertEquals(spreadsheet.getCellData("Credit", row), results.get(3));
    }
}