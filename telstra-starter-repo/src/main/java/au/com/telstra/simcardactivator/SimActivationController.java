package au.com.telstra.simcardactivator;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimActivationController {

    // Created the POST api with /actuate and check request if having iccid and it not null or empty and return reponse
    @PostMapping("/actuate")
    public SimActivationResponse activateSim(@RequestBody SimActivationRequest request) {
        boolean isValid = request.getIccid() != null && !request.getIccid().isEmpty();
        return new SimActivationResponse(isValid);
    }
}