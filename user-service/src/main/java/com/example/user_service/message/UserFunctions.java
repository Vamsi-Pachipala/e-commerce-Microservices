package com.example.user_service.message;




        import com.example.user_service.service.Serviceimpls;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

        import java.util.function.Consumer;

@Configuration
public class UserFunctions {

    private static final Logger log = LoggerFactory.getLogger(UserFunctions.class);

    @Bean
    public Consumer<String> updateCommunication(Serviceimpls serviceimpls) {
        return email -> {
            log.info("Updating Communication status for the email : " + email);
            serviceimpls.updateCommunicationStatus(email);
        };
    }
}