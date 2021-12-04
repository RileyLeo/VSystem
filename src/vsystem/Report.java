package vsystem;

import static java.lang.Math.floor;
import static java.lang.Math.round;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import javax.swing.DefaultComboBoxModel;

public class Report {

    private String report;
    public static ArrayList<Report> allRep = new ArrayList<Report>();

    public Report(String report) {
        this.report = report;
    }

    public static void readRep() {
        String rep1 = "All Registered People";
        String rep2 = "Citizen";
        String rep3 = "Non-Citizen";
//        String rep4 = "Report 4";
//        String rep5 = "Report 5";
        Report rept = new Report(rep1);
        allRep.add(rept);
        Report rept2 = new Report(rep2);
        allRep.add(rept2);
        Report rept3 = new Report(rep3);
        allRep.add(rept3);
//        Report rept4 = new Report(rep4);
//        allRep.add(rept4);
//        Report rept5 = new Report(rep5);
//        allRep.add(rept5);

        DefaultComboBoxModel rpx = new DefaultComboBoxModel();
        for (int i = 0; i < Report.allRep.size(); i++) {
            rpx.addElement(Report.allRep.get(i).getRep());
        }
        VSystem.rp1 = rpx;

    }

    public String getRep() {
        return report;
    }

    public static void AllPepRep() {
        LocalDate nd = LocalDate.now();
        double r1 = DataIO.allPep.size();                          //NUMBER OF REGISTERED PEOPLE
        int r1x = DataIO.allPep.size();
        int r2 = DataIO.allCerti.size();                        //NUMBER OF VACCINATED
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        double r7 = 0;
        int r11 = 0;
        int rm = 0;
        int rfm = 0;
        double totage = 0;
        for (People pp1 : DataIO.allPep) {
            if (pp1.getPGen().equals("Male")) {
                rm = rm + 1;
            } else if (pp1.getPGen().equals("Female")) {
                rfm = rfm + 1;
            }

        }
        for (Certificate c1 : DataIO.allCerti) {
            if (c1.getCpDose().equals("Dose 1")) {
                r3 = r3 + 1;                                    //VACCINATED DOSE 1
            } else if (c1.getCpDose().equals("Dose 2")) {
                r4 = r4 + 1;                                    //VACCINATED DOSE 2
            }
        }

        ArrayList<Integer> age1 = new ArrayList<Integer>();
        if (r1 != 0) {
            for (People p1 : DataIO.allPep) {
                String d1 = p1.getPDate();
                String d2 = p1.getPMonth();
                String d3 = p1.getPYear();
                int d1x = Integer.parseInt(d1);
                int d2x = Integer.parseInt(d2);
                int d3x = Integer.parseInt(d3);
                LocalDate bd = LocalDate.of(d3x, d2x, d1x);
                int age = Period.between(bd, nd).getYears();
                totage = totage + age;
                age1.add(age);
            }
            Collections.sort(age1);                                     //List of age
            r5 = Collections.max(age1);                            //MAX AGE                        
            r6 = Collections.min(age1);                             //MIN AGE
            r7 = totage / r1;                                         //MEAN AG   
        }

        for (Appointment app1 : DataIO.allApp) {
            if (app1.getaStat().equals(AppStat.Accepted) || app1.getaStat().equals(AppStat.Confirmed)) {
                r11 = r11 + 1;                                      //NUMBER OF ONGOING APPOINTMENT;
            }
        }
        int rc1 = 0;
        int rc2 = 0;
        int rc3 = 0;
        int rc4 = 0;
        int rc5 = 0;
        for (Certificate c2 : DataIO.allCerti) {
            if (c2.getCpLoc().equals("Centre 1")) {
                rc1 = rc1 + 1;
            } else if (c2.getCpLoc().equals("Centre 2")) {
                rc2 = rc2 + 1;
            } else if (c2.getCpLoc().equals("Centre 3")) {
                rc3 = rc3 + 1;
            } else if (c2.getCpLoc().equals("Centre 4")) {
                rc4 = rc4 + 1;
            } else {
                rc5 = rc5 + 1;
            }
        }
        ArrayList<Integer> cen = new ArrayList<Integer>();
        cen.add(rc1);
        cen.add(rc2);
        cen.add(rc3);
        cen.add(rc4);
        cen.add(rc5);
        ArrayList<String> vacu = new ArrayList<String>();
        for (Certificate c3 : DataIO.allCerti) {
            String cxx = c3.getCpVac();
            vacu.add(cxx);
        }
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(vacu);
        ArrayList<String> vacu1 = new ArrayList<>(hashSet);                 //LIST OF USED VACCINE CODE

        ComF5Page.ViewReportArea.append(
                "Total of Registered People\t: " + r1x + "\n\nTotal of Male People\t: " + rm + "\n\nTotal of Female People\t: " + rfm + "\n\nTotal of Vaccinated People\t: " + r2
                + "\n\nTotal of Vaccinated Dose 1\t: " + r3 + "\n\nTotal of Vaccinated Dose 2\t: " + r4 + "\n\nList of Registered People Age :\n" + age1
                + "\n\nMax Age\t: " + r5 + "\nMin Age\t: " + r6 + "\nMean\t: " + r7
                + "\n\nNumber of Ongoing Appointment : " + r11 + "\n\nVisited Centre : \n\tCentre 1 : " + rc1 + "\n\tCentre 2 : " + rc2 + "\n\tCentre 3 : "
                + rc3 + "\n\tCentre 4 : " + rc4 + "\n\tCentre 5 : " + rc5 + "\n\nList of Used Vaccine Code : \n" + vacu1);
    }

    public static void CitRep() {
        LocalDate nd = LocalDate.now();
        ArrayList<People> cit = new ArrayList<People>();
        for (People pep1 : DataIO.allPep) {
            if (pep1.getPType().equals("Citizen")) {
                String d0 = pep1.getPType();
                String d1 = pep1.getPUser();
                String d2 = pep1.getPPass();
                String d3 = pep1.getPName1();
                String d4 = pep1.getPName2();
                String d5 = pep1.getPGen();
                String d6 = pep1.getPMail();
                String d7 = pep1.getPPhone();
                String d8 = pep1.getPDate();
                String d9 = pep1.getPMonth();
                String d10 = pep1.getPYear();
                String d11 = pep1.getPAdd();
                String d12 = pep1.getPNot();
                String d13 = pep1.getPRes();
                String d13x = pep1.getPVac();
                People dx = new People(d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d13x);
                cit.add(dx);
            }
        }

        double r1 = cit.size();                          //NUMBER OF REGISTERED PEOPLE
        int r1x = cit.size();
        int r2 = 0;                                         //NUMBER OF VACCINATED
        for (People pp2 : cit) {
            if (!pp2.getPVac().equals("0")) {
                r2 = r2 + 1;
            }
        }
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        double r7 = 0;
        int r11 = 0;
        int rm = 0;
        int rfm = 0;
        double totage = 0;
        for (People pp1 : cit) {
            if (pp1.getPGen().equals("Male")) {
                rm = rm + 1;
            } else if (pp1.getPGen().equals("Female")) {
                rfm = rfm + 1;
            }

        }

        for (People pp3 : cit) {
            if (pp3.getPVac().equals("1")) {
                r3 = r3 + 1;                            //VACCINATED DOSE 1
            } else if (pp3.getPVac().equals("2")) {
                r3 = r3 + 1;                            //VACCINATED DOSE 2
                r4 = r4 + 1;
            }
        }

        ArrayList<Integer> age1 = new ArrayList<Integer>();
        if (r1 != 0) {
            for (People p1 : cit) {
                String d1 = p1.getPDate();
                String d2 = p1.getPMonth();
                String d3 = p1.getPYear();
                int d1x = Integer.parseInt(d1);
                int d2x = Integer.parseInt(d2);
                int d3x = Integer.parseInt(d3);
                LocalDate bd = LocalDate.of(d3x, d2x, d1x);
                int age = Period.between(bd, nd).getYears();
                totage = totage + age;
                age1.add(age);
            }
            Collections.sort(age1);                                     //List of age
            r5 = Collections.max(age1);                            //MAX AGE                        
            r6 = Collections.min(age1);                             //MIN AGE
            r7 = totage / r1;                                         //MEAN AGE
        }
        
        for (Appointment app1 : DataIO.allApp) {
            if (app1.getaStat().equals(AppStat.Accepted) || app1.getaStat().equals(AppStat.Confirmed)) {
                r11 = r11 + 1;                                      //NUMBER OF ONGOING APPOINTMENT;
            }
        }
        int rc1 = 0;
        int rc2 = 0;
        int rc3 = 0;
        int rc4 = 0;
        int rc5 = 0;

        //here change
        for (Certificate c2 : DataIO.allCerti) {
            if (c2.getOwner().getPType().equals("Citizen")) {
                if (c2.getCpLoc().equals("Centre 1")) {
                    rc1 = rc1 + 1;
                } else if (c2.getCpLoc().equals("Centre 2")) {
                    rc2 = rc2 + 1;
                } else if (c2.getCpLoc().equals("Centre 3")) {
                    rc3 = rc3 + 1;
                } else if (c2.getCpLoc().equals("Centre 4")) {
                    rc4 = rc4 + 1;
                } else {
                    rc5 = rc5 + 1;
                }
            }
        }
        ArrayList<Integer> cen = new ArrayList<Integer>();
        cen.add(rc1);
        cen.add(rc2);
        cen.add(rc3);
        cen.add(rc4);
        cen.add(rc5);

        ArrayList<String> vacu = new ArrayList<String>();
        for (Certificate c3 : DataIO.allCerti) {
            if (c3.getOwner().getPType().equals("Citizen")) {
                String cxx = c3.getCpVac();
                vacu.add(cxx);
            }
        }
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(vacu);
        ArrayList<String> vacu1 = new ArrayList<>(hashSet);                 //LIST OF USED VACCINE CODE

        ComF5Page.ViewReportArea.append(
                "Total of Registered People\t: " + r1x + "\n\nTotal of Male People\t: " + rm + "\n\nTotal of Female People\t: " + rfm + "\n\nTotal of Vaccinated People\t: " + r2
                + "\n\nTotal of Vaccinated Dose 1\t: " + r3 + "\n\nTotal of Vaccinated Dose 2\t: " + r4 + "\n\nList of Registered People Age :\n" + age1
                + "\n\nMax Age\t: " + r5 + "\nMin Age\t: " + r6 + "\nMean\t: " + r7
                + "\n\nNumber of Ongoing Appointment : " + r11 + "\n\nVisited Centre : \n\tCentre 1 : " + rc1 + "\n\tCentre 2 : " + rc2 + "\n\tCentre 3 : "
                + rc3 + "\n\tCentre 4 : " + rc4 + "\n\tCentre 5 : " + rc5 + "\n\nList of Used Vaccine Code : \n" + vacu1);
    }
    
     public static void NonCitRep() {
        LocalDate nd = LocalDate.now();
        ArrayList<People> ncit = new ArrayList<People>();
        for (People pep1 : DataIO.allPep) {
            if (!pep1.getPType().equals("Citizen")) {
                String d0 = pep1.getPType();
                String d1 = pep1.getPUser();
                String d2 = pep1.getPPass();
                String d3 = pep1.getPName1();
                String d4 = pep1.getPName2();
                String d5 = pep1.getPGen();
                String d6 = pep1.getPMail();
                String d7 = pep1.getPPhone();
                String d8 = pep1.getPDate();
                String d9 = pep1.getPMonth();
                String d10 = pep1.getPYear();
                String d11 = pep1.getPAdd();
                String d12 = pep1.getPNot();
                String d13 = pep1.getPRes();
                String d13x = pep1.getPVac();
                People dx = new People(d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d13x);
                ncit.add(dx);
            }
        }

        double r1 = ncit.size();                          //NUMBER OF REGISTERED PEOPLE
        int r1x = ncit.size();
        int r2 = 0;                                         //NUMBER OF VACCINATED
        for (People pp2 : ncit) {
            if (!pp2.getPVac().equals("0")) {
                r2 = r2 + 1;
            }
        }
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        double r7 = 0;
        int r11 = 0;
        int rm = 0;
        int rfm = 0;
        double totage = 0;
        for (People pp1 : ncit) {
            if (pp1.getPGen().equals("Male")) {
                rm = rm + 1;
            } else if (pp1.getPGen().equals("Female")) {
                rfm = rfm + 1;
            }

        }

        for (People pp3 : ncit) {
            if (pp3.getPVac().equals("1")) {
                r3 = r3 + 1;                            //VACCINATED DOSE 1
            } else if (pp3.getPVac().equals("2")) {
                r3 = r3 + 1;                            //VACCINATED DOSE 2
                r4 = r4 + 1;
            }
        }

        ArrayList<Integer> age1 = new ArrayList<Integer>();
        if (r1 != 0) {
            for (People p1 : ncit) {
                String d1 = p1.getPDate();
                String d2 = p1.getPMonth();
                String d3 = p1.getPYear();
                int d1x = Integer.parseInt(d1);
                int d2x = Integer.parseInt(d2);
                int d3x = Integer.parseInt(d3);
                LocalDate bd = LocalDate.of(d3x, d2x, d1x);
                int age = Period.between(bd, nd).getYears();
                totage = totage + age;
                age1.add(age);
            }
            Collections.sort(age1);                                     //List of age
            r5 = Collections.max(age1);                            //MAX AGE                        
            r6 = Collections.min(age1);                             //MIN AGE
            r7 = totage / r1;                                         //MEAN AGE
        }
        
        for (Appointment app1 : DataIO.allApp) {
            if (app1.getaStat().equals(AppStat.Accepted) || app1.getaStat().equals(AppStat.Confirmed)) {
                r11 = r11 + 1;                                      //NUMBER OF ONGOING APPOINTMENT;
            }
        }
        int rc1 = 0;
        int rc2 = 0;
        int rc3 = 0;
        int rc4 = 0;
        int rc5 = 0;

        //here change
        for (Certificate c2 : DataIO.allCerti) {
            if (c2.getOwner().getPType().equals("Non-Citizen")) {
                if (c2.getCpLoc().equals("Centre 1")) {
                    rc1 = rc1 + 1;
                } else if (c2.getCpLoc().equals("Centre 2")) {
                    rc2 = rc2 + 1;
                } else if (c2.getCpLoc().equals("Centre 3")) {
                    rc3 = rc3 + 1;
                } else if (c2.getCpLoc().equals("Centre 4")) {
                    rc4 = rc4 + 1;
                } else {
                    rc5 = rc5 + 1;
                }
            }
        }
        ArrayList<Integer> cen = new ArrayList<Integer>();
        cen.add(rc1);
        cen.add(rc2);
        cen.add(rc3);
        cen.add(rc4);
        cen.add(rc5);

        ArrayList<String> vacu = new ArrayList<String>();
        for (Certificate c3 : DataIO.allCerti) {
            if (c3.getOwner().getPType().equals("Non-Citizen")) {
                String cxx = c3.getCpVac();
                vacu.add(cxx);
            }
        }
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(vacu);
        ArrayList<String> vacu1 = new ArrayList<>(hashSet);                 //LIST OF USED VACCINE CODE

        ComF5Page.ViewReportArea.append(
                "Total of Registered People\t: " + r1x + "\n\nTotal of Male People\t: " + rm + "\n\nTotal of Female People\t: " + rfm + "\n\nTotal of Vaccinated People\t: " + r2
                + "\n\nTotal of Vaccinated Dose 1\t: " + r3 + "\n\nTotal of Vaccinated Dose 2\t: " + r4 + "\n\nList of Registered People Age :\n" + age1
                + "\n\nMax Age\t: " + r5 + "\nMin Age\t: " + r6 + "\nMean\t: " + r7
                + "\n\nNumber of Ongoing Appointment : " + r11 + "\n\nVisited Centre : \n\tCentre 1 : " + rc1 + "\n\tCentre 2 : " + rc2 + "\n\tCentre 3 : "
                + rc3 + "\n\tCentre 4 : " + rc4 + "\n\tCentre 5 : " + rc5 + "\n\nList of Used Vaccine Code : \n" + vacu1);
    }
}
