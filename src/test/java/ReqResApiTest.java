
import com.reqres.payload.CreateUserPayload;
import com.reqres.pojos.CreateUserRequestPojo;
import com.reqres.utils.Utility;
import com.reqres.validators.ResponseValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ReqResApiTest {
    Utility utility = new Utility();

    @Test
    public void shouldGetListOfUsers() throws IOException {

        Response usersList = given().spec(utility.requestSpecification()).
                get("/api/users?page=2");

        ResponseValidator.shouldValidateStatusCode(usersList, 200);
        ResponseValidator.shouldGetAllUserName(usersList);


        Assert.assertEquals(utility.getJsonPath(usersList, "total"), "12");
    }

    @Test
    public void shouldGetSpecificUsers() throws IOException {
        Response user = given().spec(utility.requestSpecification()).
                get(" /api/users/2");

        ResponseValidator.shouldValidateStatusCode(user, 200);
        Assert.assertEquals(utility.getJsonPath(user, "data.first_name"), "Janet");
    }

    @Test
    public void shouldNotGetSpecificUsers() throws IOException {
        Response user = given().spec(utility.requestSpecification()).
                get(" /api/users/23");

        ResponseValidator.shouldValidateStatusCode(user, 404);
    }

    @Test
    public void shouldCreateUser() throws IOException {
        CreateUserRequestPojo req = CreateUserRequestPojo.builder().username("morpheous").job("leader").build();
        Response newUser = given().spec(utility.requestSpecification()).
                body(req).
                when().
                post(" /api/users");

        ResponseValidator.shouldValidateStatusCode(newUser, 201);
        Assert.assertEquals(utility.getJsonPath(newUser, "username"), "morpheous");
    }

    @Test
    public void shouldUpdateUser() throws IOException {
        CreateUserRequestPojo req = CreateUserRequestPojo.builder().username("morpheous").job("king").build();
        Response updatedUser = given().spec(utility.requestSpecification()).
                body(req).
                when().
                put(" /api/users/2");

        ResponseValidator.shouldValidateStatusCode(updatedUser, 200);
        Assert.assertEquals(utility.getJsonPath(updatedUser, "job"), "king");
    }

    @Test
    public void shouldDeleteUser() throws IOException {
        Response deletedUserResponse = given().spec(utility.requestSpecification()).
                when().
                delete(" /api/users/2");

        ResponseValidator.shouldValidateStatusCode(deletedUserResponse, 204);
    }
}
