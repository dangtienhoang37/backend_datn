package hoanghoi.datn.service.impl;

import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.entity.Parking;
import hoanghoi.datn.entity.RecordHistory;
import hoanghoi.datn.entity.ReservationSchedule;
import hoanghoi.datn.repository.AccountRepository;
import hoanghoi.datn.repository.ParkingRepository;
import hoanghoi.datn.repository.RecordHistoryRepository;
import hoanghoi.datn.repository.ReservationScheduleRepository;
import hoanghoi.datn.service.InOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Service
public class InOutServiceImpl implements InOutService {

    @Autowired
    private ReservationScheduleRepository reservationScheduleRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ParkingRepository parkingRepository;
    @Autowired
    private RecordHistoryRepository recordHistoryRepository;

    @Override
    public ApiResponse checkin(UUID deviceId, UUID accountId, long timestamp, MultipartFile file) {
        //kiem tra timestamp
        System.out.println("entry in");
        long currentTimest = System.currentTimeMillis();
        boolean isValidTimestamp = (Math.abs(currentTimest - timestamp) < 1000 * 1000);
        System.out.println("1 "+currentTimest);
        System.out.println("2 "+timestamp);


        System.out.println(isValidTimestamp);

        if(isValidTimestamp) {
            // kiem tra acc nay co dat truoc khong
            // send img de ocr
            var targetAcc = accountRepository.findById(accountId).orElse(null);
            Parking targetParking = parkingRepository.findByDeviceId(deviceId);

            if(Objects.isNull(targetAcc)){
                throw new RuntimeException("account id not valid");
            }

            ReservationSchedule targetReservation = reservationScheduleRepository.findByAccount(targetAcc).orElse(null);
            if(Objects.nonNull(targetReservation)){
                // truong hop dat truoc

                Parking targetParkingBooking = targetReservation.getParking();
                if(Objects.equals(targetParking,targetParkingBooking)){
                    // doi ocr ve de persit
                    // tao record gui xe
                    RecordHistory newRecord = new RecordHistory().builder()
                            .parking(targetParkingBooking)
                            .account(targetAcc)
                            .spotIndex(0)
                            .lPlateNumber("test plate")
                            .entryTime(Instant.now())
                            .build();
                    recordHistoryRepository.save(newRecord);
                    // mo barie checkin
                    ApiResponse response = new ApiResponse().builder()
                            .code(1000)
                            .isSucess(true)
                            .message("mo barie")
                            .build();
                    return  response;
                } else {
                    // mo barie quay tro lai
                    ApiResponse response = new ApiResponse().builder()
                            .code(1000)
                            .isSucess(true)
                            .message("quay lai")
                            .build();
                    return  response;
                }

                //mqtt push
            } else{
                // mqtt push - mo barie - check tai khoan neu so du thap thi yeu cau nap them
                RecordHistory newRecord = new RecordHistory().builder()
                        .parking(targetParking)
                        .account(targetAcc)
                        .spotIndex(0)
                        .lPlateNumber("test plate")
                        .entryTime(Instant.now())
                        .build();
                recordHistoryRepository.save(newRecord);
                ApiResponse response = new ApiResponse().builder()
                        .code(1000)
                        .isSucess(true)
                        .message("mo barie - khong dat truoc")
                        .build();
                return  response;
            }


        } else {
            throw new RuntimeException();
        }

        // kiem tra co dung bai dat truoc khong-> dung thi tiep theo, sai thi mo barie thoat va thong bao
        // neu dung thi mo barie
        // gui file sang service ocr
        // cho ocr xong thi ocr tra ve kq-> persit vao db

    }

    @Override
    public ApiResponse checkout(UUID deviceId, UUID accountId, long timestamp, MultipartFile file) {

        return null;
    }
}
