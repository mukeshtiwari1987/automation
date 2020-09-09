package stepDefinations;

import Pages.HomePage;
import Pages.ProductListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

import static utils.CSVFIleHandler.writeDataToFile;

public class ProductSearch {

    public WebDriver driver;

    HomePage homePage = new HomePage();
    ProductListPage productListPage = new ProductListPage();
    List<Product> list_products;

    @Given("User Launch {string} browser")
    public void user_launch_browser(String browserName) {
        if(browserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        homePage.setBrowser(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String string) {
        homePage.openPage(string);
    }

    @When("User closes the login popup")
    public void user_closes_the_login_popup() {
        homePage.closeLoginPopup();
    }

    @When("User search {string}")
    public void user_search(String string) {
        homePage.search(string);
    }

    @Then("Sort the page result from low to high")
    public void sort_the_page_result_from_low_to_high() {
        productListPage.setBrowser(driver);
        productListPage.sortProducts();
    }

    @Then("navigate to and Capture all details")
    public void navigate_to_and_capture_all_details() {
        list_products = productListPage.captureProductDetails();
        Assert.assertNotEquals(list_products.size(),0);
    }

    @Then("Write Product details to XML File")
    public void write_product_details_to_xml_file() {
        writeDataToFile(list_products);
    }
}
