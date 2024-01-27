package com.teamd.teamdspringapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.teamd.teamdspringapi.entity.Cert;
import com.teamd.teamdspringapi.service.CertService;

@RestController
@RequestMapping("/api/certs")
@CrossOrigin("http://localhost:5173")
public class CertController {

    @Autowired
    private CertService certService;

    @GetMapping
    public List<Cert> getAllCert() {
        return certService.getAllCert();
    }
    @GetMapping("/test")
    public ResponseEntity<List<Cert>> testGet() {
        List<Cert> certs = certService.getAllCert();
        return ResponseEntity.ok(certs);
}
    @GetMapping("/{CertID}")
    public Cert getCertById(@PathVariable Long CertID) {
        return certService.getCertById(CertID);
    }

    @PostMapping
    public ResponseEntity<String> uploadCert(@RequestBody CertRequest certRequest) {
        try {
            // Convert base64 data to byte array
            byte[] fileBytes = java.util.Base64.getDecoder().decode(certRequest.getFile());

            // Save fileBytes to the "cert" table in your database
            certService.saveCert(fileBytes);

            return ResponseEntity.ok("Cert stored successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    @DeleteMapping("/{CertID}")
    public void deleteCert(@PathVariable Long CertID) {
        certService.deleteCert(CertID);
    }

    // Inner class to represent the request structure
    public static class CertRequest {
        private String file;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }
    }
}
