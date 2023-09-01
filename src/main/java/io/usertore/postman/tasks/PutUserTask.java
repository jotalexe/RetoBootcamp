package io.usertore.postman.tasks;

import io.restassured.http.ContentType;
import io.usertore.postman.models.UserModel;
import io.usertore.postman.questions.BuildDataUser;
import io.usertore.postman.utils.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutUserTask implements Task {

    private final String endPoint;


    public PutUserTask(String endPoint) {
        this.endPoint = endPoint;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        UserModel userInfo = actor.asksFor(BuildDataUser.was());
        Map<String, String> data = Data.extractTo().get(0);
        actor.attemptsTo(
                Post.to(data.get("endpoint")).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo)
                )
        );


    }
    public static PostUserTask on(){
        return instrumented(PostUserTask.class);
    }

}
