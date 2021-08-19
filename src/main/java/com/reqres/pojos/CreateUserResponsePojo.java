package com.reqres.pojos;

import lombok.Getter;

@Getter
public class CreateUserResponsePojo {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private UserDataPojo data[];
    private SupportDataPojo support;

}
