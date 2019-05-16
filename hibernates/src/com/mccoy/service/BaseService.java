package com.mccoy.service;

import com.mccoy.pojoclass.User;

public interface BaseService {
 public boolean login(String username, String password);

 public String registration(User user);
}