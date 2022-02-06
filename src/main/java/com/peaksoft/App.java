package com.peaksoft;

import com.peaksoft.dao.Olkolor;
import com.peaksoft.dao.ShBashchylar;
import com.peaksoft.dao.Shaarlar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
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

        Shaarlar.infAddShaarlar(1, "Bishkek", "Akimov", 121000);

        Shaarlar.infAddShaarlar(2, "TAsh-Komur", "Akim", 111000);
        Shaarlar.infAddShaarlar(3, "Leilek", "Aidar", 12170);
        Shaarlar.infAddShaarlar(4, "TAlas", "Aliev", 33330);
        Shaarlar.infAddShaarlar(5, "J_Abad", "BAkYt", 121000);

        Shaarlar.getShaar();


//        Olkolor dataBase2 = new Olkolor();
//        connection();
//        Olkolor.addInfAboutOlko(1, "WowoW", 12);
//        Olkolor.addInfAboutOlko(2, "rerer", 15);
//        Olkolor.addInfAboutOlko(3, "WHT", 10);
//        Olkolor.addInfAboutOlko(4, "KkKK", 5);
//        Olkolor.addInfAboutOlko(5, "OPopo", 12);
//        Olkolor.addInfAboutOlko(6, "JIJIL", 15);

        ShBashchylar dataBase3 = new ShBashchylar();
        dataBase3.connection();

        ShBashchylar.addBashchy(6, "Hanna");
        ShBashchylar.addBashchy(2, "Asema");
        ShBashchylar.addBashchy(3, "Khan");
        ShBashchylar.addBashchy(4, "Honor");
        ShBashchylar.addBashchy(5, "Lili");


        ShBashchylar.getBashchy();


        List<Shaarlar> shaarlars = Shaarlar.getShaar();
        List<Olkolor> olkolors = Olkolor.getOlko();
        List<ShBashchylar> bashchylars = ShBashchylar.getBashchy();


        System.out.println(" Базада   " + olkolors.size() + "  olko  bar ,канчанчы olkonu tandaisyz ?");
        Scanner scanner = new Scanner(System.in);
        int enteredID = scanner.nextInt();

        System.out.println(olkolors.get(enteredID - 1).getId() + "mmm" + "    " + olkolors.get(enteredID - 1).getName() + "    " + olkolors.get(enteredID - 1).getKol());

        System.out.println(" Базада   " + shaarlars.size() + " shaar bar ,канчанчы shaardy tandaisyz ?");

        int enteredID2 = scanner.nextInt();


        System.out.println(shaarlars.get(enteredID2 - 1).getSh_id() + "    " + shaarlars.get(enteredID2 - 1).getSh_name() + "    " + shaarlars.get(enteredID2 - 1).getSh_bashchy() + shaarlars.get(enteredID2 - 1).getKalk_sany());

        System.out.println(" Базада   " + bashchylars.size() + " shaar bashchy bar ,канчанчы shaardy tandaisyz ?");

        int enteredID3 = scanner.nextInt();

        System.out.println(bashchylars.get(enteredID3 - 1).getId() + "    " + bashchylars.get(enteredID3 - 1).getName());
    }}