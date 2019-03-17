package com.xaomi.sm.controller;

import com.xaomi.sm.entity.Department;
import com.xaomi.sm.entity.Staff;
import com.xaomi.sm.service.DepartmentService;
import com.xaomi.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 * author:XAO-MI
 * Date:2019/3/8
 * Time:20:30
 */
@Controller("staffController")
public class StaffController {
    @Autowired
   private StaffService staffService;

    @Autowired
    private DepartmentService departmentService;
    public void list(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {
        List<Staff> list=staffService.getAll();
        request.setAttribute("LIST",list);
        request.getRequestDispatcher("../staff_list.jsp").forward(request,response);
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {

        List<Department> list = departmentService.getAll();
        request.setAttribute("DLIST",list);
        request.getRequestDispatcher("../staff_add.jsp").forward(request,response);
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {
        String account=request.getParameter("account");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String idNumber=request.getParameter("idNumber");
        String info=request.getParameter("info");
        Date bornDate=null;
        try {
            bornDate=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer did=Integer.parseInt(request.getParameter("did"));

        Staff staff=new Staff();
        staff.setInfo(info);
        staff.setBornDate(bornDate);
        staff.setIdNumber(idNumber);
        staff.setDid(did);
        staff.setAccount(account);
        staff.setName(name);
        staff.setSex(sex);

        staffService.add(staff);
        response.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        Staff staff=staffService.get(id);
        request.setAttribute("OBJ",staff);
        List<Staff> list=staffService.getAll();
        request.setAttribute("DLIST",list);
        request.getRequestDispatcher("../staff_edit.jsp").forward(request,response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String idNumber = request.getParameter("idNumber");
        String info =request.getParameter("info");

        Date bornDate=null;
        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer did = Integer.parseInt(request.getParameter("did"));

        Staff staff = staffService.get(id);
        staff.setInfo(info);
        staff.setBornDate(bornDate);
        staff.setIdNumber(idNumber);
        staff.setDid(did);
        staff.setAccount(account);
        staff.setName(name);
        staff.setSex(sex);

        staffService.edit(staff);
        response.sendRedirect("list.do");
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        staffService.remove(id);
        response.sendRedirect("list.do");
    }

    public void detail(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        Staff staff=staffService.get(id);
        request.setAttribute("OBJ",staff);
        request.getRequestDispatcher("../staff_detail.jsp").forward(request,response);
    }
}
