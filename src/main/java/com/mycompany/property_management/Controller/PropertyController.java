package com.mycompany.property_management.Controller;

import com.mycompany.property_management.Service.PropertyService;
import com.mycompany.property_management.dto.PropertyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
//This line is to group multiple request together (giving path) and can run without it
public class PropertyController {
    @Autowired
    private PropertyService propertyService;
    //http://localhost:8089/api/v1/properties/hello
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello my name is kachu";
    }

    //http://localhost:8089/api/v1/properties
    @PostMapping("/properties")
    public PropertyDTO saveProperty(@RequestBody PropertyDTO propertyDTO){
        propertyService.saveProperty(propertyDTO);
        System.out.println(propertyDTO);
        return propertyDTO;
    }
}
