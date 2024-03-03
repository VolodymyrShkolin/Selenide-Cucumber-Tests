package step;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class TypeRacerStep {
    private final SelenideElement startGameBtn = $x("//a[@class='gwt-Anchor prompt-button bkgnd-green']");
    private final SelenideElement inputField = $x("//input [@class='txtInput']");
    private final SelenideElement submitBtn = $x("//button[@type='button']");
    private final SelenideElement closeModalWindowBtn = $x("//div[@class='xButton']");
    private final SelenideElement speedResult = $x("//div [@class='rankPanelWpm rankPanelWpm-self']");
    private final SelenideElement agreeBtn = $x("//button[@class=' css-47sehv']");
    private final ElementsCollection partsOfText = $$x("//span[@unselectable='on']");

    @When("Start the game")
    public void startGame() {
        agreeBtn.click();
        startGameBtn.click();
    }

    @And("Waiting for the game to start")
    public void waitFotStartGame(){
        inputField.setValue("");
    }

    @And("Typing highlighted word")
    public void typingHighlightedWord() {
        String firstCharacter = String.valueOf(partsOfText.get(0).getText().charAt(0));
        inputField.setValue(firstCharacter);
        String otherPartOfText;
        StringBuilder firstWord = new StringBuilder();
        for (int i = 0; i < partsOfText.size()-1; i++) {
            if(!partsOfText.get(i).getText().equals(" ")){
                firstWord.append(partsOfText.get(i).getText());
            }
        }
        otherPartOfText = partsOfText.get(partsOfText.size()-1).getText();

        inputField.setValue(firstWord + " ");
        String[] a = otherPartOfText.split(" ");
        for (int i = 0; i < a.length; i++) {
            inputField.setValue(a[i]);
            if(i!=a.length-1){
                inputField.sendKeys(Keys.SPACE);
            }
        }
    }

    @Then("Checking that the game is finished and the count of WPM is over {int}")
    public void checkSpeed(int minValue) {
        submitBtn.click();
        submitBtn.click();
        closeModalWindowBtn.click();
        String[] speedValue = speedResult.getText().split(" ");
        int speed = Integer.parseInt(speedValue[0]);
        Assertions.assertTrue(speed > minValue, "Actual result: " + speed);
    }
}
