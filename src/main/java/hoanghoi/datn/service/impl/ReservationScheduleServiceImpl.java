package hoanghoi.datn.service.impl;

import hoanghoi.datn.dto.request.Creation.BookingCreationRequest;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.entity.Account;
import hoanghoi.datn.entity.ReservationSchedule;
import hoanghoi.datn.enumvar.Role;
import hoanghoi.datn.repository.AccountRepository;
import hoanghoi.datn.repository.ParkingRepository;
import hoanghoi.datn.repository.ReservationScheduleRepository;
import hoanghoi.datn.service.ReservationScheduleService;
import hoanghoi.datn.util.JWToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class ReservationScheduleServiceImpl implements ReservationScheduleService {
    @Autowired
    private JWToken jwToken;
    @Autowired
    private ReservationScheduleRepository reservationScheduleRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ParkingRepository parkingRepository;

    @Override
    @PreAuthorize("hasAuthority('USER')")
    public ApiResponse booking(BookingCreationRequest request, String token) {
        var AccountId = jwToken.getIdFromToken(token);
        if(AccountId == null) {
            throw new RuntimeException("no account id");
        }
        Account existedAcc = accountRepository.findById(AccountId).orElse(null);
        if(Objects.isNull(existedAcc)) {
            throw new RuntimeException("no account found");
        }
        var targetParking = parkingRepository.findById(request.getParkingId()).orElse(null);
        if(Objects.isNull(targetParking)) {
            throw new RuntimeException("no parking found");
        }
        var existedBooking = reservationScheduleRepository.findByAccount(existedAcc).orElse(null);
        if(Objects.nonNull(existedBooking)) {
            throw new RuntimeException("existed, cant create booking");
        }
        ReservationSchedule target = ReservationSchedule.builder()
                .account(existedAcc)
                .parking(targetParking)
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .build();
        new ApiResponse<>();
        return ApiResponse.builder()
                .code(1000)
                .message("create sucessfully")
                .isSucess(true)
                .data(reservationScheduleRepository.save(target))
                .build();
    }

    @Override
    public ApiResponse getAllService() {
        return null;
    }

//    @Override
//    public ApiResponse getAllByAreaService() {
//        return null;
//    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STAFF')")
    public ApiResponse getAllByParking(UUID parkingId,String token) {
        boolean flag = Objects.equals(jwToken.getRoleFromToken(token), Role.ADMIN.toString());
        var AccountId = jwToken.getIdFromToken(token);
        if(AccountId == null) {
            throw new RuntimeException("no account id");
        }
        Account existedAcc = accountRepository.findById(AccountId).orElse(null);
        if(Objects.isNull(existedAcc)) {
            throw new RuntimeException("no account found");
        }

        var targetParking = parkingRepository.findById(parkingId).orElse(null);
        if(Objects.isNull(targetParking)){
            throw new RuntimeException("cant find parking");
        }

        if(Objects.equals(targetParking.getAccount(),existedAcc)){
            flag =true;
        }


        if(flag) {
            // xử lý payment tại đây
            new ApiResponse<>();
            return ApiResponse.builder()
                    .code(1000)
                    .message("find all sucessfully")
                    .isSucess(true)
                    .data(reservationScheduleRepository.findAllByParking(targetParking))
                    .build();
        } else {
            throw new RuntimeException("dont have permission");
        }



    }

    @Override
    public ApiResponse getByUser(UUID id, String token) {
        try {
            // trường hợp là user
            if(Objects.equals(jwToken.getRoleFromToken(token),Role.USER.toString())){
                var targetAcc = accountRepository.findById(jwToken.getIdFromToken(token)).orElse(null);
                if(Objects.isNull(targetAcc)){
                    throw new Exception("acc not existed");
                }
                new ApiResponse<>();
                return ApiResponse.builder()
                        .code(1000)
                        .message("find all sucessfully")
                        .isSucess(true)
                        .data(reservationScheduleRepository.findByAccount(targetAcc))
                        .build();
            } if(Objects.equals(jwToken.getRoleFromToken(token),Role.ADMIN.toString())){
                var targetAcc = accountRepository.findById(id).orElse(null);
                if(Objects.isNull(targetAcc)){
                    throw new Exception("acc not existed");
                }
                new ApiResponse<>();
                return ApiResponse.builder()
                        .code(1000)
                        .message("find all sucessfully")
                        .isSucess(true)
                        .data(reservationScheduleRepository.findByAccount(targetAcc))
                        .build();
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
