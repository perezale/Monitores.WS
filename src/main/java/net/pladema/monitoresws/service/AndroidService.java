package net.pladema.monitoresws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import net.pladema.monitoresws.entity.Android;
import net.pladema.monitoresws.entity.AndroidPK;
import net.pladema.monitoresws.repository.AndroidRepository;

@Service
public class AndroidService {

	@Autowired
	private AndroidRepository androidRepository;

	public List<Android> findAll() {
		return Lists.newArrayList(androidRepository.findAll());
	}

	public Android save(Android frame) {
		return androidRepository.save(frame);
	}

	public List<Android> saveMultiple(List<Android> androids) {
		List<Android> output = new ArrayList<Android>();
		for (Android android : androids) {
			output.add(androidRepository.save(android));
		}
		return output;
	}

	public void delete(List<Android> androids) {
		androidRepository.delete(androids);
	}

	public Android findOne(AndroidPK rowKey) {
		return androidRepository.findOne(rowKey);
	}

	public Page<Android> filter(PageRequest page, Map<String, Object> filters) {		
		String vehicleId = (String)filters.get("id.vehicleId");
		if (vehicleId == null || vehicleId.compareTo("") == 0) {
			vehicleId = "%%";
		} else {
			vehicleId = "%" + vehicleId + "%";
		}
		String historyDate = (String)filters.get("id.historyDate");
		if (historyDate == null || historyDate.compareTo("") == 0) {
			historyDate = "%%";
		} else {
			historyDate = "%" + historyDate + "%";
		}
		Page<Android> findAll = androidRepository.findById_vehicleIdLikeAndId_historyDateLike(vehicleId, historyDate, page);
		return findAll;
	}
}
