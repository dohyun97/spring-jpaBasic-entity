package jpabasic.ex1hellojpa.domain;

import org.aspectj.weaver.ast.Or;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
public class Delivery extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    private DeliverStatus status;

    @OneToOne(mappedBy = "delivery",fetch = LAZY)
    private Order order;

}
