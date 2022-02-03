package com.konrad.App;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Item {

    private String id;
    private String userId;
    private String name;

    public Item(String name) {
        this.name = name;
    }
}
