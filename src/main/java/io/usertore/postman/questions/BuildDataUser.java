package io.usertore.postman.questions;


import io.usertore.postman.models.Address;
import io.usertore.postman.models.Geolocation;
import io.usertore.postman.models.Name;
import io.usertore.postman.models.UserModel;
import io.usertore.postman.utils.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


import java.util.Map;

public class BuildDataUser implements Question<UserModel> {

    @Override
    public UserModel answeredBy(Actor actor) {
        Map<String, String> data = Data.extractTo().get(0);

        Address address = Address.builder()
                .city("Medellin")
                .street("Poblado")
                .number(22)
                .zipcode("9123")
                .build();

        Name name = Name.builder()
                .firstname(data.get("firstname"))
                .lastname(data.get("lastname"))
                .build();

        UserModel userModel = UserModel.builder()
                .email(data.get("email"))
                .username(data.get("username"))
                .password(data.get("password"))
                .name(name)
                .address(address)
                .phone("3181143")
                .build();
        return userModel;
    }
        public static BuildDataUser was(){
            return new BuildDataUser();
        }

}