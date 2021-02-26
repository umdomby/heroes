package navatar.heroes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("heroes")
public class HeroesController {

    public List<Map<String, String>> heroesList = new ArrayList<>(){{
        add(new HashMap<String,String>() {{ put ("id","1"); put ("text", "firstName"); }});
        add(new HashMap<String,String>() {{ put ("id","2"); put ("text", "firstName"); }});
        add(new HashMap<String,String>() {{ put ("id","3"); put ("text", "firstName"); }});
    }};

    @GetMapping
    public List<Map<String, String>> list(){
        return heroesList;
    }
}
