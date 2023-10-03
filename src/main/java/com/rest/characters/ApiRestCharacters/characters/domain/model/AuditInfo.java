package com.rest.characters.ApiRestCharacters.characters.domain.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AuditInfo {
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;

}
