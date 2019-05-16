package com.mccoy.dao;
import com.mccoy.util.HibernateUtil;
import com.mccoy.pojoclass.User;

public interface BaseDao
{
 public boolean login(String username, String password);

 public String register(User user);
}
