package com.gstock.msusers.application.representation;

import com.gstock.msusers.domain.Users;
import lombok.Data;

@Data
public class UsersSaveRequest {
    private String cpf;
    private String name;
    private String password;

    public Users toModel(){
        return new Users(cpf, name, password);
    }
}
