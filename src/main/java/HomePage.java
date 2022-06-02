import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HomePage extends BasePage{

    By menuLocator = By.id("imdbHeader-navDrawerOpen--desktop");
    By oscarsLocator = By.xpath("//*[contains(text(),'Oscars')]");
    By oscarsYearLocator = By.xpath("//*[contains(text(),'1929')]");
    By theJazzSinger = By.xpath("//*[contains(text(),'The Jazz Singer')]");
    By theCircus = By.xpath("//*[contains(text(),'The Circus')]");
    By homePageLocator = By.id("home_img_holder");
    By searchBoxLocator = By.id("suggestion-search");
    By photosLocator = By.className("ipc-title__text");
    By searchResultLocator = By.className("sc-hBEYos");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToOscars() {
        click(menuLocator);
        waitMethod(oscarsLocator);
        click(oscarsLocator);
        click(oscarsYearLocator);
        scrollPage();
    }

    public void first() {
        click(theCircus);
    }

    public void second() {
        click(theJazzSinger);
    }

    public String getDirector() {
        WebElement getDirector = driver.findElement(By.xpath("(//div[contains(@class, 'ipc-metadata-list')])[1]"));
        String director = getDirector.getText();
        return director;
    }

    public String getWriter() {
        WebElement getWriters = driver.findElement(By.xpath("(//div[contains(@class, 'ipc-metadata-list')])[2]"));
        String writers = getWriters.getText();
        return writers;
    }

    public String getStar() {
        WebElement getStars = driver.findElement(By.xpath("(//div[contains(@class, 'ipc-metadata-list')])[3]"));
        String stars = getStars.getText();
        return stars;
    }

    public void backHomePage(){
        click(homePageLocator);
        sendKeys(searchBoxLocator,"The Circus");
        waitMethod(searchResultLocator);
        click(searchResultLocator);
    }
    public void backHomePage2(){
        click(homePageLocator);
        sendKeys(searchBoxLocator,"The Jazz Singer");
        waitMethod(searchResultLocator);
        click(searchResultLocator);
    }

    public String checkResultDirector(){
        WebElement getDirectors2 = driver.findElement(By.xpath("(//div[contains(@class, 'ipc-metadata-list')])[1]"));
        String director2 = getDirectors2.getText();
        return director2;
    }

    public String checkResultWriter(){
        WebElement getWriter2 = driver.findElement(By.xpath("(//div[contains(@class, 'ipc-metadata-list')])[2]"));
        String writer2 = getWriter2.getText();
        return writer2;
    }

    public String checkResultStar(){
        WebElement getStar2 = driver.findElement(By.xpath("(//div[contains(@class, 'ipc-metadata-list')])[3]"));
        String star2 = getStar2.getText();
        return star2;
    }

    public void brokenİmageControll(){
        waitMethod(photosLocator);
        click(photosLocator);
        int brokeImage = 0;
        try {
            List<WebElement> images = driver.findElements(By.tagName("img"));
            for (WebElement img : images){
                if (img != null) {
                    if (img.getAttribute("naturalWidth").equals("0")) {
                        System.out.println(img.getAttribute("outerHTML") + " is broken.");
                        brokeImage++;
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("The page has " + brokeImage + " broken images");
    }

}
