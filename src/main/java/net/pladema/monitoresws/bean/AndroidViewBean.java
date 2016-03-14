package net.pladema.monitoresws.bean;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;

import net.pladema.monitoresws.entity.Android;
import net.pladema.monitoresws.repository.lazymodel.LazyAndroidDataModel;
import net.pladema.monitoresws.service.AndroidService;

@ViewScoped
@ManagedBean("androidView")
public class AndroidViewBean extends CommonView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4630506639933453408L;

	@Autowired
	private AndroidService androidService;
	
	private LazyDataModel<Android> model;
	//private List<Android> filteredDevices;

	@PostConstruct
	public void init(){
		model = new LazyAndroidDataModel(androidService);
	}
	
	public void setAndroidService(AndroidService androidService) {
		this.androidService = androidService;
	}

	public LazyDataModel<Android> getModel() {
		return model;
	}

	public void setModel(LazyDataModel<Android> model) {
		this.model = model;
	}

}
