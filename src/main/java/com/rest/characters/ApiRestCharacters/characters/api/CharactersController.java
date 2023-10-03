package com.rest.characters.ApiRestCharacters.characters.api;

import com.rest.characters.ApiRestCharacters.characters.api.dto.CharacterRSDTO;
import com.rest.characters.ApiRestCharacters.characters.ports.CharactersService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("search-character-appearance")
public class CharactersController {

    private final CharactersService service;

    public CharactersController(CharactersService service) {
    	this.service = service;
    }

	@GetMapping(value="/{name}")
    public ResponseEntity<CharacterRSDTO> getAppearance(@PathVariable("name") String name) {
        return new ResponseEntity<>(this.service.getCharacter(name), HttpStatus.OK);
    }
}
