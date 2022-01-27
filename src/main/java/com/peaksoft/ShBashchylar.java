package com.peaksoft;

import java.sql.*;
import java.util.ArrayList;

public class ShBashchylar {
    private final static String url = "jdbc:postgresql://localhost:5432/6task";
    private final static String user = "postgres";
    private final static String password = "1234";
    private static String name;
    private static  int id;

    public ShBashchylar(int i, String name) {
    }

    public ShBashchylar() {

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

    public static void getBashchy() {
        String zapros1 = "SELECT * FROM bashchy";
        try (Connection conn = connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(zapros1)) {
            while (rs.next()) {
                id =rs.getInt("id") ;
                name=rs.getString("name ");
                ShBashchylar bash=new ShBashchylar(id,name);
                ArrayList<ShBashchylar> shaarlars=new ArrayList<>();
                shaarlars.add(bash);
                System.out.println(id+"  "+name);

            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }


}
