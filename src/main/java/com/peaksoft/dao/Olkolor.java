package com.peaksoft.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Olkolor {
        private final static String url = "jdbc:postgresql://localhost:5432/6task";
        private final static String user = "postgres";
        private final static String password = "1234";

        private  int id;
        private  String name;
        private  int kol;

    public Olkolor(int id, String name, int kol) {
        this.id = id;
        this.name = name;
        this.kol = kol;
    }

    public Olkolor() {

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


        public static void addInfAboutOlko(int id_O, String name_O, int sh_sany) {

            String Value = "insert into olko(id_O, name_O, sh_sany) values (?,?,?)";
            try (Connection conn = connection();
                PreparedStatement statement = conn.prepareStatement(Value)){
                statement.setInt(1, (id_O));
                statement.setString(2, name_O);
                statement.setInt(3, sh_sany);
                statement.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    public static ArrayList<Olkolor> getOlko() {
        int id;
        String name;
        int kol;
        String zapros1 = "SELECT * FROM olko";
        ArrayList<Olkolor>olkolors=new ArrayList<>();
        try (Connection conn = connection();
             Statement stmt = conn.createStatement()){
             ResultSet rs = stmt.executeQuery(zapros1);
            while (rs.next()) {
                id=rs.getInt("id_o") ;
                name =rs.getString("name_o") ;
                kol= rs.getInt("sh_sany");
                Olkolor olk=new Olkolor(id,name,kol);
                olkolors.add(olk);
            }
            connection().close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
return  olkolors;
    }
    public  int getId() {
        return id;
    }

    public  String getName() {
        return name;
    }

    public  int getKol() {
        return kol;
    }
}
