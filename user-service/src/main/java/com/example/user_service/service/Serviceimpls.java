package com.example.user_service.service;


import com.example.user_service.dto.UserRegisterDto;
import com.example.user_service.dto.UserResponseDto;
import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class Serviceimpls {


    UserRepository userRepository;
    StreamBridge streamBridge;

    private static final Logger log = LoggerFactory.getLogger(Serviceimpls.class);


    public ResponseEntity<UserResponseDto> registerUser(UserRegisterDto userRegisterDto){

        User user = User.builder()
                        .age(userRegisterDto.getAge())
                        .email(userRegisterDto.getEmail())
                        .name(userRegisterDto.getName())
                        .mobileNumber(userRegisterDto.getMobileNumber())
                        .build();

       User savedUser =  userRepository.save(user);
        UserResponseDto userResponseDto = UserResponseDto.builder()
                .mobileNumber(savedUser.getMobileNumber())
                .name(savedUser.getName())
                .message("Greeting!! "+savedUser.getName()+" register successfully")
                .build();

        sendCommunication(savedUser);

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    private void sendCommunication(User user) {
//        var accountsMsgDto = new AccountsMsgDto(account.getAccountNumber(), customer.getName(),
//                customer.getEmail(), customer.getMobileNumber());
       // log.info("Sending Communication request for the details: {}", accountsMsgDto);
        var result = streamBridge.send("sendCommunication-out-O", user);
        log.info("Is the Communication request successfully triggered ? : {}", result);
    }

    public void updateCommunicationStatus(String email) {
        try {
            User user = userRepository.findByEmailId(email);
            user.setIsEmailSent(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
