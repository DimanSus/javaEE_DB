package mysql.pets;

import java.sql.*;
import java.util.ArrayList;

public class PetsBD {
    private static String url = "jdbc:mysql://localhost:3306/mysql";
    public static String username = "root";
    public static String password = "root";
    public static ArrayList<Pet> select(){

        ArrayList<Pet> pets = new ArrayList<Pet>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM pets");
                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String petKid = resultSet.getString(2);
                    String petName = resultSet.getString(3);
                    int petAge = resultSet.getInt(4);
                    String petColor = resultSet.getString(5);
                    String petOwner = resultSet.getString(6);
                    Pet pet = new Pet(id, petKid, petName, petAge, petColor, petOwner);
                    pets.add(pet);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return pets;
    }

    public static Pet selectOne(int id) {

        Pet pet = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM pets WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){

                        int prodId = resultSet.getInt(1);
                        String kid = resultSet.getString(2);
                        String name = resultSet.getString(3);
                        int age = resultSet.getInt(4);
                        String color = resultSet.getString(5);
                        String owner = resultSet.getString(6);
                        pet = new Pet(prodId,kid,name, age, color, owner);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return pet;
    }

    public static int insert(Pet pet) {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO pets (petKid, petName, petAge, petColor, petOwner) Values (?, ?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, pet.getPetKid());
                    preparedStatement.setString(2, pet.getPetName());
                    preparedStatement.setInt(3, pet.getPetAge());
                    preparedStatement.setString(4, pet.getPetColor());
                    preparedStatement.setString(5, pet.getPetOwner());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Pet pet) {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "UPDATE pets SET petKid = ?, petName = ?, petAge = ?, petColor = ?," +
                        "petOwner = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, pet.getPetKid());
                    preparedStatement.setString(2, pet.getPetName());
                    preparedStatement.setInt(3, pet.getPetAge());
                    preparedStatement.setString(4, pet.getPetColor());
                    preparedStatement.setString(5, pet.getPetOwner());
                    preparedStatement.setInt(6, pet.getId());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int delete(int id) {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "DELETE FROM pets WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
