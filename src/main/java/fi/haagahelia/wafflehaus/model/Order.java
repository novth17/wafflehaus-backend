package fi.haagahelia.wafflehaus.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //one order can only belong to only one customer, but A User can place many Orders
    @ManyToOne(optional = false)


}
