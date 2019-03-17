package com.xaomi.sm.dao;

import com.xaomi.sm.entity.Staff;
import org.springframework.stereotype.Repository;

/**
 * Created with IDEA
 * author:XAO-MI
 * Date:2019/3/8
 * Time:21:38
 */
@Repository("selfDao")
public interface SelfDao {
    Staff selectByAccount(String account);
}
