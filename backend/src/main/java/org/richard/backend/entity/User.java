package org.richard.backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 64)
    private String name;

    @ManyToOne
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "fk_user_person_id"))
    private Person person;

    @ManyToOne
    @JoinColumn(name = "office_id", foreignKey = @ForeignKey(name = "fk_user_office_id"))
    private Office office;

    @OneToMany(mappedBy = "executorUser")
    private List<Order> executedOrders;

    @OneToMany(mappedBy = "receiverUser")
    private List<Order> receivedOrders;

}
