package com.fareye.training.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Getter @Setter @NoArgsConstructor
public class User {
//    @UniqueElements
//    private int user_id;
    private String firstName;
    private String lastName;
    private String email;
//    @JsonFormat(pattern = "yyyy-mm-dd")
    private String createdDate;
//    @JsonFormat(pattern = "yyyy-mm-dd")
    private String modifiedDate;
    private boolean verified;
    private String role;
    private boolean activity;
    private String password;

//    @Override
    public void setPassword(String password) {
        this.password =hashPassword(password);
    }
    public String hashPassword(String password){
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
        return hashedPassword;
    }
}