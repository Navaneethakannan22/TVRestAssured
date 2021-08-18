package com.reqres.payload;

public class CreateUserPayload {

    public static String createUser(String uname,String job) {

        return "{\n" +
                "    \"name\": \""+uname+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}";
    }
//    public static CreateUserRequestPojo createUser(String uname,String job) {
//        CreateUserRequestPojo req=new CreateUserRequestPojo();
//        req.setUsername(uname);
//        req.setJob(job);
//        return req;
//    }
}
