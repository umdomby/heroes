package navatar.heroes.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController {

    public List<Map<String,String>> testMessage = new ArrayList<>(){{
        add(new HashMap<String,String>() {{ put ("id", "1");  put("text","First Message");}});
        add(new HashMap<String,String>() {{ put ("id", "2");  put("text","First Message");}});
        add(new HashMap<String,String>() {{ put ("id", "3");  put("text","First Message");}});
    }};

    @GetMapping
    public List<Map<String, String>> list(){
        return testMessage;
    }
}
