package io.usertore.postman.questions;


import io.usertore.postman.models.responseDelete.UserModelDelete;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class DeleteResponse implements Question<UserModelDelete> {

    @Override
    public UserModelDelete answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(UserModelDelete.class);
    }

    public static DeleteResponse was(){
        return new DeleteResponse();
    }


}
