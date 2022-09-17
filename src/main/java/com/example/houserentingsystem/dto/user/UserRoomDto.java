package com.example.houserentingsystem.dto.user;

import com.example.houserentingsystem.enums.RoomStatus;
import com.example.houserentingsystem.enums.RoomType;
import com.example.houserentingsystem.model.register.Register;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Valid
public class UserRoomDto {
    private Integer id;

    @NotEmpty(message = "Name can not be empty !!")
    private String name;
    @Size(max = 10, min = 10, message = "mobileNumber should be 10.")
    private String contact;

    @NotEmpty(message = "Address can not be empty!!")
    private String address;
    private String email;
    private RoomType roomType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date userRoomDate;

    private RoomStatus roomStatus;
    private Register register;
    private String rentedBy;

//    private String filePath;
//
//    private MultipartFile multipartFile;


    @NotEmpty(message = "Description can not be empty!!")
    private String description;
}
