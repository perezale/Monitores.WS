package net.pladema.monitoresws.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import net.pladema.monitoresws.entity.Detector;

public interface DetectorRepository extends PagingAndSortingRepository<Detector, Long> {
		 
}
