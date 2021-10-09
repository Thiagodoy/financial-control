package com.personal.financial.resource;

import com.personal.financial.resource.request.LoginRequest;
import com.personal.financial.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthResource {


    private final AuthService authService;
    private final AuthenticationManager manager;

    @Autowired
    public AuthResource(AuthService authService, AuthenticationManager manager) {
        this.authService = authService;
        this.manager = manager;
    }

    @PostMapping
    public ResponseEntity auth(LoginRequest request){


        authService.loadUserByUsername(request.getEmail());


        return ResponseEntity.ok().build();
    }

    private void authenticate(String email, String password){

    }

}
