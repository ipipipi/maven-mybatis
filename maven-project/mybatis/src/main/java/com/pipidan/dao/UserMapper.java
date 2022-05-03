package com.pipidan.dao;
import com.pipidan.test.UserMybatis;

import java.util.List;

public interface UserMapper {
    public List<UserMybatis> findByCondition(UserMybatis user);
    public List<UserMybatis> findUserAndOrder();
    public void addUser(UserMybatis user);
    public void updateUser(UserMybatis user);
    public void updateUserBirthday(UserMybatis user);
    public void deleteUser(int userId);
    public List<UserMybatis> findByUserIds(List<Integer> userIds);

}
