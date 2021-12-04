package vsystem;

public class Vaccine {

    private String vCode;
    private String vName;
    private double cen1Qty;
    private double cen2Qty;
    private double cen3Qty;
    private double cen4Qty;
    private double cen5Qty;

    public Vaccine(String vCode, String vName, double cen1Qty, double cen2Qty, double cen3Qty, double cen4Qty, double cen5Qty) {
        this.vCode = vCode;
        this.vName = vName;
        this.cen1Qty = cen1Qty;
        this.cen2Qty = cen2Qty;
        this.cen3Qty = cen3Qty;
        this.cen4Qty = cen4Qty;
        this.cen5Qty = cen5Qty;
    }

    public String getvCode() {
        return vCode;
    }

    public void setvCode(String vCode) {
        this.vCode = vCode;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public double getcen1Qty() {
        return cen1Qty;
    }

    public void setcen1Qty(double cen1Qty) {
        this.cen1Qty = cen1Qty;
    }

    public double getcen2Qty() {
        return cen2Qty;
    }

    public void setcen2Qty(double cen2Qty) {
        this.cen2Qty = cen2Qty;
    }

    public double getcen3Qty() {
        return cen3Qty;
    }

    public void setcen3Qty(double cen3Qty) {
        this.cen3Qty = cen3Qty;
    }

    public double getcen4Qty() {
        return cen4Qty;
    }

    public void setcen4Qty(double cen4Qty) {
        this.cen4Qty = cen4Qty;
    }

    public double getcen5Qty() {
        return cen5Qty;
    }

    public void setcen5Qty(double cen5Qty) {
        this.cen5Qty = cen5Qty;
    }

    public static boolean CheckQV(String vacode, String loc) {
        String vac1 = vacode;
        String loc1 = loc;
        for (Vaccine vacx : DataIO.allVac) {
            if (vacx.getvCode().equals(vac1)) {
                if (loc.equals("Centre 1")) {
                    double dx = vacx.getcen1Qty();
                    if (dx != 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (loc.equals("Centre 2")) {
                    double dx = vacx.getcen2Qty();
                    if (dx != 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (loc.equals("Centre 3")) {
                    double dx = vacx.getcen3Qty();
                    if (dx != 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (loc.equals("Centre 4")) {
                    double dx = vacx.getcen4Qty();
                    if (dx != 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (loc.equals("Centre 5")) {
                    double dx = vacx.getcen5Qty();
                    if (dx != 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }

            }
        }
        return false;
    }
}
