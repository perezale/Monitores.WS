package net.pladema.monitoresws.app;

import org.springframework.core.convert.converter.Converter;

import net.pladema.monitoresws.entity.AndroidPK;

public class AndroidPKConverter implements Converter<String, AndroidPK> {

	@Override
	public AndroidPK convert(String id) {		
		AndroidPK output = new AndroidPK();
		if(!id.isEmpty()){
			String[] split = id.split("_");
			if(split.length != 2) return output;
			output.setHistoryDate(split[0]);
			output.setVehicleId(split[1]);
		}
		return output;
	}
}