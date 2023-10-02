package characters.api.feign;

import characters.api.feign.configuration.FeignConfiguration;
import characters.domain.model.CharacterRequestModel;
import characters.domain.model.EpisodeRequestModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "characterFeignClient", url = "${external.mock.character.base.url}", configuration = FeignConfiguration.class)
public interface CharacterFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/character/?name={name}&status=alive", produces = "application/json")
    CharacterRequestModel getCharacterByName(@PathVariable("name") String postId);

    @RequestMapping(method = RequestMethod.GET, value = "/episode/{id}", produces = "application/json")
    EpisodeRequestModel getEpisodeById(@PathVariable("id") Integer id);

}
