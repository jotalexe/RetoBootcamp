package io.usertore.postman.models.responseDelete;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.usertore.postman.models.Address;
import io.usertore.postman.models.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModelDelete {

    @JsonProperty("email")
    public String email;
    @JsonProperty("username")
    public String username;
    @JsonProperty("password")
    public String password;
    @JsonProperty("name")
    public Name name;
    @JsonProperty("address")
    public Address address;
    @JsonProperty("phone")
    public String  phone;

}
