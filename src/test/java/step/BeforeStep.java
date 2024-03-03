package step;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.Given;


public class BeforeStep {
    @Given("I open the site {string}")
    public void openWebSite(String url) {
        Configuration.timeout = 60000;
        Selenide.open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterStep
    public void makeScreenShot(){
        Selenide.screenshot(System.currentTimeMillis() + "step");
    }
}
