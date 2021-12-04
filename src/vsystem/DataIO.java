package vsystem;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataIO {

    public static ArrayList<Committee> allCom = new ArrayList<Committee>();
    public static ArrayList<People> allPep = new ArrayList<People>();
    public static ArrayList<Vaccine> allVac = new ArrayList<Vaccine>();
    public static ArrayList<Appointment> allApp = new ArrayList<Appointment>();
    public static ArrayList<Certificate> allCerti = new ArrayList<Certificate>();

//    public static ArrayList<Appointment> appInSession = new ArrayList<Appointment>(); // might not need it anymore
    public static void read() {
        try {
            Scanner r1 = new Scanner(new File("Committee.txt"));
            while (r1.hasNext()) {
                String c1 = r1.nextLine();
                String c2 = r1.nextLine();
                String c3 = r1.nextLine();
                String c4 = r1.nextLine();
                String c5 = r1.nextLine();
                String c6 = r1.nextLine();
                r1.nextLine();
                Committee ct = new Committee(c1, c2, c3, c4, c5, c6);
                allCom.add(ct);
            }
            Scanner r2 = new Scanner(new File("People.txt"));
            while (r2.hasNext()) {
                String p1 = r2.nextLine();
                String p2 = r2.nextLine();
                String p3 = r2.nextLine();
                String p4 = r2.nextLine();
                String p5 = r2.nextLine();
                String p6 = r2.nextLine();
                String p7 = r2.nextLine();
                String p8 = r2.nextLine();
                String p9 = r2.nextLine();
                String p10 = r2.nextLine();
                String p11 = r2.nextLine();
                String p12 = r2.nextLine();
                String p13 = r2.nextLine();
                String p14 = r2.nextLine();
                String p15 = r2.nextLine();
                r2.nextLine();
                People pt = new People(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15);
                allPep.add(pt);
            }
            Scanner r3 = new Scanner(new File("Vaccine.txt"));
            while (r3.hasNext()) {
                String v1 = r3.nextLine();
                String v2 = r3.nextLine();
                double v3 = Double.parseDouble(r3.nextLine());
                double v4 = Double.parseDouble(r3.nextLine());
                double v5 = Double.parseDouble(r3.nextLine());
                double v6 = Double.parseDouble(r3.nextLine());
                double v7 = Double.parseDouble(r3.nextLine());
                r3.nextLine();
                Vaccine vt = new Vaccine(v1, v2, v3, v4, v5, v6, v7);
                allVac.add(vt);
            }

            Scanner r4 = new Scanner(new File("Appointment.txt"));
            while (r4.hasNext()) {
                String a1 = r4.nextLine();
                String a2 = r4.nextLine();
                String a3 = r4.nextLine();
                String a4 = r4.nextLine();
                String a5 = r4.nextLine();
                String a6 = r4.nextLine();
                String a7 = r4.nextLine();
                String a8 = r4.nextLine();
                AppStat a9 = AppStat.valueOf(r4.nextLine());
                r4.nextLine();
                Appointment at = new Appointment(a1, a2, a3, a4, a5, a6, a7, a8, a9);
                allApp.add(at);
            }

            Scanner r5 = new Scanner(new File("Certificate.txt"));
            while (r5.hasNext()) {
                String cp1 = r5.nextLine();
                String cp2 = r5.nextLine();
                String cp3 = r5.nextLine();
                String cp4 = r5.nextLine();
                String cp5 = r5.nextLine();
                String cp6 = r5.nextLine();
                People cp7 = DataIO.checking1(r5.nextLine());
                r5.nextLine();
                Certificate cpt = new Certificate(cp1, cp2, cp3, cp4, cp5, cp6, cp7);
                allCerti.add(cpt);
                cp7.getmyCerti().add(cpt);
            }

        } catch (Exception e) {
            System.out.println("Error in read!");
        }
    }

    public static void write() {
        try {
            PrintWriter w1 = new PrintWriter("Committee.txt");
            for (int i = 0; i < allCom.size(); i++) {
                w1.println(allCom.get(i).getComUser());
                w1.println(allCom.get(i).getComPass());
                w1.println(allCom.get(i).getComName1());
                w1.println(allCom.get(i).getComName2());
                w1.println(allCom.get(i).getComMail());
                w1.println(allCom.get(i).getComPhone());
                w1.println();
            }
            w1.close();

            PrintWriter w2 = new PrintWriter("People.txt");
            for (int i = 0; i < allPep.size(); i++) {
                w2.println(allPep.get(i).getPType());
                w2.println(allPep.get(i).getPUser());
                w2.println(allPep.get(i).getPPass());
                w2.println(allPep.get(i).getPName1());
                w2.println(allPep.get(i).getPName2());
                w2.println(allPep.get(i).getPGen());
                w2.println(allPep.get(i).getPMail());
                w2.println(allPep.get(i).getPPhone());
                w2.println(allPep.get(i).getPDate());
                w2.println(allPep.get(i).getPMonth());
                w2.println(allPep.get(i).getPYear());
                w2.println(allPep.get(i).getPAdd());
                w2.println(allPep.get(i).getPNot());
                w2.println(allPep.get(i).getPRes());
                w2.println(allPep.get(i).getPVac());
                w2.println();
            }
            w2.close();

            PrintWriter w3 = new PrintWriter("Vaccine.txt");
            for (int i = 0; i < allVac.size(); i++) {
                w3.println(allVac.get(i).getvCode());
                w3.println(allVac.get(i).getvName());
                w3.println(allVac.get(i).getcen1Qty());
                w3.println(allVac.get(i).getcen2Qty());
                w3.println(allVac.get(i).getcen3Qty());
                w3.println(allVac.get(i).getcen4Qty());
                w3.println(allVac.get(i).getcen5Qty());
                w3.println();
            }
            w3.close();

            Appointment.sortApp();
            PrintWriter w4 = new PrintWriter("Appointment.txt");
            for (int i = 0; i < allApp.size(); i++) {
                w4.println(allApp.get(i).getaId());
                w4.println(allApp.get(i).getaUser());
                w4.println(allApp.get(i).getaName());
                w4.println(allApp.get(i).getaDate());
                w4.println(allApp.get(i).getaMonth());
                w4.println(allApp.get(i).getaYear());
                w4.println(allApp.get(i).getaLoc());
                w4.println(allApp.get(i).getaDos());
                w4.println(allApp.get(i).getaStat());
                w4.println();
            }
            w4.close();

            PrintWriter w5 = new PrintWriter("Certificate.txt");
            for (int i = 0; i < allCerti.size(); i++) {
                Certificate j = allCerti.get(i);
                w5.println(j.getCpDose());
                w5.println(j.getCpLoc());
                w5.println(j.getCpDate());
                w5.println(j.getCpMonth());
                w5.println(j.getCpYear());
                w5.println(j.getCpVac());
                w5.println(j.getOwner().getPUser());
                w5.println();
            }
            w5.close();

        } catch (Exception e) {
            System.out.println("Error in write!");
        }
    }

    public static Committee checking(String x) {
        for (Committee y : allCom) {
            if (x.equals(y.getComUser())) {
                return y;
            }
        }
        return null;
    }

    public static People checking1(String x1) {
        for (People y1 : allPep) {
            if (x1.equals(y1.getPUser())) {
                return y1;
            }
        }
        return null;
    }

    public static Vaccine checking2(String x2) {
        for (Vaccine y2 : allVac) {
            if (x2.equals(y2.getvCode())) {
                return y2;
            }
        }
        return null;
    }

    // might need more than this to check appointment
    public static Appointment checking3(String x3) {
        for (Appointment y3 : allApp) {
            if (x3.equals(y3.getaUser())) {
                return y3;
            }
        }
        return null;
    }

    public static Appointment checking4(String x4) {
        for (Appointment y4 : allApp) {
            if (x4.equals(y4.getaUser()) && y4.getaStat() != AppStat.Rejected && y4.getaStat() != AppStat.Completed) {
                return y4;
            }
        }
        return null;
    }

    public static Appointment checking5(String x5) {
        for (Appointment y5 : allApp) {
            if (x5.equals(y5.getaId())) {
                return y5;
            }
        }
        return null;
    }

    // check confirmed 1st dose
    public static Appointment checking6(String x6) {
        for (Appointment y6 : allApp) {
            if (x6.equals(y6.getaId()) && y6.getaStat() == AppStat.Confirmed && y6.getaDos().equals("Dose 1")) {
                return y6;
            }
        }
        return null;
    }

    // check confirmed 2nd dose
    public static Appointment checking7(String x7) {
        for (Appointment y7 : allApp) {
            if (x7.equals(y7.getaId()) && y7.getaStat() == AppStat.Confirmed && y7.getaDos().equals("Dose 2")) {
                return y7;
            }
        }
        return null;
    }
    
    // email validation
    public static boolean checking8(String email) {

        String emailRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(email);
        Boolean success = true;

        if (!emailMatcher.find()) {

            success = false;
        }

        return success;

    }
}
