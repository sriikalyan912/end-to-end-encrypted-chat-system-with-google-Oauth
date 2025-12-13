package com.quickchat.chat_server.Controllers.Auth;

import com.quickchat.chat_server.Modal.LoginRequest;
import com.quickchat.chat_server.Services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    public AuthController(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtService jwtService
    ) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest cred) {
        try {
            this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            cred.getUsername(), cred.getPassword()
                    )
            );
            UserDetails userDetails = userDetailsService.loadUserByUsername(cred.getUsername());
            String jwtToken = jwtService.generateToken(userDetails);
            return ResponseEntity.ok(Map.of("jwtToken", jwtToken));
        } catch (UsernameNotFoundException exception) {
            return ResponseEntity.status(401).body(Map.of("errorMessage", "Unauthorized: User not found!"));
        }
    }
}
