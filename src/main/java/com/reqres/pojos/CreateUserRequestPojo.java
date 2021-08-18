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

    public String getUsername() {
        return username;
    }
    public String getJob() {
        return job;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setJob(String job) {
        this.job = job;
    }

}
