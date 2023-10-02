package characters.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CharacterRSDTO {

    private String name;
    private List<String> episodes;
    private String first_appearance;

    public CharacterRSDTO() {

    }
}
