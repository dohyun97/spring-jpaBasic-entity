package jpabasic.ex1hellojpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "order_id ")
    private Long id;

   @ManyToOne
   @JoinColumn(name="member_id")
   private Member member;

   @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
   @JoinColumn(name = "delivery_id")
   private Delivery delivery;

   @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
   private List<OrderItem> orderItems = new ArrayList<>();

   private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
}
