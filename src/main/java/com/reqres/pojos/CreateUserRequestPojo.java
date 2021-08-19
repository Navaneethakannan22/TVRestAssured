package com.reqres.pojos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateUserRequestPojo {
    private String username;
    private String job;

}
