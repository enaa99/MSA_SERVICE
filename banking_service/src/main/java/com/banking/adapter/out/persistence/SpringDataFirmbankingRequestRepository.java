package com.banking.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataFirmbankingRequestRepository extends JpaRepository<RequestFirmbankingJapEntity, Long> {

}
