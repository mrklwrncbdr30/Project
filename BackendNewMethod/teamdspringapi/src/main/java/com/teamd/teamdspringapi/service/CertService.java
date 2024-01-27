package com.teamd.teamdspringapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamd.teamdspringapi.entity.Cert;
import com.teamd.teamdspringapi.repository.CertRepository;

import java.util.List;

@Service
public class CertService {

    @Autowired
    private CertRepository certRepository;

    public List<Cert> getAllCert() {
        return certRepository.findAll();
    }

    public Cert getCertById(Long certID) {
        return certRepository.findById(certID).orElse(null);
    }

    // Modify the saveCert method to handle byte array (blob data)
    public Cert saveCert(byte[] fileBytes) {
        Cert cert = new Cert();
        cert.setFile(fileBytes);
        return certRepository.save(cert);
    }

    public void deleteCert(Long certID) {
        certRepository.deleteById(certID);
    }
}
