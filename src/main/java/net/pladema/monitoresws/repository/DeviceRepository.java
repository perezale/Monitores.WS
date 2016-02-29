package net.pladema.monitoresws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

import net.pladema.monitoresws.entity.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {
	
	@RestResource(exported=false)
	@Query("SELECT DISTINCT mac FROM Device p")
    public Object[] findDistinctMacs();
	
}
