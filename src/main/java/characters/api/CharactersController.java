package characters.api;

import characters.api.dto.CharacterRSDTO;
import characters.ports.CharactersService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CharactersController {

   @Autowired	
   private final CharactersService service;

    public CharactersController(CharactersService service) {
    	this.service = service;
    }

	@RequestMapping(value="/search-character-appearance/{name}",method=RequestMethod.GET)
    public ResponseEntity<CharacterRSDTO> getAppearance(@PathVariable("name") String name) {
        return new ResponseEntity<>(this.service.getCharacter(name), HttpStatus.OK);
    }
}
