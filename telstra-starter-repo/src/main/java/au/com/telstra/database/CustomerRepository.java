package au.com.telstra.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
    Customer findById(long id);
    Customer findByIccid(String iccid);
    
}
