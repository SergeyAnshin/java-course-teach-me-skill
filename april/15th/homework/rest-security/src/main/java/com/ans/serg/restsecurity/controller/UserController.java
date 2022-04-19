package com.ans.serg.restsecurity.controller;

import com.ans.serg.restsecurity.configuration.jwt.JWTProvider;
import com.ans.serg.restsecurity.dto.UserLoginDTO;
import com.ans.serg.restsecurity.dto.UserSignupDTO;
import com.ans.serg.restsecurity.entity.User;
import com.ans.serg.restsecurity.exception.EntityNotFoundException;
import com.ans.serg.restsecurity.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JWTProvider jwtProvider;

    public UserController(UserService userService, AuthenticationManager authenticationManager, JWTProvider jwtProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping
    public ResponseEntity<Object> signup(@RequestBody UserSignupDTO userSignupDTO) {
        userService.signup(userSignupDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();
        Optional<User> user = userService.findByUsername(username);
        if (user.isPresent()) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            String jsonWebToken = jwtProvider.generateJWT(username, user.get().getRoles());
            return ResponseEntity.ok(jsonWebToken);
        } else {
            throw new EntityNotFoundException("User with this username doesn't exist!");
        }
    }
}
