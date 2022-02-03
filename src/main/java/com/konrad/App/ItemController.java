package com.konrad.App;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ItemController {

    @PostMapping("/items")
    public void addItem(){

    }

    @GetMapping("/items")
    public List<Item> getItems(){
        return null;
    }

}
