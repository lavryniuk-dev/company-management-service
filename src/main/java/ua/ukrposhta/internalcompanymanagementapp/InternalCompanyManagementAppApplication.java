package ua.ukrposhta.internalcompanymanagementapp;

import java.util.Locale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InternalCompanyManagementAppApplication {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        SpringApplication.run(InternalCompanyManagementAppApplication.class, args);
    }
}
