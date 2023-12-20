package com.example.lesson278;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mysql.pets.Pet;
import mysql.pets.PetsBD;

import java.io.IOException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Pet pet = PetsBD.selectOne(id);
            if(pet!=null) {
                request.setAttribute("pet", pet);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String petKid = request.getParameter("petKid");
            String petName = request.getParameter("petName");
            int petAge =Integer.parseInt(request.getParameter("petAge"));
            String petColor = request.getParameter("petColor");
            String petOwner = request.getParameter("petOwner");
            Pet pet = new Pet(id, petKid, petName, petAge, petColor, petOwner);
            PetsBD.update(pet);
            response.sendRedirect(request.getContextPath()+"/index");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}