package net.pladema.monitoresws.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import net.pladema.monitoresws.entity.Android;

public interface AndroidRepository extends PagingAndSortingRepository<Android, Long> {
	 
	Page<Android> findByVehicleIdLikeAndHistoryDateLike(@Param("vehicle_id") String vehicleId, @Param("history_date") String historyDate, Pageable page);
	
	Page<Android> findByVehicleIdLike(@Param("vehicle_id") String vehicleId, Pageable page);
	
}
