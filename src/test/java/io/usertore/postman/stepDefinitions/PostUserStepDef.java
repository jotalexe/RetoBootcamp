package io.usertore.postman.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.usertore.postman.questions.ServerResponse;
import io.usertore.postman.tasks.DeleteUserTask;
import io.usertore.postman.tasks.PostUserTask;
import io.usertore.postman.tasks.PutUserTask;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class PostUserStepDef {

    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    Actor user= Actor.named("user");

    @Before
    public void setUpBaseUrl(){
        theRestApiBaseUrl= environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://fakestoreapi.com");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));

    }

    @When("I use my API request for testing CRUD")
    public void iUseMyAPIRequestForTestingCRUD() {
        user.attemptsTo(
                PostUserTask.on()

        );

    }

    @Then("I validate the response of my API is {int}")
    public void iValidateTheResponseOfMyAPIIs(Integer resServer) {
        user.should(
                seeThat(
                        "The response code was: ",
                        ServerResponse.was(),
                        equalTo(resServer)
                )
        );
    }
}
