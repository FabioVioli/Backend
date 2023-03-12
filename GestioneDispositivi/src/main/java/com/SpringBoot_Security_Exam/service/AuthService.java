package com.SpringBoot_Security_Exam.service;

import com.SpringBoot_Security_Exam.payload.LoginDto;
import com.SpringBoot_Security_Exam.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
