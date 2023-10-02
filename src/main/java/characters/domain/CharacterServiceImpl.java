package characters.domain;

import characters.api.dto.CharacterRSDTO;
import characters.api.feign.CharacterFeignClient;
import characters.domain.model.CharacterModel;
import characters.domain.model.CharacterRequestModel;
import characters.domain.model.Episode;
import characters.domain.model.EpisodeRequestModel;
import characters.ports.CharactersService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharactersService {

   private final CharacterFeignClient client;

    public CharacterServiceImpl(CharacterFeignClient client) {
        this.client = client;
    }

    @Override
    public CharacterRSDTO getCharacter(String name) {
        CharacterRSDTO result = new CharacterRSDTO();
        try {
            CharacterRequestModel characterModel = client.getCharacterByName(name);
            for (CharacterModel model: characterModel.getResults()) {
                result.setName(model.getName());
                for(String episode : model.getEpisode()) {
                    String[] episodes = episode.split("/");
                    EpisodeRequestModel episodeRequestModel = client.getEpisodeById(Integer.parseInt(episodes[3]));
                    List<String> array_episodes = new ArrayList<>();
                    for (Episode episodeModel : episodeRequestModel.getEpisodes()) {
                        array_episodes.add(episodeModel.getName());
                        result.setFirst_appearance(episodeModel.getAir_date());
                    }

                }
                result.setEpisodes(model.getEpisode());

            }
        } catch(Exception ex) {
            ex.getStackTrace();
        }
        return result;
    }
}
