package org.richard.backend.advertising;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisingDTO {

    private Long id;

    private String title;

    private String description;

}
