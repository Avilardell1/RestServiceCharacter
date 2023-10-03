package com.rest.characters.ApiRestCharacters.characters.domain;

import com.rest.characters.ApiRestCharacters.characters.api.dto.CharacterRSDTO;
import com.rest.characters.ApiRestCharacters.characters.api.feign.CharacterFeignClient;
import com.rest.characters.ApiRestCharacters.characters.domain.model.CharacterModel;
import com.rest.characters.ApiRestCharacters.characters.domain.model.CharacterRequestModel;
import com.rest.characters.ApiRestCharacters.characters.domain.model.EpisodeRequestModel;
import com.rest.characters.ApiRestCharacters.characters.ports.CharactersService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharactersService {

   private final CharacterFeignClient client;

    public CharacterServiceImpl(CharacterFeignClient client) {
        this.client = client;
    }

    /*Get character info*/
    @Override
    public CharacterRSDTO getCharacter(String name) {
        CharacterRSDTO result = CharacterRSDTO.builder().build();
        try {
            CharacterRequestModel characterModel = this.client.getCharacterByName(name);
            List<String>listEpisodes = new ArrayList<>();
            List<String>air_dates = new ArrayList<>();
            for (CharacterModel model: characterModel.getResults()) {
                result.setName(model.getName());
                for(String episode : model.getEpisode()) {
                    String[] episodes = episode.split("/");
                    Integer id = Integer.parseInt(episodes[5]);
                    EpisodeRequestModel episodeRequestModel = this.client.getEpisodeById(id);
                    listEpisodes.add(episodeRequestModel.getName());
                    air_dates.add(episodeRequestModel.getAir_date());
                }
                result.setEpisodes(listEpisodes);
            }
            result.setFirst_appearance(getEarlierDate(air_dates));

        } catch(Exception ex) {
            ex.getStackTrace();
        }
        return result;
    }
    /* Get the oldest date */
    private String getEarlierDate (List<String> dates) {
        return Collections.min(dates);
    }
}
