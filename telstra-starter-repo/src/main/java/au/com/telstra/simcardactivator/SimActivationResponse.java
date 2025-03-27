package au.com.telstra.simcardactivator;

// Define the reponse if success, returning success: boolean
public class SimActivationResponse {
    private boolean success;

    public SimActivationResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}