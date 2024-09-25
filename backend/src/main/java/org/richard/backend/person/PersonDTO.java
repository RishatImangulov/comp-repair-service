package org.richard.backend.person;

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
