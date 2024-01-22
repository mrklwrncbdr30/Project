package com.teamd.teamdspringapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamd.teamdspringapi.entity.Certification;
import com.teamd.teamdspringapi.repository.CertificationRepository;

@Service
public class CertificationService {
@Autowired
private CertificationRepository certificationRepository;

public List<Certification> getAllCertifications(){
    return certificationRepository.findAll();
}

public Certification getCertificationById(Long CertificationID){
    return certificationRepository.findById(CertificationID).orElse(null);
}

public Certification saveCertification(Certification certification){
    return certificationRepository.save(certification);
}

public void deleteCertification(Long CertificationID){
    certificationRepository.deleteById(CertificationID);
}
}
