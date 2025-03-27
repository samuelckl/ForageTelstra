package au.com.telstra.database;

// Since using Java11, stick with previous library
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String iccid;
    private String customerEmail;
    private boolean active;

    protected Customer(){}

    public Customer(String iccid, String customerEmail, boolean active){
            this.iccid = iccid;
            this.customerEmail = customerEmail;
            this.active = active;
    }

    public Long getId(){
        return id;
    }

    public String getIccid(){
        return iccid;
    }

    public String getCustomerEmail(){
        return customerEmail;
    }

    public boolean isActive(){
        return active;
    }

}
