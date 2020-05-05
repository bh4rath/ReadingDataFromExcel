package parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionResultsPage extends Page {
    public TransactionResultsPage(WebDriver driver) {
        super(driver);
    }

    private By tableCells = By.cssSelector("#transactionTable tr td");

    public List<String> getTransactionResults(){
        WebDriverWait wait = new WebDriverWait(driver,
                30);
        wait.until(ExpectedConditions.presenceOfElementLocated(tableCells)).isDisplayed();
        return driver.findElements(tableCells)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
