package com.xaomi.sm.service.Impl;

import com.xaomi.sm.dao.SelfDao;
import com.xaomi.sm.dao.StaffDao;
import com.xaomi.sm.entity.Staff;
import com.xaomi.sm.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 * author:XAO-MI
 * Date:2019/3/8
 * Time:21:44
 */
@Service("selfService")
public class SelfServiceImpl implements SelfService {
    @Autowired
    private StaffDao staffDao;

    @Autowired
    private SelfDao selfDao;
    public Staff login(String account, String password) {
       Staff staff=selfDao.selectByAccount(account);
       if(staff==null) return null;
       if(staff.getPassword().equals(password)) return staff;
        return null;
    }

    public void changePassword(Integer id, String password) {
        Staff staff=staffDao.selectById(id);
        staff.setPassword(password);
        staffDao.update(staff);
    }
}
