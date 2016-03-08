package net.pladema.monitoresws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

import net.pladema.monitoresws.entity.SmartphoneDetection;

public interface SmartphoneDetectionRepository extends JpaRepository<SmartphoneDetection, Long> {


	@RestResource(exported=false)
	@Query("SELECT DISTINCT source_mac FROM SmartphoneDetection s")
    public Object[] findDistinctSourceMacs();	

	@RestResource(exported=false)
	@Query("SELECT DISTINCT destination_mac FROM SmartphoneDetection s")
    public Object[] findDistinctDestinationMacs();	
	
	@RestResource(exported=false)
	@Query("SELECT DISTINCT protocol FROM SmartphoneDetection s")
    public Object[] findDistinctProtocols();	
}