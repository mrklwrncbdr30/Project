package com.teamd.teamdspringapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamd.teamdspringapi.entity.Cert;

public interface CertRepository extends JpaRepository<Cert,Long> {

}
