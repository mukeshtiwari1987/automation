package Pages;

import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static utils.ProductListCalc.checkPrice;


public class ProductListPage extends BasePage{

    List<Product> list_products = new ArrayList<Product>();

    By list_products_price = By.xpath("//div[@class='_1vC4OE _2rQ-NK']");
    By list_product = By.xpath("//div[@class='_3wU53n']");
    By list_product_rating = By.xpath("//div[@class='_3wU53n']//parent::div//span[@class='_2_KrJI']//div");

    By sortLowToHigh = By.xpath("//div[contains(@class,'_1xHtJz') and text()='Price -- Low to High']");

    public void setBrowser(WebDriver driver){
        this.driver = driver;
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    }

    public void sortProducts(){
        clickElement(sortLowToHigh);
    }

    public List<Product> captureProductDetails(){
        boolean hasNextNavigator = true;
        do{
            waitForClickable(list_product);
            List<WebElement> list_of_products = getListOfElements(list_product);
            List<WebElement> list_of_products_price = getListOfElements(list_products_price);
            List<WebElement> list_of_products_rating = getListOfElements(list_product_rating);

            System.out.println("Product Details");
            for(int i=0;i<list_of_products.size();i++){

                //fetch the product detail and price
                String prodNam = getText(list_of_products.get(i));
                String price = getText(list_of_products_price.get(i));
                String rating = getText(list_of_products_rating.get(i));

                //check if the cost is > 40000
                if(checkPrice(price.replaceAll("[^0-9]", ""), 40000)){
                    hasNextNavigator = false;
                    break;
                }

                //Assign the values
                Product product = new Product();
                product.setName(prodNam);
                product.setPrice(price);
                product.setRating(rating);

                //Add the value to the main list
                list_products.add(product);

                System.out.println(prodNam + " : " + price + " : " +rating);
            }

            try{
                WebElement nextPage = driver.findElement(By.xpath("//span[text()='Next']"));
                nextPage.click();
            }catch(Exception e){
                hasNextNavigator = false;
            }
        }while (hasNextNavigator);

        return list_products;
    }

}
