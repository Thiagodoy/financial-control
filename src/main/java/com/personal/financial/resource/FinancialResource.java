package com.personal.financial.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/secure/financial")
public class FinancialResource {

    @PostMapping("/statement")
    public ResponseEntity save(){
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity update(){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity delete(){
        return ResponseEntity.ok().build();
    }

}
