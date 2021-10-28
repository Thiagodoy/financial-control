package com.personal.financial.resource.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest implements Request {

    private String email;
    private String name;
    private String password;
    private String newPassword;
    private boolean isEnable;
}
