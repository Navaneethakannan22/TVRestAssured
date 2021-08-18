import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class TestClass extends Utility {


//    @BeforeClass
//    public void baseUri() {
//        RestAssured.baseURI = "https://reqres.in/";
//    }

    @Test
    public void shouldGetListOfUsers() throws IOException {

        Response usersList = given().spec(requestSpecification()).
                get("/api/users?page=2");

        ResponseValidator.shouldValidateStatusCode(usersList, 200);
        ResponseValidator.shouldGetAllUserName(usersList);


        Assert.assertEquals(getJsonPath(usersList, "total"), "12");
    }

    @Test
    public void shouldGetSpecificUsers() throws IOException {
        Response user = given().spec(requestSpecification()).
                get(" /api/users/2");

        ResponseValidator.shouldValidateStatusCode(user, 200);
        Assert.assertEquals(getJsonPath(user, "data.first_name"), "Janet");
    }

    @Test
    public void shouldNotGetSpecificUsers() throws IOException {
        Response user = given().spec(requestSpecification()).
                get(" /api/users/23");

        ResponseValidator.shouldValidateStatusCode(user, 404);
    }

    @Test
    public void shouldCreateUser() throws IOException {
        Response newUser = given().spec(requestSpecification()).
                body(CreateUserPayload.createUser("morpheous", "leader")).//body(user)
                when().
                post(" /api/users");

        ResponseValidator.shouldValidateStatusCode(newUser, 201);

        Assert.assertEquals(getJsonPath(newUser, "name"), "morpheous");
    }

    @Test
    public void shouldUpdateUser() throws IOException {
        Response updatedUser = given().spec(requestSpecification()).
                body(CreateUserPayload.createUser("morpheous", "king")).
                when().
                put(" /api/users/2");

        ResponseValidator.shouldValidateStatusCode(updatedUser, 200);
        Assert.assertEquals(getJsonPath(updatedUser, "job"), "king");
    }

    @Test
    public void shouldDeleteUser() throws IOException {
       Response deletedUserResponse= given().spec(requestSpecification()).
                when().
                delete(" /api/users/2");

        ResponseValidator.shouldValidateStatusCode(deletedUserResponse,204);
    }
}
