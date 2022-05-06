package fr.univrouen.rss22.controllers;

import fr.univrouen.rss22.entities.Item;
import fr.univrouen.rss22.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@RestController
@RequestMapping("rss22")
public class PostController {
	@Autowired
	private ItemRepository itemRepository;


	@PostMapping(value = "/insert", produces = MediaType.APPLICATION_XML_VALUE, consumes = "application/xml")
	@ResponseBody
	public String insert(@RequestBody Item item) throws SAXException, ParserConfigurationException, IOException {

		try {
			Item returnItem = itemRepository.save(item);
			return "<guid>"+returnItem.getGuid()+"</guid><status>INSERTED</status>";
		}catch(Exception e){
			return "<status>ERROR</status>";
		}
	}

}
