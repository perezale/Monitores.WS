package net.pladema.monitoresws.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.pladema.monitoresws.entity.Device;
import net.pladema.monitoresws.repository.DeviceRepository;

@Service
public class DbInitService {

    @Autowired
    private DeviceRepository repository;

    @PostConstruct
    public void init() {
        Device person1 = new Device("Mert", "Caliskan", "emailaddress@gmail.com");
        repository.save(person1);
        Device person2 = new Device("Steve", "Millidge", "emailaddress1@c2b2.co.uk");
        repository.save(person2);
        Device person3 = new Device("Andrew", "Pielage", "emailaddress2@c2b2.co.uk");
        repository.save(person3);
    }
}