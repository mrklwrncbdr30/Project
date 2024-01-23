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

import com.teamd.teamdspringapi.entity.Badge;
import com.teamd.teamdspringapi.service.BadgeService;

@RestController
@RequestMapping("/api/badges")
@CrossOrigin("http://localhost:5173")
public class BadgeController {
@Autowired
private BadgeService badgeService;

@GetMapping
public List<Badge> getAllBadge(){
    return badgeService.getAllBadge();
}

@GetMapping("/{BadgeID}")
public Badge getBadgeById(@PathVariable Long BadgeID){
    return badgeService.getBadgeById(BadgeID);
}

@PostMapping
public Badge saveBadge(@RequestBody Badge badge){
    return badgeService.saveBadge(badge);
}

@DeleteMapping
public void deleteBadge(@PathVariable Long BadgeID){
    badgeService.deleteBadge(BadgeID);
}
}
