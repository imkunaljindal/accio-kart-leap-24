package com.example.acciokartservice.controller;

import com.example.acciokartservice.model.Identity;
import com.example.acciokartservice.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/identity")
public class IdentityController {

    private final IdentityService identityService;

    @Autowired
    public IdentityController(IdentityService identityService) {
        this.identityService = identityService;
    }

    @PostMapping("/add")
    public String addIdentity(@RequestBody Identity identity,
                              @RequestParam("email") String email){
        identityService.addIdentity(identity,email);
        return "Identity added";
    }
}
