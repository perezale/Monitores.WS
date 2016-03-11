package net.pladema.monitoresws.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import net.pladema.monitoresws.entity.Android;
import net.pladema.monitoresws.entity.AndroidPK;

public interface AndroidRepository extends PagingAndSortingRepository<Android, AndroidPK> {
		 
}
