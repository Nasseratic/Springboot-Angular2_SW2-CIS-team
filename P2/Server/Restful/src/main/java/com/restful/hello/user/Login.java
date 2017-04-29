package com.restful.hello.user;

import com.fasterxml.jackson.annotation.JsonProperty;

class Login {
    String email;
    String pw;

    public Login(@JsonProperty("email") String email, @JsonProperty("pw") String pw) {
        this.email = email;
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}