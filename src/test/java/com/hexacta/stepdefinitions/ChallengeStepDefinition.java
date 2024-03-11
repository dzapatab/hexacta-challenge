package com.hexacta.stepdefinitions;

import com.hexacta.exceptions.GeneralMessage;
import com.hexacta.models.web.CreateUserRequest;
import com.hexacta.tasks.web.InAboutUs;
import com.hexacta.tasks.web.Search;
import com.hexacta.tasks.web.SendDataLetsWorkTogether;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.hexacta.questions.web.GetElement;
import static com.hexacta.exceptions.GeneralMessage.ERROR_NO_MESSAGE_FOUND;
import static com.hexacta.factory.CreateUserDataFactory.createUserRequest;
import static com.hexacta.interactions.Wait.waitTheElement;
import static com.hexacta.questions.web.ValidateInTheForm.ifErrorAllIconsArePresent;
import static com.hexacta.userinterfaces.AboutUs.MESSAGE_MANDATORY_FIRST_NAME;
import static com.hexacta.userinterfaces.Home.ELEMENT;
import static com.hexacta.utils.enums.GenericEnums.IS_PRESENT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ChallengeStepDefinition {

    @When("Search {string}")
    public void search(String valueToSearch) {
        theActorInTheSpotlight().attemptsTo(Search.anOption(valueToSearch));
    }

    @Then("Checks if the message for the {string} exist")
    public void checksIfTheMessageForThe(String value) {
        theActorInTheSpotlight().attemptsTo(waitTheElement(ELEMENT.of(value)).expectedState(IS_PRESENT.getValue()));
        theActorInTheSpotlight().should(seeThat(GetElement.OfFront(ELEMENT.of(value)), equalTo(value.toUpperCase()))
                .orComplainWith(GeneralMessage.class, ERROR_NO_MESSAGE_FOUND));
    }

}
