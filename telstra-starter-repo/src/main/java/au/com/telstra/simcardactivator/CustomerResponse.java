package au.com.telstra.simcardactivator;

public class CustomerResponse {

    private String iccid;
    private String customerEmail;
    private boolean active;
    // Returning the json response of iccid, customerEmail and active status.
    public CustomerResponse(String iccid, String customerEmail, boolean active) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
        this.active = active;
    }

    public String getIccid() {
        return iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public boolean isActive() {
        return active;
    }
}