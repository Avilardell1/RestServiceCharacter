package com.rest.characters.ApiRestCharacters.characters.ports;

import com.rest.characters.ApiRestCharacters.characters.api.dto.CharacterRSDTO;

public interface CharactersService {

    CharacterRSDTO getCharacter(String name);
}
