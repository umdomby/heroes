package navatar.heroes.controller;

import navatar.heroes.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("test2")
public class Test2Controller {

    private int counter = 4;

    private List<Map<String , String>> test2Messages = new ArrayList<>(){{
        add(new HashMap<>() {{put("id","1"); put("text","firstSecond");}});
        add(new HashMap<>() {{put("id","2"); put("text","firstSecond");}});
        add(new HashMap<>() {{put("id","3"); put("text","firstSecond");}});
    }};

    @GetMapping
    public List<Map<String,String>> list(){
        return test2Messages;
    }

    @GetMapping("{id}")
       public Map<String,String> getOne (@PathVariable String id){
        return getMessage(id);
    }

    private Map<String, String> getMessage(String id) {
        return test2Messages.stream()
                .filter(test2Message -> test2Message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Map<String, String> create (@RequestBody Map<String, String> test2Message){
        test2Message.put("id", String.valueOf(counter++));
        test2Messages.add(test2Message);
        return  test2Message;
    }

    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> test2Message) {
        Map<String, String> messageFromDb = getMessage(id);
        messageFromDb.putAll(test2Message);
        messageFromDb.put("id", id);
        return messageFromDb;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        Map<String, String> message = getMessage(id);
        test2Messages.remove(message);
    }

}
