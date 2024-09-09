package org.richard.backend.dto;

import jakarta.persistence.*;
import lombok.*;
import org.richard.backend.entity.Advertising;
import org.richard.backend.entity.ClientStatus;
import org.richard.backend.entity.Order;

import java.util.List;
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private Long id;

    private String name;

    private Long phone;

    private Long advertising;

    private Long status;

}
