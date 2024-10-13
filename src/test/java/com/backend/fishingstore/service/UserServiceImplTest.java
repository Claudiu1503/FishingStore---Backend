package com.backend.fishingstore.service;

import com.backend.fishingstore.model.User;
import com.backend.fishingstore.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListAllUsers() {
        User user1 = User.builder()
                .name("Ion")
                .password("password")
                .email("ion@gamil.com")
                .id(10011)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .isVerified(true)
                .build();
        User user2 = User.builder()
                .name("Ionica")
                .password("password")
                .email("ionel@gamil.com")
                .id(10012)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .isVerified(true)
                .build();

        List<User> expectedUsers = Arrays.asList(user1, user2);

        when(userRepository.findAll()).thenReturn(expectedUsers);

        List<User> actualUsers = userService.listAllUsers();


        assertEquals(expectedUsers, actualUsers);
    }
}
