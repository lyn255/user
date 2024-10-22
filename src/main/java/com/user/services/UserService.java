package com.user.services;

import com.user.model.User;

public interface UserService {
    User registerUser(User user);
    User loginUser(String username, String password);
}
