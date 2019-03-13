package com.rollingstone.spring.service;

import com.rollingstone.spring.model.Pricing;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface PricingService {

    Pricing save(Pricing pricing);

    Optional<Pricing> get(long id);

    Page<Pricing> getPricingsByPage(Integer pageNumber, Integer pageSize);

    void update(long id, Pricing pricing);

    void delete(long id);
}
