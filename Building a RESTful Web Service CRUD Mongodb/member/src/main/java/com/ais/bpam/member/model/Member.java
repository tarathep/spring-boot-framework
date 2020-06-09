package com.ais.bpam.member.model;

import com.mongodb.lang.NonNull;

//import jdk.jfr.Name;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Member {
    @Id
    private String id;

    //@Name("name")
    @NonNull
    private String name;

   // @Name("age")
    @NonNull
    private String age;

    //@Name("phone")
    @NonNull
    private String phone;

    //@Name("email")
    @NonNull
    private String email;
}
