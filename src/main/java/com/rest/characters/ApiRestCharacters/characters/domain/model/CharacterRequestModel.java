package com.rest.characters.ApiRestCharacters.characters.domain.model;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CharacterRequestModel {

    private AuditInfo info;
    private List<CharacterModel> results;

}
