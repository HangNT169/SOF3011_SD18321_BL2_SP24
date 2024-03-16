package com.sof3011.hangnt.B4_CRUDListFixCung.controller;

import com.sof3011.hangnt.B4_CRUDListFixCung.entity.SinhVien;
import com.sof3011.hangnt.B4_CRUDListFixCung.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",  // GET
        "/sinh-vien/search",    // GET
        "/sinh-vien/remove",    // GET
        "/sinh-vien/detail",    // GET
        "/sinh-vien/view-update",// GET
        "/sinh-vien/update",    // POST
        "/sinh-vien/add",        // POST
        "/sinh-vien/view-add"   // GET
})
public class SinhVienServlet extends HttpServlet {

    private SinhVienService service = new SinhVienService();
    private List<SinhVien> listSinhVien = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI(); // Lay noi dung tren duong dan
        if (uri.contains("hien-thi")) {
            //hiển thi ds sinh vien
            this.hienThiSinhVien(request, response);
        } else if (uri.contains("search")) {
            this.search(request, response);
        } else if (uri.contains("remove")) {
            this.remove(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else {
            this.viewAdd(request, response);
        }
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/buoi4/add-sinh-vien.jsp").forward(request,response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String index = request.getParameter("viTri");
        SinhVien sv = service.detailSinhVien(Integer.valueOf(index));
        request.setAttribute("sv1",sv);
        request.getRequestDispatcher("/buoi4/detail-sinh-vien.jsp").forward(request,response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // B1: Lay gia tri tu url xuong (phia view => servlet)
        String index = request.getParameter("a");
        // B2: Goi service
        service.xoaSinhVien(Integer.valueOf(index));
        // B3: Quay ve trang chu
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listSinhVien = service.getAll();
        request.setAttribute("lists", listSinhVien);
        request.getRequestDispatcher("/buoi4/sinhviens.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI(); // Lay noi dung tren duong dan
        if (uri.contains("update")) {
            //update
            this.update(request, response);
        } else {
            this.add(request, response);
        }
    }

    @SneakyThrows
    private void add(HttpServletRequest request, HttpServletResponse response) {
        SinhVien sv = new SinhVien();
        BeanUtils.populate(sv,request.getParameterMap()); // Gan gia tri cua cac o input cho doi tuong
        service.addSinhVien(sv); // Doi tuong sv da co value
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }
}
