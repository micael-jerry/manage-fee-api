package com.fee.managefeeapi.controller;

import org.springframework.security.config.web.servlet.headers.HeadersSecurityMarker;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class SecurityController {

    @GetMapping(value = "/whoami")
    public Authentication authentication(@HeadersSecurityMarker Authentication authentication) {
        return authentication;
    }
}
