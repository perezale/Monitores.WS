package net.pladema.monitoresws.app.converters;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.core.convert.converter.Converter;

import net.pladema.monitoresws.entity.AndroidPK;

public class AndroidPKConverter implements Converter<String, AndroidPK> {

	@Override
	public AndroidPK convert(String id) {		
		AndroidPK output = new AndroidPK();
		if(!id.isEmpty()){
			String[] split = id.split("_");
			if(split.length != 2) return output;
			String history = "";
			try {
				history = URLDecoder.decode(split[0], "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			output.setHistoryDate(history);
			output.setVehicleId(split[1]);
		}
		return output;
	}
}