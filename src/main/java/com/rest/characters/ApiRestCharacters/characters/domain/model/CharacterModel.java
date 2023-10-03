package com.rest.characters.ApiRestCharacters.characters.domain.model;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CharacterModel {

    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private OriginModel origin;
    private LocationModel location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;

}
