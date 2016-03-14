package net.pladema.monitoresws.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import net.pladema.monitoresws.entity.Android;
import net.pladema.monitoresws.entity.AndroidPK;

public interface AndroidRepository extends PagingAndSortingRepository<Android, AndroidPK> {
	 
	Page<Android> findById_vehicleIdLikeAndId_historyDateLike(String vehicleId, String historyDate, Pageable page);
	
}
