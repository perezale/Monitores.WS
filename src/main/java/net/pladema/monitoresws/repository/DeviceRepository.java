package net.pladema.monitoresws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.pladema.monitoresws.entity.Device;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
