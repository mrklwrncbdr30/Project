package com.teamd.teamdspringapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamd.teamdspringapi.entity.Support;
import com.teamd.teamdspringapi.service.SupportService;

@RestController
@RequestMapping("/api/supports")
@CrossOrigin("http://localhost:5173")
public class SupportController {
@Autowired
private SupportService supportService;

@GetMapping
public List<Support> getAllSupport(){
    return supportService.getAllSupport();
}

@GetMapping("/{SupportID}")
public Support getSupportById(@PathVariable Long SupportID){
    return supportService.getSupportById(SupportID);
}

@PostMapping
public Support saveSupport(@RequestBody Support support){
    return supportService.saveSupport(support);
}

  @DeleteMapping
    public void deleteSupport(@PathVariable Long SupportID) {
        supportService.deleteSupport(SupportID);
    }
}
