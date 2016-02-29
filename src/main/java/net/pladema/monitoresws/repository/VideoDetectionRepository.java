package net.pladema.monitoresws.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import net.pladema.monitoresws.entity.VideoDetection;

public interface VideoDetectionRepository extends PagingAndSortingRepository<VideoDetection, Long> {
		 
}
