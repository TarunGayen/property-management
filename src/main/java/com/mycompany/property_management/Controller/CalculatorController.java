package com.mycompany.property_management.Controller;

import com.mycompany.property_management.dto.CalculatorDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {
    //http://localhost:8089/api/v1/calculator/add?num1=3.5&num2=2.8
    @GetMapping("/add")
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2){

        return num1+num2;
    }
    //http://localhost:8089/api/v1/calculator/sub/3.5/5.2
    @GetMapping("/sub/{num1}/{num2}")
    public Double subtract(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2){
        Double result=null;
        if (num1>num2){
            result=num1-num2;
        }
        else{
            result=num2-num1;
        }
        return result;
    }
    //http://localhost:8089/api/v1/calculator/mul -> Json object
    @PostMapping("/mul")
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDTO){
        Double result=null;
        result=calculatorDTO.getNum1()*calculatorDTO.getNum2()*calculatorDTO.getNum3()*calculatorDTO.getNum4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return  responseEntity;
    }

}
