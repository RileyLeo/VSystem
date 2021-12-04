package vsystem;

public enum AppStat {
    Pending, // waiting for committee to accept the request and provide date and location
    Rejected, // committee has rejected the appointment reuqest OR the citizen have rejected the given date and location
    Accepted, // committee has accepted the appointment reuqest and provided date and location of the vaccination
    Confirmed, // the citizen have confirmed the date and location of the vaccination
    Completed; // the vaccination is completed. 
}
