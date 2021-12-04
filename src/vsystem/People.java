package vsystem;

import java.util.ArrayList;

public class People extends User {

    private String PType;
    private String PUser;
    private String PGen;
    private String PDate;
    private String PMonth;
    private String PYear;
    private String PAdd;
    private String PNot;
    private String PRes;
    private String PVac;
    private ArrayList<Certificate> myCerti = new ArrayList<Certificate>();

    public People(String PType, String PUser, String password, String firstName, String lastName, String PGen,String eMail, String phoneNo,  String PDate, String PMonth, String PYear, String PAdd, String PNot, String PRes, String PVac) {
        super(password, firstName, lastName, eMail, phoneNo);
        this.PType = PType;
        this.PUser = PUser;
        this.PGen = PGen;
        this.PDate = PDate;
        this.PMonth = PMonth;
        this.PYear = PYear;
        this.PAdd = PAdd;
        this.PNot = PNot;
        this.PRes = PRes;
        this.PVac = PVac;
    }

    public String getPType() {
        return PType;
    }

    public void setPType(String PType) {
        this.PType = PType;
    }

    public String getPUser() {
        return PUser;
    }

    public void setPUser(String PUser) {
        this.PUser = PUser;
    }

    public String getPPass() {
        return password;
    }

    public void setPPass(String PPass) {
        this.password = PPass;
    }

    public String getPName1() {
        return firstName;
    }

    public void setPName1(String PName1) {
        this.firstName = PName1;
    }

    public String getPName2() {
        return lastName;
    }

    public void setPName2(String PName2) {
        this.lastName = PName2;
    }

    public String getPGen() {
        return PGen;
    }

    public void setPGen(String PGen) {
        this.PGen = PGen;
    }

    public String getPMail() {
        return eMail;
    }

    public void setPMail(String PMail) {
        this.eMail = PMail;
    }

    public String getPPhone() {
        return phoneNo;
    }

    public void setPPhone(String PPhone) {
        this.phoneNo = PPhone;
    }

    public String getPDate() {
        return PDate;
    }

    public void setPDate(String PDate) {
        this.PDate = PDate;
    }

    public String getPMonth() {
        return PMonth;
    }

    public void setPMonth(String PMonth) {
        this.PMonth = PMonth;
    }

    public String getPYear() {
        return PYear;
    }

    public void setPYear(String PYear) {
        this.PYear = PYear;
    }

    public String getPAdd() {
        return PAdd;
    }

    public void setPAdd(String PAdd) {
        this.PAdd = PAdd;
    }

    public String getPNot() {
        return PNot;
    }

    public void setPNot(String PNot) {
        this.PNot = PNot;
    }

    public String getPRes() {
        return PRes;
    }

    public void setPRes(String PRes) {
        this.PRes = PRes;
    }

    public String getPVac() {
        return PVac;
    }

    public void setPVac(String PVac) {
        this.PVac = PVac;
    }

    public ArrayList<Certificate> getmyCerti() {
        return myCerti;
    }

    public void setmyCerti(ArrayList<Certificate> myCerti) {
        this.myCerti = myCerti;
    }

    public static void PepChange() {
        for (People px : DataIO.allPep) {
            String po = px.getPUser();
            String p1 = px.getPName1() + " " + px.getPName2();
            for (Appointment apx : DataIO.allApp) {
                if (apx.getaUser().equals(po)) {
                    apx.setaName(p1);
                }
            }
        }
    }

}
