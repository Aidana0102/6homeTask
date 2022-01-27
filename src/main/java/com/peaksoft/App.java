package com.peaksoft;

import com.peaksoft.dao.Olkolor;
import com.peaksoft.dao.Shaarlar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import static com.peaksoft.dao.Olkolor.connection;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Shaarlar dataBase = new Shaarlar();
        dataBase.connection();

        Shaarlar.infAbtShaarlar(1, "Bishkek", "Akimov", 121000);

        Shaarlar.infAbtShaarlar(2, "TAsh-Komur", "Akim", 111000);
        Shaarlar.infAbtShaarlar(3, "Leilek", "Aidar", 12170);
        Shaarlar.infAbtShaarlar(4, "TAlas", "Aliev", 33330);
        Shaarlar.infAbtShaarlar(5, "J_Abad", "BAkYt", 121000);

        Shaarlar.getShaar();


        Olkolor dataBase2 = new Olkolor();
        connection();
        Olkolor.addInfAboutOlko(1, "WowoW", 12);
        Olkolor.addInfAboutOlko(2, "rerer", 15);
        Olkolor.addInfAboutOlko(3, "WHT", 10);
        Olkolor.addInfAboutOlko(4, "KkKK", 5);
        Olkolor.addInfAboutOlko(5, "OPopo", 12);
        Olkolor.addInfAboutOlko(6, "JIJIL", 15);

     Olkolor.getOlko();
        String zapros1 = "SELECT * FROM olko";
        try (Connection conn = connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(zapros1)) {
            while (rs.next()) {
                int id=rs.getInt("id") ;
                String name =rs.getString("name ") ;
                String kol= rs.getString("Kancha_shaar_bar");
                System.out.println(id+"  "+name+"   "+kol);
            }

            connection().close();


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }


        ShBashchylar dataBase3 = new ShBashchylar();
        dataBase3.connection();

        ShBashchylar.addBashchy(6,"Hanna");
        ShBashchylar.addBashchy(2,"Asema");
        ShBashchylar.addBashchy(3,"Khan");
        ShBashchylar.addBashchy(4,"Honor");
        ShBashchylar.addBashchy(5,"Lili");


        ShBashchylar.getBashchy();


        ArrayList<Shaarlar> shaarlars=new ArrayList<>();
               ArrayList<Olkolor>olkolors=new ArrayList<>();


        System.out.println(" Базада   "+ olkolors.size()+ "  olko  bar ,канчанчы olkonu tandaisyz ?");
        Scanner scanner = new Scanner(System.in);
        int enteredID = scanner.nextInt();

        System.out.println(olkolors.get(enteredID).getId() + "    " + olkolors.get(enteredID).getName() + "    " + olkolors.get(enteredID).getKol());

        System.out.println(" Базада   "+ olkolors.size()+ " shaar bar ,канчанчы shaardy tandaisyz ?");

        int enteredID2 = scanner.nextInt();

        System.out.println(shaarlars.get(enteredID2).getSh_id() + "    " + shaarlars.get(enteredID2).getSh_name() + "    " + shaarlars.get(enteredID2).getSh_bashchy()+shaarlars.get(enteredID2).getKalk_sany());


}}