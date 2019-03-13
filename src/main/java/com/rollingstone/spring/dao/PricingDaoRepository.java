package com.rollingstone.spring.dao;

import com.rollingstone.spring.model.Pricing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PricingDaoRepository
		extends PagingAndSortingRepository<Pricing, Long> {

	Page<Pricing> findAll(Pageable pageable);
}
