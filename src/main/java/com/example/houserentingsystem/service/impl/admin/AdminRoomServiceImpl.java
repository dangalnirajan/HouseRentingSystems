package com.example.houserentingsystem.service.impl.admin;

import com.example.houserentingsystem.component.authorizeUser.AuthorizeUser;
import com.example.houserentingsystem.dto.admin.AdminRoomDto;
import com.example.houserentingsystem.enums.RoomStatus;
import com.example.houserentingsystem.model.admin.adminRoom.AdminRoom;
import com.example.houserentingsystem.repo.admin.AdminRegisterRepo;
import com.example.houserentingsystem.repo.admin.AdminRoomRepo;
import com.example.houserentingsystem.repo.user.UserRoomRepo;
import com.example.houserentingsystem.service.admin.AdminRoomService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author dangal_nirajan on 10/08/2022
 */
@Service
public class AdminRoomServiceImpl implements AdminRoomService {
    private final AdminRoomRepo adminRoomRepo;
    private final AdminRegisterRepo adminRegisterRepo;
    private final UserRoomRepo userRoomRepo;

    public AdminRoomServiceImpl(AdminRoomRepo adminRoomRepo, AdminRegisterRepo adminRegisterRepo, UserRoomRepo userRoomRepo) {
        this.adminRoomRepo = adminRoomRepo;
        this.adminRegisterRepo = adminRegisterRepo;
        this.userRoomRepo = userRoomRepo;
    }


    @Override
    public AdminRoomDto save(AdminRoomDto adminRoomDto) throws ParseException, IOException {
        AdminRoom entity = new AdminRoom();
            entity.setId(adminRoomDto.getId());
            entity.setName(adminRoomDto.getName());
            entity.setContact(adminRoomDto.getContact());
            entity.setAddress(adminRoomDto.getAddress());
            entity.setEmail(adminRoomDto.getEmail());
            entity.setRoomType(adminRoomDto.getRoomType());
            entity.setAdminRoomDate(adminRoomDto.getAdminRoomDate());
            entity.setDescription(adminRoomDto.getDescription());
            entity.setPrice(adminRoomDto.getPrice());
            entity.setAdminRegister(AuthorizeUser.getAdminRegister());

            if (entity.getId() == null) {
                entity.setRoomStatus(RoomStatus.AVAILABLE);
            } else {
                entity.setRoomStatus(adminRoomDto.getRoomStatus());
                entity.setAdminRegister(adminRoomDto.getAdminRegister());
            }
             adminRoomRepo.save(entity);
//        }
        return adminRoomDto;
    }

    @Override
    public List<AdminRoomDto> findAll() throws IOException {
        List<AdminRoomDto> adminRoomList = new ArrayList<>();
        List<AdminRoom> adminRoomList1 = adminRoomRepo.getAdminRoomList(AuthorizeUser.getAdminRegister().getId());
        for (AdminRoom adminRoom : adminRoomList1) {
            adminRoomList.add(AdminRoomDto.builder()
                    .id(adminRoom.getId())
                    .name(adminRoom.getName())
                    .contact(adminRoom.getContact())
                    .address(adminRoom.getAddress())
                    .email(adminRoom.getEmail())
                    .roomType(adminRoom.getRoomType())
                    .adminRoomDate(adminRoom.getAdminRoomDate())
                    .roomStatus(adminRoom.getRoomStatus())
                    .description(adminRoom.getDescription())
                    .price(adminRoom.getPrice())
                            .adminRegister(adminRoom.getAdminRegister())

                    .build());

        }
        return adminRoomList;

    }

    @Override
    public AdminRoomDto findById(Integer integer) throws IOException {
        AdminRoom adminRoom;
        Optional<AdminRoom> optionalAdminRoom = adminRoomRepo.findById(integer);
        if (optionalAdminRoom.isPresent()) {
            adminRoom = optionalAdminRoom.get();
            return AdminRoomDto.builder()
                    .id(adminRoom.getId())
                    .name(adminRoom.getName())
                    .contact(adminRoom.getContact())
                    .address(adminRoom.getAddress())
                    .email(adminRoom.getEmail())
                    .roomType(adminRoom.getRoomType())
                    .adminRoomDate(adminRoom.getAdminRoomDate())
                    .roomStatus(adminRoom.getRoomStatus())
                    .price(adminRoom.getPrice())
                    .description(adminRoom.getDescription())
                    .adminRegister(adminRoom.getAdminRegister())
                    .build();
        }
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

        adminRoomRepo.deleteById(integer);
    }
//    public Integer getTotalAdminRoom()
//    {
//        Integer totalAdminRoom=Integer.valueOf(adminRoomRepo.getTotalAdminRoom());
//        return totalAdminRoom;
//    }
//    public Integer getTotalPending()
//    {
//        Integer totalPending=Integer.valueOf(userRoomRepo.getPendingUserRoom());
//        return totalPending;
//    }
//    public Integer getTotalApprove()
//    {
//        Integer totalApprove=Integer.valueOf(userRoomRepo.getApproveUserRoom());
//        return totalApprove;
//    }


    public AdminRoomDto updateAdminRoom(AdminRoomDto adminRoomDto) throws ParseException {
        AdminRoom entity = new AdminRoom();
        entity.setId(adminRoomDto.getId());
        entity.setName(adminRoomDto.getName());
        entity.setContact(adminRoomDto.getContact());
        entity.setAddress(adminRoomDto.getAddress());
        entity.setEmail(adminRoomDto.getEmail());
        entity.setRoomType(adminRoomDto.getRoomType());
        entity.setAdminRoomDate(adminRoomDto.getAdminRoomDate());
        entity.setPrice(adminRoomDto.getPrice());
        entity.setAdminRegister(AuthorizeUser.getAdminRegister());
        entity.setDescription(adminRoomDto.getDescription());
        entity = adminRoomRepo.save(entity);
        return adminRoomDto;
    }
    public List<AdminRoomDto> findAllAdminRoom(){
        List<AdminRoomDto> adminRoomList = new ArrayList<>();
        List<AdminRoom> adminRoomList1 = adminRoomRepo.getAdminRoomDetails();
        for(AdminRoom adminRoom : adminRoomList1){
            adminRoomList.add(AdminRoomDto.builder()
                            .id(adminRoom.getId())
                            .name(adminRoom.getName())
                            .contact(adminRoom.getContact())
                            .email(adminRoom.getEmail())
                            .roomStatus(adminRoom.getRoomStatus())
                            .roomType(adminRoom.getRoomType())
                            .price(adminRoom.getPrice())
                            .adminRoomDate(adminRoom.getAdminRoomDate())
                            .address(adminRoom.getAddress())
                            .description(adminRoom.getDescription())
                    .adminRegister(adminRoom.getAdminRegister())
                    .build());
        }
        return adminRoomList;
    }

}
