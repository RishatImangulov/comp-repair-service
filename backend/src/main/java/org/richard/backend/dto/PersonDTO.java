package org.richard.backend.dto;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    private String name;

    private Long phone;

    private Long advertising;

    private Long clientStatus;

}
