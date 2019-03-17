package com.xaomi.sm.dao;

import com.xaomi.sm.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IDEA
 * author:XAO-MI
 * Date:2019/3/8
 * Time:15:35
 */
@Repository("departmentDao")
public interface DepartmentDao {
    void insert(Department department);
    void delete(Integer id);
    void update(Department department);
    Department selectById(Integer id);
    List<Department> selectAll();
}
