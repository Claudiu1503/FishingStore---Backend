package com.backend.fishingstore.service;

import com.backend.fishingstore.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<User> listAllUsers();

}
