package characters.ports;

import characters.api.dto.CharacterRSDTO;

public interface CharactersService {

    CharacterRSDTO getCharacter(String name);
}
