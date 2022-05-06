package fr.univrouen.rss22.controllers;

import fr.univrouen.rss22.entities.Item;
import fr.univrouen.rss22.entities.ItemResume;
import fr.univrouen.rss22.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("rss22")
public class GetController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping(value = "resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public List<ItemResume>
    getAllItemsResume() {
        return itemRepository.findAllResumeBy();
    }

    @GetMapping(value = "resume/html/{guid}")
    public String
    resumeHtmlPage(@PathVariable(value = "guid") long guid, Model model) throws Exception {
        Item item = itemRepository.findById(guid).orElseThrow(() -> new Exception("Invalid item Id:" + guid));
        model.addAttribute("item", item);
        return "itemResume";
    }

    @GetMapping(value = "resume/xml/{guid}", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Object
    getItemResume(@PathVariable(value = "guid") long guid) throws Exception {
        try {
            return itemRepository.findById(guid).orElseThrow(() -> new Exception("<id>" + guid + "</id><status>ERROR</status>"));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping(value = "resume/{guid}")
    public String
    completeHtmlPage(@PathVariable(value = "guid") long guid, Model model) throws Exception {
        try {
            Item item = itemRepository.findById(guid).orElseThrow(() -> new Exception("Invalid item Id:" + guid));
            model.addAttribute("item", item);
            model.addAttribute("authors", item.getAuthors());
            model.addAttribute("categories", item.getCategories());
            return "itemComplete";
        }catch(Exception e){
            model.addAttribute("guid", guid);
            return "itemError";
        }
    }

}
