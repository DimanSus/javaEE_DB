package com.example.lesson278;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mysql.pets.Pet;
import mysql.pets.PetsBD;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String petKid = request.getParameter("petKid");
            String petName = request.getParameter("petName");
            int petAge =Integer.parseInt(request.getParameter("petAge"));
            String petColor = request.getParameter("petColor");
            String petOwner = request.getParameter("petOwner");
            Pet pet = new Pet(petKid, petName, petAge, petColor, petOwner);
            PetsBD.insert(pet);
            response.sendRedirect(request.getContextPath()+"/index");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }
}