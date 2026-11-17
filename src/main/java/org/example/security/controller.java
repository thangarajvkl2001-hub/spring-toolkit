package org.example.security;


import org.example.security.entity.LoginRequest;
import org.example.security.entity.User;
import org.example.security.repository.UserRepository;
import org.example.security.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class controller {

    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @PostMapping("/register")
    public String register(
            @RequestBody User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        repository.save(user);

        return "User Registered";
    }


    @PostMapping("/login")
    public String login(
            @RequestBody LoginRequest request){

        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()));

        var roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        return jwtService
                .generateToken(
                        request.getUsername(),roles);
    }

}
