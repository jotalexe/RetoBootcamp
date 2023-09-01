package io.usertore.postman.tasks;


import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteUserTask implements Task {
    private String endPoint = null;

    public DeleteUserTask (String endPoint) {

        this.endPoint = endPoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(endPoint+"/")
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                        )
        );

    }

    public static DeleteUserTask on(){
        return instrumented(DeleteUserTask.class);

        }
    }
