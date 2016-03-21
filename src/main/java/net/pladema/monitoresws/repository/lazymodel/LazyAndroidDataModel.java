package net.pladema.monitoresws.repository.lazymodel;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import net.pladema.monitoresws.entity.Android;
import net.pladema.monitoresws.service.AndroidService;

public class LazyAndroidDataModel extends LazyDataModel<Android> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AndroidService androidService;

	public LazyAndroidDataModel(AndroidService datasource) {
		this.androidService = datasource;
	}

	@Override
	public Android getRowData(String rowKey) {
		return androidService.findOne(Long.parseLong(rowKey));	
	}

	@Override
	public Object getRowKey(Android android) {
		return android.getId();
	}

	@Override
	public List<Android> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		PageRequest pageRequest = new PageRequest(first/pageSize, pageSize);
		Page<Android> data = androidService.filter(pageRequest, filters);		 
		this.setRowCount((int) data.getTotalElements());
		this.setPageSize(pageSize);		
		return data.getContent();
	}
}
