package com.example.shipgofunding.funding.fundingHeart.repository;

import com.example.shipgofunding.funding.domain.Funding;
import com.example.shipgofunding.funding.fundingHeart.domain.FundingHeart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FundingHeartJpaRepository extends JpaRepository<FundingHeart, Integer> {
    boolean existsByFundingIdAndUserId(int fundingId, Long id);

    void deleteByFundingIdAndUserId(int fundingId, Long id);

    int countByUserId(Long id);
}
