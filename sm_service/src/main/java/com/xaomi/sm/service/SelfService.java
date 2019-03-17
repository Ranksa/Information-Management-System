package com.xaomi.sm.service;

import com.xaomi.sm.entity.Staff;

/**
 * Created with IDEA
 * author:XAO-MI
 * Date:2019/3/8
 * Time:21:42
 */
public interface SelfService {
    Staff login(String account, String password);
    void changePassword(Integer id,String password);
}
