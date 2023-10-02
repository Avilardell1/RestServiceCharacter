package characters.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class CharacterRequestModel {

    private AuditInfo info;
    private List<CharacterModel> results;

}
