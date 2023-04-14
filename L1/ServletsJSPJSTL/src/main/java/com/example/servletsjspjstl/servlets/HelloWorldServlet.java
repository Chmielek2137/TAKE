package com.example.servletsjspjstl.servlets;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "HelloWorldServlet", value = {"/HelloWorldServlet"})
public class HelloWorldServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        request.setCharacterEncoding("windows-1250");

        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        out.println("<html>");
        out.println("<head><title>Hello World Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Hello World!</h1>");

        out.println("<p>Witaj, " + name + ", masz " + age + " lat</p>");

        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    public void destroy() {
    }
}