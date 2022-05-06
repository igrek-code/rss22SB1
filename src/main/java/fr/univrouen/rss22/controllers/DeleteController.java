package fr.univrouen.rss22.controllers;

import fr.univrouen.rss22.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("rss22")
public class DeleteController {
    @Autowired
    private ItemRepository itemRepository;

    @DeleteMapping(value="delete/{guid}", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String deleteItem(@PathVariable(value = "guid") long guid){
        try{
            itemRepository.deleteById(guid);
            return "<id>"+guid+"</id><status>DELETED</status>";
        }catch(Exception e){
            return "<status>ERROR</status>";
        }
    }
}
