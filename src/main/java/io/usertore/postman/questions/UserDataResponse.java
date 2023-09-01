package io.usertore.postman.questions;

import io.usertore.postman.models.UserModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class UserDataResponse implements Question<UserModel> {

    @Override
    public UserModel answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(UserModel.class);
    }

    public static UserDataResponse was(){
        return new UserDataResponse();
    }
}
