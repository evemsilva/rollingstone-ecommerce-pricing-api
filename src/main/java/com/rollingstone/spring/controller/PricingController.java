package com.rollingstone.spring.controller;

import com.rollingstone.events.PricingEvent;
import com.rollingstone.exceptions.HTTP404Exception;
import com.rollingstone.spring.model.Pricing;
import com.rollingstone.spring.service.PricingService;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pricing")
public class PricingController
		extends AbstractController {

    private final PricingService pricingService;

    public PricingController(PricingService pricingService) {
	this.pricingService = pricingService;
    }

    /*---Add new Pricing---*/
    @PostMapping
    public ResponseEntity<?> createPricing(@RequestBody Pricing pricing) {
	Pricing savedPricing = pricingService.save(pricing);
	PricingEvent categoryCreatedEvent = new PricingEvent(this, "PricingCreatedEvent", pricing);
	eventPublisher.publishEvent(categoryCreatedEvent);
	return ResponseEntity.ok().body("New pricing has been saved with ID:" + savedPricing.getId());
    }

    /*---Get a Pricing by id---*/
    @GetMapping("/{id}")
    public ResponseEntity<Pricing> getPricing(@PathVariable("id") long id) {
	Optional<Pricing> returnedPricing = pricingService.get(id);
	Pricing pricing = returnedPricing.orElseThrow(() -> new HTTP404Exception("Resource Not Found"));

	PricingEvent retrievedCreatedEvent = new PricingEvent(this, "PricingRetrievedEvent", pricing);
	eventPublisher.publishEvent(retrievedCreatedEvent);
	return ResponseEntity.ok().body(pricing);
    }

    /*---get all Pricing---*/
    @GetMapping
    public @ResponseBody
    Page<Pricing> getPricingsByPage(@RequestParam(value = "pagenumber", defaultValue = DEFAULT_PAGE_NUMBER) Integer pageNumber,
				    @RequestParam(value = "pagesize", defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize) {
	return pricingService.getPricingsByPage(pageNumber, pageSize);
    }

    /*---Update a Pricing by id---*/
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePricing(@PathVariable("id") long id, @RequestBody Pricing category) {
	checkResourceFound(this.pricingService.get(id));
	pricingService.update(id, category);
	return ResponseEntity.ok().body("Pricing has been updated successfully.");
    }

    /*---Delete a Pricing by id---*/
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePricing(@PathVariable("id") long id) {
	checkResourceFound(this.pricingService.get(id));
	pricingService.delete(id);
	return ResponseEntity.ok().body("Pricing has been deleted successfully.");
    }
}