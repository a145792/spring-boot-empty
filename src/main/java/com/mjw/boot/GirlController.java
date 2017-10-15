package com.mjw.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @GetMapping("/girls")
    public List<Girl> getGirlList(){
        List<Girl> list = girlRepository.findAll();
        return list;
    }

    @PostMapping("/girls")
    public Girl saveGirl(Girl girl){
        Girl save = girlRepository.save(girl);
        return save;
    }

    @GetMapping("/girl/{id}")
    public Girl getGirl(@PathVariable("id") int id){
        Girl girl = girlRepository.findOne(id);
        return girl;
    }

    @PutMapping("/girl/{id}")
    public Girl updateGirl(@PathVariable("id") int id,Girl girl){
        girl.setAge(id);
        Girl save = girlRepository.save(girl);
        return save;
    }

    @DeleteMapping("/girl/{id}")
    public void delete(@PathVariable("id") int id){
        girlRepository.delete(id);
    }
}
