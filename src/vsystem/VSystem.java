package vsystem;

import javax.swing.DefaultComboBoxModel;

public class VSystem {

    public static void main(String[] args) {
        DataIO.read();
        Centre.readCen();
        Report.readRep();
        Appointment.appAuto();

    }
    public static LoginPage one = new LoginPage();
    public static RegPeoplePage two = new RegPeoplePage();
    public static RegComPage three = new RegComPage();
    public static ComMenuPage four = new ComMenuPage();
    public static ComViewPage five = new ComViewPage();
    public static ComF1Page six = new ComF1Page();
    public static ComF2Page seven = new ComF2Page();
    public static ComF3Page eight = new ComF3Page();
    public static ComF3_1Page nine = new ComF3_1Page();
    public static ComF3_2Page ten = new ComF3_2Page();
    public static ComF3_3Page eleven = new ComF3_3Page();
    public static ComF4Page twelve = new ComF4Page();
    public static ComF5Page fourteen = new ComF5Page();
    public static PepPage fifteen = new PepPage();
    public static PepViewPage sixteen = new PepViewPage();
    public static PepF1Page seventeen= new PepF1Page();
    public static PepF2Page eighteen = new PepF2Page();
    public static Committee login;
    public static People login1;
    public static DefaultComboBoxModel dm1;
    public static DefaultComboBoxModel dm2;
    public static DefaultComboBoxModel rp1;

}
