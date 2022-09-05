package com.example.houserentingsystem.dto.admin;


import com.example.houserentingsystem.enums.RoomStatus;
import com.example.houserentingsystem.enums.RoomType;
import com.example.houserentingsystem.model.admin.AdminRegister;
import com.example.houserentingsystem.model.register.Register;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Date;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminRoomDto {
    private Integer id;
    @NotEmpty(message = "Name Cannot be Empty")
    private String name;

    private String email;
    private String contact;

    @NotEmpty(message = "Address Cannot be empty!!")
    private String address;
    private RoomType roomType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date adminRoomDate;

//    private String filePath;
//
//
//    private MultipartFile multipartFile;

    private RoomStatus roomStatus;

    @NotEmpty()
    private String price;
    @NotEmpty(message = "Description Cannot be empty!!")
    private String description;

    private AdminRegister adminRegister;
}
