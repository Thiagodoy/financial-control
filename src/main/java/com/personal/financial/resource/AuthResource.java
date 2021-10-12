package com.personal.financial.resource;

import com.personal.financial.document.User;
import com.personal.financial.mapper.UserMapper;
import com.personal.financial.resource.request.LoginRequest;
import com.personal.financial.resource.response.SecurityResponse;
import com.personal.financial.resource.response.UserResponse;
import com.personal.financial.service.AuthService;
import com.personal.financial.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthResource {


    private final AuthService authService;
    private final AuthenticationManager manager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserMapper mapper;


    @Autowired
    public AuthResource(AuthService authService, AuthenticationManager manager, JwtTokenUtil jwtTokenUtil, UserMapper mapper) {
        this.authService = authService;
        this.manager = manager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity auth(@RequestBody LoginRequest request) {

        authenticate(request.getEmail(), request.getPassword());
        User user = (User) authService.loadUserByUsername(request.getEmail());

        SecurityResponse securityResponse = jwtTokenUtil.generateToken(user.getEmail());
        UserResponse response = mapper.toResponse(user);
        response.setSecurity(securityResponse);

        return ResponseEntity.ok(response);
    }

    private void authenticate(String email, String password) {
        manager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
    }

}
