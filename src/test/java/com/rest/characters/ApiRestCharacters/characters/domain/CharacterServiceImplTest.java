package com.rest.characters.ApiRestCharacters.characters.domain;

import com.rest.characters.ApiRestCharacters.characters.api.feign.CharacterFeignClient;
import com.rest.characters.ApiRestCharacters.characters.domain.model.AuditInfo;
import com.rest.characters.ApiRestCharacters.characters.domain.model.CharacterModel;
import com.rest.characters.ApiRestCharacters.characters.domain.model.CharacterRequestModel;
import com.rest.characters.ApiRestCharacters.characters.domain.model.EpisodeRequestModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CharacterServiceImplTest {

    @InjectMocks
    private CharacterServiceImpl serviceImpl;

    @Mock
    private CharacterFeignClient client;

    @Test
    public void getCharacter() {
        CharacterRequestModel model = new CharacterRequestModel();
        model.setInfo(new AuditInfo());

        List<CharacterModel> listCharacter = new ArrayList<>();
        CharacterModel characterModel = new CharacterModel();
        characterModel.setName("Rick Sanchez");
        List<String> listEpisodes = new ArrayList<>();
        listEpisodes.add("https://rickandmortyapi.com/api/character/1");
        listEpisodes.add("https://rickandmortyapi.com/api/character/2");
        characterModel.setEpisode(listEpisodes);

        listCharacter.add(characterModel);
        model.setResults(listCharacter);

        EpisodeRequestModel episodeRequestModel = new EpisodeRequestModel();
        episodeRequestModel.setName("The Ricklantis Mixup");
        episodeRequestModel.setAir_date("2017-11-10T12:56:36.618Z");

        when(client.getEpisodeById(1)).thenReturn(episodeRequestModel);
        when(client.getCharacterByName("Rick Sanchez")).thenReturn(model);
        serviceImpl.getCharacter("Rick Sanchez");
    }
}
