package org.richard.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long number;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "receiver_user", foreignKey = @ForeignKey(name = "fk_order_user_receiver_id"))
    private User receiverUser;

    @ManyToOne
    @JoinColumn(name = "executor_user", foreignKey = @ForeignKey(name = "fk_order_user_executor_id"))
    private User executorUser;

    @ManyToOne
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "fk_order_person_id"))
    private Person person;

    @OneToMany(mappedBy = "order")
    private List<Note> notes;

    @OneToMany
    private List<OrderStageChange> orderStageChanges;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

}
