package com.example.lesson278;

import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import mysql.pets.Pet;
import mysql.pets.PetsBD;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Pet> pets = PetsBD.select();
        request.setAttribute("pets", pets);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}