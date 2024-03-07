package com.sof3011.hangnt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/login")
// Value => Duong dan.
// Duong dan bat buoc co dau / => k co source => k build dc tomcat
// BE & FE trao doi thong qua phuong thuc HTTP
// Co 4 loai HTTP Method co ban :
// GET => Hien thi du lieu, Lay <=> READ
// POST => Add <=> CREATE
// PUT => UPDATE
// DELETE => DELETE
// J4, J5: Chi dung 2 loai : Get/ post
// Get: Hien thi, Lay
// Post: Xu ly form
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chuyen trang de hien thi du lieu
        // C1:
        request.getRequestDispatcher("form-login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
