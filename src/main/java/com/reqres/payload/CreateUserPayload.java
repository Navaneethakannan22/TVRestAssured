package com.reqres.payload;

public class CreateUserPayload {

    public static String createUser(String uname,String job) {

        return "{\n" +
                "    \"name\": \""+uname+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}";
    }
}
