package vsystem;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class Centre {

    private String centre;
    public static ArrayList<Centre> allCen = new ArrayList<Centre>();

    public Centre(String centre) {
        this.centre = centre;
    }

    public static void readCen() {
        String cen1 = "All Centre";
        String cen2 = "Centre 1";
        String cen3 = "Centre 2";
        String cen4 = "Centre 3";
        String cen5 = "Centre 4";
        String cen6 = "Centre 5";
        Centre cent = new Centre(cen1);
        allCen.add(cent);
        Centre cent2 = new Centre(cen2);
        allCen.add(cent2);
        Centre cent3 = new Centre(cen3);
        allCen.add(cent3);
        Centre cent4 = new Centre(cen4);
        allCen.add(cent4);
        Centre cent5 = new Centre(cen5);
        allCen.add(cent5);
        Centre cent6 = new Centre(cen6);
        allCen.add(cent6);

        DefaultComboBoxModel dmx = new DefaultComboBoxModel();
        for (int i = 0; i < Centre.allCen.size(); i++) {
            dmx.addElement(Centre.allCen.get(i).getCen());
        }
        VSystem.dm1 = dmx;

        DefaultComboBoxModel dmx1 = new DefaultComboBoxModel();
        for (int i = 1; i < Centre.allCen.size(); i++) {
            dmx1.addElement(Centre.allCen.get(i).getCen());
        }
        VSystem.dm2 = dmx1;

    }

    public String getCen() {
        return centre;
    }

}
