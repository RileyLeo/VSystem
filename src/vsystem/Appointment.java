package vsystem;

import java.util.ArrayList;
import java.util.Collections;

public class Appointment {

    private String aId;
    private String aUser;
    private String aName;
    private String aDate;
    private String aMonth;
    private String aYear;
    private String aLoc;
    private String aDos;
    private AppStat aStat;

    public Appointment(String aId, String aUser, String aName, String aDate, String aMonth, String aYear, String aLoc, String aDos, AppStat aStat) {
        this.aId = aId;
        this.aUser = aUser;
        this.aName = aName;
        this.aDate = aDate;
        this.aMonth = aMonth;
        this.aYear = aYear;
        this.aLoc = aLoc;
        this.aDos = aDos;
        this.aStat = aStat;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getaUser() {
        return aUser;
    }

    public void setaUser(String aUser) {
        this.aUser = aUser;
    }

    public String getaDate() {
        return aDate;
    }

    public void setaDate(String aDate) {
        this.aDate = aDate;
    }

    public String getaMonth() {
        return aMonth;
    }

    public void setaMonth(String aMonth) {
        this.aMonth = aMonth;
    }

    public String getaYear() {
        return aYear;
    }

    public void setaYear(String aYear) {
        this.aYear = aYear;
    }

    public String getaLoc() {
        return aLoc;
    }

    public void setaLoc(String aLoc) {
        this.aLoc = aLoc;
    }

    public AppStat getaStat() {
        return aStat;
    }

    public void setaStat(AppStat aStat) {
        this.aStat = aStat;
    }

    public String getaDos() {
        return aDos;
    }

    public void setaDos(String aDos) {
        this.aDos = aDos;
    }

    public static void appAuto() {
        for (int i = 0; i < DataIO.allApp.size(); i++) {
            AppStat app1 = DataIO.allApp.get(i).getaStat();
            String app2  = DataIO.allApp.get(i).getaDate();
            String app3  = DataIO.allApp.get(i).getaMonth();
            String app4  = DataIO.allApp.get(i).getaYear();
            if(app1.equals(AppStat.Accepted)){
                String apd = app2+"/"+app3+"/"+app4;
                DateChecker xx = new DateChecker();
                boolean xx2 = xx.CheckDate1(apd);
                if(xx2 == true){
                    DataIO.allApp.get(i).setaStat(AppStat.Rejected);
                }
            }

        }
        DataIO.write();

    }
    
        public static void sortApp() {
        ArrayList<String> allAppSort = new ArrayList<String>();
        ArrayList<Appointment> allAppSorted = new ArrayList<Appointment>();
        for (Appointment ap1 : DataIO.allApp) {
            String s1 = ap1.getaId();
            allAppSort.add(s1);
        }
        Collections.sort(allAppSort);
        for (int i = 0; i < allAppSort.size(); i++) {
            String s2 = allAppSort.get(i);
            for (Appointment appx : DataIO.allApp) {
                if (appx.getaId().equals(s2)) {
                    String app0 = appx.getaId();
                    String app1 = appx.getaUser();
                    String app2 = appx.getaName();
                    String app3 = appx.getaDate();
                    String app4 = appx.getaMonth();
                    String app5 = appx.getaYear();
                    String app6 = appx.getaLoc();
                    String app7 = appx.getaDos();
                    AppStat app8 = appx.getaStat();                   
                    Appointment appx2= new Appointment(app0,app1,app2,app3,app4,app5,app6,app7,app8);
                    allAppSorted.add(appx2);
                }
            }
        }
        DataIO.allApp = allAppSorted;
    }

}
