package com.isdb.oblivionheadhunter.model.pojo;

import com.isdb.oblivionheadhunter.model.Hero;
import com.isdb.oblivionheadhunter.security.User;
import lombok.Data;

@Data
public class RegistrationRequest {

    private Hero hero;
    private User user;

}
