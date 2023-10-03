package com.rest.characters.ApiRestCharacters.characters.api;

import com.rest.characters.ApiRestCharacters.characters.ports.CharactersService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(MockitoExtension.class)
public class CharactersControllerTest {

    @InjectMocks
    private CharactersController controller;

    @Mock
    private CharactersService service;

    @Test
    public void test_constructor() { assertDoesNotThrow( () -> new CharactersController(service)); }

    @Test
    public void testGetAppearance() {
        controller.getAppearance("Rick Sanchez");
    }
}
