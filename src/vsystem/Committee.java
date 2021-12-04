package vsystem;

public class Committee extends User {

    private String ComUser;

    public Committee(String ComUser, String password, String firstName, String lastName, String eMail, String phoneNo) {
        super(password, firstName, lastName, eMail, phoneNo);
        this.ComUser = ComUser;
    }

    public String getComUser() {
        return ComUser;
    }

    public void setComUser(String ComUser) {
        this.ComUser = ComUser;
    }

    public String getComPass() {
        return password;
    }

    public void setComPass(String ComPass) {
        this.password = ComPass;
    }

    public String getComName1() {
        return firstName;
    }

    public void setComName1(String ComName1) {
        this.firstName = ComName1;
    }

    public String getComName2() {
        return lastName;
    }

    public void setComName2(String ComName2) {
        this.lastName = ComName2;
    }

    public String getComMail() {
        return eMail;
    }

    public void setComMail(String ComMail) {
        this.eMail = ComMail;
    }

    public String getComPhone() {
        return phoneNo;
    }

    public void setComPhone(String ComPhone) {
        this.phoneNo = ComPhone;
    }
}
