package steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;

public class PianoSteps {
    SelenideElement acceptBtn = $x("//button[@class=' css-5t0isu']");
    SelenideElement rightArrow = $x("//span[@class='arrow arrow-right']");
    SelenideElement playedEdit = $x("//span[@class='piano-menu__played-edit']");
    SelenideElement textField = $x("//div[@class='text-field'] /textarea[@id='song-editor']");
    SelenideElement goBtn = $x("//button[@id='render-song']");
    SelenideElement playBtn = $x("//span[@class='piano-menu__played-play']");
    ElementsCollection notes = $$x("//p[@class='piano-menu__history'] /span");

    @When("Writing the melody {string}")
    public void searchMelody(String melody){
        acceptBtn.click();
        rightArrow.click();
        playedEdit.click();
        textField.setValue(melody);
        goBtn.click();
    }

    @And("Playing the melody")
    public void playingMelody(){
        playBtn.click();
    }

    @Then("Checking that the melody is over")
    public void checkOver(){
        boolean endOfTheMelody = true;
        while (endOfTheMelody){
            if(!Objects.requireNonNull(notes.get(0).getAttribute("class")).contains("correct")){
                endOfTheMelody = false;
            }
        }
    }
}
