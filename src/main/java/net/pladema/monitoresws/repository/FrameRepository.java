package net.pladema.monitoresws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

import net.pladema.monitoresws.entity.Frame;

public interface FrameRepository extends JpaRepository<Frame, Long> {

	@RestResource(exported=false)
	@Query("SELECT DISTINCT source_mac FROM Frame f")
    public Object[] findDistinctSourceMacs();	

	@RestResource(exported=false)
	@Query("SELECT DISTINCT destination_mac FROM Frame f")
    public Object[] findDistinctDestinationMacs();	
	
	@RestResource(exported=false)
	@Query("SELECT DISTINCT frame_type FROM Frame f")
    public Object[] findDistinctFrameType();	

}
