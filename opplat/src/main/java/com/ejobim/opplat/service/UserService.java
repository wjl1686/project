package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.User;

import java.util.List;

public interface UserService {


    void testLock();

    List<User> getTbUserLists();

    int save();
}
