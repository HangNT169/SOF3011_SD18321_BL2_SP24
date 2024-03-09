package com.sof3011.hangnt.B2_LamViecVoiForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = {"/login","/ket-qua"}) // Value co the chua nhieu duong dan
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
        // Truyen gia tri tu servlet => jsp => setAttribute
        String mess ="Hoc lai roi";
        request.setAttribute("a",mess);
        // Chuyen trang de hien thi du lieu
        // C1:
        request.getRequestDispatcher("form-login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay gia tri tu phia jsp ve servlet => getParameter => cac o input phai co name
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        // B2: Day gia tri tu phia servlet => jsp
        request.setAttribute("x1",name);
        request.setAttribute("x2",pass);
        // B3: Chuyen trang
        request.getRequestDispatcher("/ket-qua.jsp").forward(request,response);
    }
}
