package com.peaksoft.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class Shaarlar {
private final  static String url="jdbc:postgresql://localhost:5432/6task" ;
private final  static String user="postgres";
private final static String password ="1234";


private static int sh_id;
private  static String sh_name;
private static String  sh_bashchy;
private static int kalk_sany;

    public Shaarlar() {
    }

    public Shaarlar(int sh_id, String sh_name,String sh_bashchy,int kalk_sany) {

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


public static void infAbtShaarlar(int Id_sh,String Sh_NAme,String Sh_bashchy,int Kalk_sany){

        String Value="insert into shaar( Id_sh,Sh_NAme,Sh_bashchy, Kalk_sany) values (?,?,?,?)";
        try(Connection conn=connection();
            PreparedStatement statement=conn.prepareStatement(Value)){
            statement.setString(1, String.valueOf(Id_sh));
            statement.setString(2,Sh_NAme);
            statement.setString(3,Sh_bashchy);
            statement.setInt(4,Kalk_sany);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Shaarlar> getShaar(){

            String zapros1 = "SELECT * FROM shaar";
        ArrayList<Shaarlar>shaarlars=new ArrayList<>();


        try (Connection conn = connection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(zapros1)) {
                while (rs.next()) {
                sh_id=  rs.getInt("Id_Sh") ;
               sh_name= rs.getString("Sh_NAme") ;
                sh_bashchy=  rs.getString("Sh_bashchy");
               kalk_sany=   rs.getInt("KAlk_sany");
                Shaarlar shaarlar=new Shaarlar(sh_id,sh_name,sh_bashchy,kalk_sany);
                    shaarlars.add(shaarlar);
                }


            } catch (SQLException ex) {
                System.out.println(ex.getMessage()); }
    return shaarlars;
    }

    public static int getSh_id() {
        return sh_id;
    }

    public static String getSh_name() {
        return sh_name;
    }

    public static String getSh_bashchy() {
        return sh_bashchy;
    }

    public static int getKalk_sany() {
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









