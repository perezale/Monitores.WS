package net.pladema.monitoresws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.pladema.monitoresws.entity.Frame;
import net.pladema.monitoresws.repository.FrameRepository;

@Service
public class FrameService {

	@Autowired
	private FrameRepository frameRepository;
	
	public List<Frame> findAll(){
		return frameRepository.findAll();
	}
}
