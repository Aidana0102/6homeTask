package com.peaksoft.dao;

import java.sql.*;
import java.util.ArrayList;

public class ShBashchylar {
    private final static String url = "jdbc:postgresql://localhost:5432/6task";
    private final static String user = "postgres";
    private final static String password = "1234";
    private  String name;
    private   int id;

    public ShBashchylar(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public ShBashchylar() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Connection connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected succesfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }


    public static void addBashchy(int id_B, String name_B) {

        String Value = "insert into bashchy(id_b, name_B) values (?,?)";
        try (Connection conn = connection();
            PreparedStatement statement = conn.prepareStatement(Value)){
            statement.setInt(1, (id_B));
            statement.setString(2, name_B);

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<ShBashchylar> getBashchy() {
        int id;
        String name;

        ArrayList<ShBashchylar> bashchylars = new ArrayList<>();
        String zapros1 = "SELECT * FROM bashchy";
        try (Connection conn = connection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(zapros1);
            while (rs.next()) {
                id = rs.getInt("id_b");
                name = rs.getString("name_b");
                ShBashchylar bash = new ShBashchylar(name, id);
                bashchylars.add(bash);
            }
            connection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bashchylars;
    }



    }


