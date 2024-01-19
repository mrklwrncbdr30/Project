package com.teamd.teamdspringapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamd.teamdspringapi.entity.Support;
import com.teamd.teamdspringapi.repository.SupportRepository;

@Service
public class SupportService {
    @Autowired
    private SupportRepository supportRepository;

    public List<Support> getAllSupport() {
        return supportRepository.findAll();
    }

    public Support getSupportById(Long SupportID) {
        return supportRepository.findById(SupportID).orElse(null);
    }

    public Support saveSupport(Support support) {
        return supportRepository.save(support);
    }

    public void deleteSupport(Long SupportID) {
        supportRepository.deleteById(SupportID);
    }
}
