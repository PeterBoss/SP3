package entity;

import static entity.DiscountFixed_.discount;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Peter
 */
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<DiscountType> discounts = new ArrayList();
    
    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public void addDiscount(DiscountType discount) {
        discounts.add(discount);
    }
    
    public double getPrice(double pricePerItem, int quantity) {
        return 0; //not important (it was too much trouble)
    }

}
