package com.SpringBoot_Security_Exam.payload;

import java.util.Set;

import com.SpringBoot_Security_Exam.entity.Dispositivo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String name;
    private String username;
    private String email;
    private String password;
    private Set<String> roles;
    private Set<Dispositivo> dispositivi;
}
