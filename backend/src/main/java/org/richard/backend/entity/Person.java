package org.richard.backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long phone;

    @ManyToOne
    @JoinColumn(name = "advertising", foreignKey = @ForeignKey(name = "fk_person_adv_id"))
    private Advertising advertising;

    @OneToMany(mappedBy = "person")
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name = "client_status_id", foreignKey = @ForeignKey(name = "fk_person_status_id"))
    private ClientStatus clientStatus;

}
