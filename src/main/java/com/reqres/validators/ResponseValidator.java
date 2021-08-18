package com.reqres.validators;

import com.reqres.pojos.UserDataPojo;
import io.restassured.response.Response;
import org.testng.Assert;

public class ResponseValidator {

    public static void shouldGetAllUserName(Response res) {
        UserDataPojo[] data = res.jsonPath().getObject("data", UserDataPojo[].class);

        for (UserDataPojo ud : data) {
            System.out.println(ud.getFirst_name());
        }
    }

    public static void shouldValidateStatusCode(Response res, int statusCode) {
        Assert.assertEquals(res.getStatusCode(), statusCode);
    }
}
