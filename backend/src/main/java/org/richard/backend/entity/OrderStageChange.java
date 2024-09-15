package org.richard.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "order_stage_change")
public class OrderStageChange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "fk_order_stage_change_order_id"))
    private Order order;

    @Column(name = "edited_at")
    private LocalDateTime editedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_order_stage_change_user_id"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "order_stage_id", foreignKey = @ForeignKey(name = "fk_order_stage_change_order_change_id"))
    private OrderStage orderStage;

    @PrePersist
    public void prePersist() {
        editedAt = LocalDateTime.now();
    }
}
