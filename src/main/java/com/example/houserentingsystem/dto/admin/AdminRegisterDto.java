package com.example.houserentingsystem.dto.admin;

import com.example.houserentingsystem.enums.Gender;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminRegisterDto {
    private Integer id;
    @NotEmpty(message = "Name Cannot be Empty")
    private String name;
    private String address;
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    @NotEmpty
    @Size(max = 10, min = 10, message = "mobileNumber should be 10.")
    private String contact;
    private Gender gender;
    @NotEmpty(message = "Id Cannot be empty")
    private String citizenshipNo;
    @NotEmpty()
    private String password;
}
