package com.example.Bankmangement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.example.Bankmangement.payload.LoginDto;
import com.example.Bankmangement.payload.RegisterDto;
import com.example.Bankmangement.service.AuthService;

@Controller
@RequestMapping("/api/auth")
public class AuthController {

	
	private AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	
	//login validation 
	@PostMapping("/login")

    public ResponseEntity<String> login(@RequestBody LoginDto loginDto)

    {

        String response=authService.login(loginDto);

        return ResponseEntity.ok(response);

       

    }	
	
	
	 @PostMapping("/register")
	    public ResponseEntity<String> register( @RequestBody RegisterDto registerDto)
	    {

	        String response= authService.register(registerDto); 
	        return new ResponseEntity<>(response,HttpStatus.CREATED);
	    }
	 
	
}
