import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.response.Response;
import org.testng.Assert;

public class ResponseValidator {

    public static void shouldGetAllUserName(Response res) {
        UserDataPojo[] data = res.jsonPath().getObject("data", UserDataPojo[].class);
        for (UserDataPojo ud : data) {
            System.out.println(ud.getFirst_name());
        }
    }

    public static void shouldValidateStatusCode(Response res, int statuscode) {
        Assert.assertEquals(res.getStatusCode(), statuscode);
    }
// for(int i=0;i<res.jsonObjectArray("data").length()-1;i++){
//        System.out.println(res.jsonObjectArray("data").get("first_name"));
//        }
}
