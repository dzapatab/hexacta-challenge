package com.hexacta.stepdefinitions;
import com.hexacta.exceptions.GeneralMessage;
import com.hexacta.models.web.CreateUserRequest;
import com.hexacta.models.web.CreateUserRequestBuilder;
import com.hexacta.utils.enums.GenericEnums;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;

import static com.hexacta.exceptions.GeneralMessage.*;
import static com.hexacta.factory.CreateUserDataFactory.*;
import static com.hexacta.factory.CreateUserDataFactory.createUserRequest;
import static com.hexacta.questions.services.Response.*;
import static com.hexacta.tasks.services.Delete.deleteUser;
import static com.hexacta.tasks.services.Post.createUserWithThe;
import static com.hexacta.tasks.services.Put.modifyUserWithThe;
import static com.hexacta.tasks.services.Get.executeGetMethodWithThe;
import static com.hexacta.utils.enums.GenericEnums.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ServiceStepDefinition { @Before

    @Given("I makes the connection to the api")
    public void iMakesTheConnectionToTheApi() {
        givenThat(theActorCalled("Diego").whoCan(CallAnApi.at("/")));
    }
    @When("Execute the method GET with the resource api {string} with {string}")
    public void executeTheMethodGETWithTheResourceApiWith(String resourceApi, String typeUser) {
        when(theActorInTheSpotlight()).wasAbleTo(executeGetMethodWithThe(resourceApi).with(typeUser));

    }

    @Then("See that the is returned {int}")
    public void seeThatTheIsReturned(Integer statusCode) {
        assertThat(THE_CODES_DO_NOT_MATCH,
                theActorInTheSpotlight().asksFor(getStatusCode()) , equalTo(statusCode)
        );
        then(theActorInTheSpotlight()).should(ResponseConsequence.seeThatResponse(
                THE_CODES_DO_NOT_MATCH, response -> response.statusCode(statusCode)
        ));
    }

    @Then("Check if the user exists successfully for {string}")
    public void checkIfTheUserExistsSuccessfully(String typeUser) {
        theActorInTheSpotlight().should(
                seeThat(USER_WITH_ID_INVALID.getValue().equals(typeUser) ? getHeader() : getMessage(),
                        USER_WITH_ID_INVALID.getValue().equals(typeUser) ? containsString(NOT_FOUND.getValue()) : equalTo(SUCCESS.getValue())
                ).orComplainWith(GeneralMessage.class, THE_MESSAGE_DO_NOT_MATCH)
        );
    }

    @When("Execute the method DELETE with the resource api {string}")
    public void executeTheMethodDELETEWithTheResourceApi(String resourceApi) {
        when(theActorInTheSpotlight()).wasAbleTo(deleteUser(resourceApi));
    }

    @When("Execute the method POST with the resource api {string} with {string}")
    public void executeTheMethodPOSTWithTheResourceApiWith(String resourceApi, String typeUser) {
        when(theActorInTheSpotlight()).wasAbleTo(createUserWithThe(resourceApi).with(createUserRequest(typeUser)));
    }
    @Then("Check if the user was create successfully for {string}")
    public void checkIfTheUserWasCreateSuccessfullyFor(String typeUser) {
        theActorInTheSpotlight().should(seeThat(getNameUser(), equalTo(createUserRequest(typeUser).getName()))
                .orComplainWith(GeneralMessage.class, THE_MESSAGE_DO_NOT_MATCH));
        theActorInTheSpotlight().should(seeThat(
                USER_WITHOUT_JOB_PARAM.getValue().equals(typeUser) ? getResponseBody() : getJob(),
                        USER_WITHOUT_JOB_PARAM.getValue().equals(typeUser) ? not(containsString("job")) : equalTo(createUserRequest(typeUser).getJob()))
                .orComplainWith(GeneralMessage.class, THE_MESSAGE_DO_NOT_MATCH));
    }


    @When("Execute the method PUT with the resource api {string} with {string}")
    public void executeTheMethodPUTWithTheResourceApiWith(String resourceApi, String typeUser) {
        when(theActorInTheSpotlight()).wasAbleTo(modifyUserWithThe(resourceApi).with(createUserRequest(typeUser)));
    }
    @Then("Check if the user was modify successfully for {string}")
    public void checkIfTheUserWasModifySuccessfully(String typeUser) {

        checkIfTheUserWasCreateSuccessfullyFor(typeUser);
    }

    @When("alo")
    public void alo() {
        System.out.println("aaaaaaaaaaaaaaa");
    }


  //  @When("Execute the method {string} with the resource api {string}")
  //  public void executeTheMethodWithTheResourceApi(String requestType, String resourceApi) {
  //      when(theActorInTheSpotlight()).wasAbleTo(RequestDynamic.makeRequest(requestType, resourceApi));
  //  }
}
