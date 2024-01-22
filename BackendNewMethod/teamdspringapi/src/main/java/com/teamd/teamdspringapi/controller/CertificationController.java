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

import com.teamd.teamdspringapi.entity.Certification;
import com.teamd.teamdspringapi.service.CertificationService;

@RestController
@RequestMapping("/api/certifications")
@CrossOrigin("http://localhost:5173")
public class CertificationController {
@Autowired
private CertificationService certificationService;

@GetMapping
public List<Certification> getAllCertifications(){
    return certificationService.getAllCertifications();
}

@GetMapping("/{CertificationID}")
public Certification getCertificationById(@PathVariable Long CertificationID){
    return certificationService.getCertificationById(CertificationID);
}

@PostMapping
public Certification saveCertification(@RequestBody Certification certification){
    return certificationService.saveCertification(certification);
}

@DeleteMapping("/{CertificationID}")
public void deleteCertification(@PathVariable Long CertificationID){
    certificationService.deleteCertification(CertificationID);
}
}
