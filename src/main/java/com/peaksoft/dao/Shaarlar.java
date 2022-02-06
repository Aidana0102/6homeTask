package com.peaksoft.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class Shaarlar {
private final  static String url="jdbc:postgresql://localhost:5432/6task" ;
private final  static String user="postgres";
private final static String password ="1234";


private  int sh_id;
private   String sh_name;
private  String  sh_bashchy;
private int kalk_sany;

    public Shaarlar() {
    }

    public Shaarlar(int sh_id, String sh_name, String sh_bashchy, int kalk_sany) {
        this.sh_id = sh_id;
        this.sh_name = sh_name;
        this.sh_bashchy = sh_bashchy;
        this.kalk_sany = kalk_sany;
    }

    public  static Connection connection(){
       Connection connection=null;
       try{
           connection= DriverManager.getConnection(url,user,password);
           System.out.println("Connected succesfully");
   } catch (SQLException e) {
           System.out.println( e.getMessage());
       }
return connection;
}


public static void infAddShaarlar(int Id_sh,String Sh_NAme,String Sh_bashchy,int Kalk_sany){

        String Value="insert into shaar( id_sh,sh_name,sh_bashchy, kalk_sany) values (?,?,?,?)";
        try(Connection conn=connection();
            PreparedStatement statement=conn.prepareStatement(Value)){
            statement.setInt(1, (Id_sh));
            statement.setString(2,Sh_NAme);
            statement.setString(3,Sh_bashchy);
            statement.setInt(4,Kalk_sany);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Shaarlar> getShaar(){
     int sh_id;
     String sh_name;
     String sh_bashchy;
     int kalk_sany;

            String zapros1 = "SELECT * FROM shaar";
         ArrayList<Shaarlar>shaarlars=new ArrayList<>();


        try (Connection conn = connection();
                 Statement stmt = conn.createStatement()){
                 ResultSet rs = stmt.executeQuery(zapros1);
                while (rs.next()) {
                sh_id=  rs.getInt("id_sh") ;
               sh_name= rs.getString("sh_name") ;
                sh_bashchy=  rs.getString("sh_bashchy");
               kalk_sany=   rs.getInt("kalk_sany");
                Shaarlar shaarlar=new Shaarlar(sh_id,sh_name,sh_bashchy,kalk_sany);
                    shaarlars.add(shaarlar);
                }


            } catch (SQLException ex) {
                System.out.println(ex.getMessage()); }
    return shaarlars;
    }

    public  int getSh_id() {
        return sh_id;
    }

    public String getSh_name() {
        return sh_name;
    }

    public  String getSh_bashchy() {
        return sh_bashchy;
    }

    public  int getKalk_sany() {
        return kalk_sany;
    }
}




//
//public class DB {
//private final  static String url="jdbc:postgresql://localhost:5432/6task" ;
//private final  static String user="postgres";
//private final static String password ="1234";
//   public  static Connection connection(){
//       Connection connection=null;
//       try{
//           connection= DriverManager.getConnection(url,user,password);
//           System.out.println("Connected succesfully");
//   } catch (SQLException e) {
//           System.out.println( e.getMessage());
//       }
//return connection;
//}
//
//public static int getUsersCount(){
//       String zapros="select count(*) from user";
//       int count =0;
//       try{
//               Connection conn= connection();
//               Statement statement=conn.createStatement();
//               ResultSet resultSet=statement.executeQuery(zapros);{
//               resultSet.next();
//               count=resultSet.getInt(1);}
//
//       } catch (SQLException e) {
//           System.out.println(e.getMessage());
//       }
// return  count;
//}
//
//public static void AddUser(String name, int age){
//       String zapros2="Insert into user (name,age)Values(?,?)";
//       try {
//           Connection conn=connection();
//           PreparedStatement statement= conn.prepareStatement(zapros2);
//           statement.setString(1,name);
//           statement.setInt(2,age);
//           statement.executeUpdate();
//
//       } catch (SQLException ex) {
//           System.out.println( ex.getMessage());
//       }
//}
//
//
//
//}
//
//
//
//









