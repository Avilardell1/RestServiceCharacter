package com.rest.characters.ApiRestCharacters.characters.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class LocationModel {
    private String name;
    private String url;
}
