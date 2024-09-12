package org.richard.backend.dto;

import jakarta.persistence.*;
import lombok.*;
import org.richard.backend.entity.Note;
import org.richard.backend.entity.Person;
import org.richard.backend.entity.User;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order")
public class OrderDTO {

    private Long id;

    private Long number;

    private int year;

    private LocalDateTime createdAt;

    private User receiverUser;

    private User executorUser;

    private Person person;

    private List<Note> notes;

}
