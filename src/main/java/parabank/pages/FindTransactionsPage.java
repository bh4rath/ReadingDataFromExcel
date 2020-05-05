package parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FindTransactionsPage extends Page {
    public FindTransactionsPage(WebDriver driver) {
        super(driver);
    }

    private By accountDropdown = By.id("accountId");
    private By transactionIdField = By.id("criteria.transactionId");
    private By findTransactionsButton = By.cssSelector("button[ng-click=\"criteria.searchType = 'ID'\"]");

    public void selectAccountId(String id){
        Select dropdown = new Select(driver.findElement(accountDropdown));
        dropdown.selectByVisibleText(id);
    }

    public TransactionResultsPage searchByTransactionID(String accountId, String transactionId){
        selectAccountId(accountId);
        driver.findElement(transactionIdField).sendKeys(transactionId);
        driver.findElement(findTransactionsButton).click();
        return new TransactionResultsPage(driver);
    }
}
