package com.personal.financial.resource;

import com.personal.financial.resource.request.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthResource {


    @PostMapping
    public ResponseEntity auth(LoginRequest request){


        return ResponseEntity.ok().build();
    }

}
