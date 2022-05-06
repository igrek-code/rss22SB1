package fr.univrouen.rss22.controllers;

import fr.univrouen.rss22.repository.ItemRepository;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
public class IndexController {
    private final ItemRepository itemRepository;

    public IndexController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String getAcceuil() throws IOException {
        org.springframework.core.io.Resource resource = new DefaultResourceLoader().getResource("classpath:acceuil.html");
        InputStream inputStream = resource.getInputStream();
        String acceuilPage = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        return acceuilPage;
    }

}
