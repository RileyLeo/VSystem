package vsystem;

public class Certificate {

    private String cpDose;
    private String cpLoc;
    private String cpDate;
    private String cpMonth;
    private String cpYear;
    private String cpVac;
    private People owner;   //OO 

    public Certificate(String cpDose, String cpLoc, String cpDate, String cpMonth, String cpYear, String cpVac, People owner) {
        this.cpDose = cpDose;
        this.cpLoc = cpLoc;
        this.cpDate = cpDate;
        this.cpMonth = cpMonth;
        this.cpYear = cpYear;
        this.cpVac = cpVac;
        this.owner = owner;
    }

    public String getCpDose() {
        return cpDose;
    }

    public void setCpDose(String cpDose) {
        this.cpDose = cpDose;
    }

    public String getCpLoc() {
        return cpLoc;
    }

    public void setCpLoc(String cpLoc) {
        this.cpLoc = cpLoc;
    }

    public String getCpDate() {
        return cpDate;
    }

    public void setCpDate(String cpDate) {
        this.cpDate = cpDate;
    }

    public String getCpMonth() {
        return cpMonth;
    }

    public void setCpMonth(String cpMonth) {
        this.cpMonth = cpMonth;
    }

    public String getCpYear() {
        return cpYear;
    }

    public void setCpYear(String cpYear) {
        this.cpYear = cpYear;
    }

    public String getCpVac() {
        return cpVac;
    }

    public void setCpVac(String cpVac) {
        this.cpVac = cpVac;
    }

    public People getOwner() {
        return owner;
    }

    public void setOwner(People owner) {
        this.owner = owner;
    }
    
    
}
