package com.rest.characters.ApiRestCharacters.characters.api.feign;

import com.rest.characters.ApiRestCharacters.characters.api.feign.configuration.FeignConfiguration;
import com.rest.characters.ApiRestCharacters.characters.domain.model.CharacterRequestModel;
import com.rest.characters.ApiRestCharacters.characters.domain.model.EpisodeRequestModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(value = "characterFeignClient", url = "${external.mock.character.base.url}", configuration = FeignConfiguration.class)
public interface CharacterFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/character/?name={name}&status=alive", produces = MediaType.APPLICATION_JSON_VALUE)
    CharacterRequestModel getCharacterByName(@PathVariable("name") String postId);

    @RequestMapping(method = RequestMethod.GET, value = "/episode/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    EpisodeRequestModel getEpisodeById(@PathVariable("id") Integer id);

}
