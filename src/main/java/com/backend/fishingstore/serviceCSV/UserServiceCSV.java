package com.backend.fishingstore.serviceCSV;

import com.backend.fishingstore.model.User;
import com.backend.fishingstore.repository.UserRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class UserServiceCSV {

    @Autowired
    private UserRepository userRepository;

    public void importUsersFromCSV() {
        String filePath="src/main/resources/csv/users.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            try {
                reader.readNext(); // Sări peste rândul de header
            } catch (CsvValidationException e) {
                throw new RuntimeException(e);
            }
            while (true) {
                try {
                    if (!((line = reader.readNext()) != null)) break;
                } catch (CsvValidationException e) {
                    throw new RuntimeException(e);
                }
                String name = line[0];
                String email = line[1];
                String password = line[2];
                String location = line[3];
                boolean isVerified = Boolean.parseBoolean(line[4]);
                String verificationToken = line[5];

                User user = User.builder()
                        .name(name)
                        .email(email)
                        .password(password)
                        .location(location)
                        .isVerified(isVerified)
                        .verificationToken(verificationToken)
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build();

                userRepository.save(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
