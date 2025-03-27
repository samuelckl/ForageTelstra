package au.com.telstra.simcardactivator;

// Define the request entities, iccid and email
public class SimActivationRequest {
    private String iccid;
    private String customerEmail;

    public String getIccid() {
        return iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }
}