import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class TestCase extends BaseTest {

    HomePage homePage;

    @Test
    @Order(1)
    public void firstMovie() {
        homePage = new HomePage(driver);
        homePage.goToOscars();
        homePage.first();
        homePage.getDirector();
        homePage.getWriter();
        homePage.getStar();
        homePage.backHomePage();
    }

    @Test
    @Order(2)
    public void checkResult() {
        Assertions.assertEquals(homePage.checkResultDirector(), homePage.getDirector(),
                "Director name not true!");
        Assertions.assertEquals(homePage.checkResultWriter(), homePage.getWriter(),
                "Writer name not true!");
        Assertions.assertEquals(homePage.checkResultStar(), homePage.getStar(),
                "Stars name not true!");
    }

    @Test
    @Order(3)
    public void imageControl(){
        homePage.brokenİmageControll();
    }

    @Test
    @Order(4)
    public void secondMovie(){
        homePage.goToOscars();
        homePage.second();
        homePage.getDirector();
        homePage.getWriter();
        homePage.getStar();
        homePage.backHomePage2();
    }

    @Test
    @Order(5)
    public void checkResult2() {
        Assertions.assertEquals(homePage.checkResultDirector(), homePage.getDirector(),
                "Director name not true!");
        Assertions.assertEquals(homePage.checkResultWriter(), homePage.getWriter(),
                "Writer name not true!");
        Assertions.assertEquals(homePage.checkResultStar(), homePage.getStar(),
                "Stars name not true!");
    }

    @Test
    @Order(6)
    public void imageControl2(){
        homePage.brokenİmageControll();
    }
}