package com.xaomi.sm.dao;

import com.xaomi.sm.entity.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IDEA
 * author:XAO-MI
 * Date:2019/3/8
 * Time:17:40
 */
@Repository("staffDao")
public interface StaffDao {
    void insert(Staff staff);
    void delete(Integer id);
    void update(Staff staff);
    Staff selectById(Integer id);
    List<Staff> selectAll();

}
