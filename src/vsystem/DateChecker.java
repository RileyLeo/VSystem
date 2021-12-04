package vsystem;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.ResolverStyle;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateChecker {
    
    //DATE CHECKER TO MAKE SURE THE INPUTTED DATE IS VALID / CAN'T ONLY USE CheckDate1 Func, since SimpleDateFormat isn't 100% accurate.
    public boolean CheckDate (String dob){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu",Locale.US).withResolverStyle(ResolverStyle.STRICT);

        
        try
        {
            formatter.parse(dob); 
            return true; 
        }
        
        catch(Exception e)
        {
            return false;
        }
    }
    
    
    //DATE CHECKER TO MAKE SURE THE INPUTTED DATE IS LESS THAN CURRENT YEAR (DATE OF BIRTH)
    public boolean CheckDate1 (String dob){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String datecur = sdf.format(date);
        
        try{
            Date date1 = sdf.parse(datecur);
            Date date2 = sdf.parse(dob);
            if(date2.before(date1)){
                return true;
            }else{
                return false;
            }
        }
        
        catch(Exception e)
        {
            return false;
        }

    }
    
    //DATE CHECKER FOR APPOINMENT TO MAKE SURE THE INPUTTED DATE IS MIN 14 DAYS FROM CURRENT DATE
    public boolean CheckDate2 (String dob){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu",Locale.US).withResolverStyle(ResolverStyle.STRICT);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        Date date = new Date();
        String datePlus = formatter.format(LocalDateTime.from(date.toInstant().atZone(ZoneId.of("Asia/Kuala_Lumpur"))).plusDays(14));
        
        
        try{
            Date date1 = sdf.parse(datePlus);
            Date date2 = sdf.parse(dob);
            if(date2.equals(date1) || date2.after(date1)){
                return true;
            }else{
                return false;
            }
        }
        
        catch(Exception e)
        {
            return false;
        }

    }
    
      
}