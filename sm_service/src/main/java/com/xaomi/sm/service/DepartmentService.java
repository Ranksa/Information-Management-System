package com.xaomi.sm.service;

import com.xaomi.sm.entity.Department;

import java.util.List;

/**
 * Created with IDEA
 * author:XAO-MI
 * Date:2019/3/8
 * Time:15:38
 */
public interface DepartmentService {
    void add(Department department);
    void remove(Integer id);
    void edit(Department department);
    Department get(Integer id);
    List<Department> getAll();
}
