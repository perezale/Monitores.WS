package net.pladema.monitoresws.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.pladema.monitoresws.entity.Frame;
import net.pladema.monitoresws.repository.FrameRepository;

@Service
public class FrameService {

	@Autowired
	private FrameRepository frameRepository;

	public List<Frame> findAll() {
		return frameRepository.findAll();
	}

	public Frame save(Frame frame) {
		return frameRepository.save(frame);
	}

	public List<Frame> saveMultiple(List<Frame> devices) {
		return frameRepository.save(devices);
	}

	public void delete(List<Frame> frames) {
		frameRepository.delete(frames);
	}

	public List<String> getSourceMacs() {
		Object[] findDistinctMacs = frameRepository.findDistinctSourceMacs();
		return Arrays.asList(findDistinctMacs).stream().map(o -> o.toString()).collect(Collectors.toList());
	}

	public List<String> getDestinationMacs() {
		Object[] findDistinctMacs = frameRepository.findDistinctDestinationMacs();
		return Arrays.asList(findDistinctMacs).stream().map(o -> o.toString()).collect(Collectors.toList());
	}

	public List<String> getFrameTypes() {
		Object[] findDistinctFrameTypes = frameRepository.findDistinctFrameType();
		return Arrays.asList(findDistinctFrameTypes).stream().map(o -> o.toString()).collect(Collectors.toList());
	}
}
