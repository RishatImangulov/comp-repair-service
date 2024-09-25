package org.richard.backend.clientStatus;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientStatusDTO {

    private Long id;

    private String title;

    private String description;

}
