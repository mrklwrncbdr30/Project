package com.teamd.teamdspringapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamd.teamdspringapi.entity.Badge;
import com.teamd.teamdspringapi.repository.BadgeRepository;

@Service
public class BadgeService {
@Autowired
private BadgeRepository badgeRepository;

public List<Badge> getAllBadge(){
    return badgeRepository.findAll();
}

public Badge getBadgeById(Long BadgeID){
    return badgeRepository.findById(BadgeID).orElse(null);
}

public Badge saveBadge(Badge badge){
    return badgeRepository.save(badge);
}

public void deleteBadge(Long BadgeID){
    badgeRepository.deleteById(BadgeID);
}
}
