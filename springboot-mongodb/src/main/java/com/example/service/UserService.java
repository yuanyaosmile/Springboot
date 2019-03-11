package com.example.service;

import com.example.pojo.User;
import java.util.List;

public interface UserService {
    public void saveUser(User user);

    //public DeleteResult deleteUser(Long id);

   // public List<User> findUser(String userName, String note, int skip, int limit);

    //public UpdateResult updateUser(Long id, String userName, String note);

    public User getUser(Long id);
}
