package net.pladema.monitoresws.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.pladema.monitoresws.entity.Device;
import net.pladema.monitoresws.entity.Frame;
import net.pladema.monitoresws.entity.SmartphoneDetection;


public class ParseUtils {
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	public static Calendar ParseTimestamp(String ts){		
		try {
			Calendar cal = sdf.getCalendar();
			cal.setTime(sdf.parse(ts));
			return cal;
		} catch (ParseException e1) {
			return null;
		}		
	}
	
	/**
	 * 
	 * @param data as int id_scanner, Calendar timestamp, String mac, int signal, String src_device_type, String protocol
	 * @return
	 */
	public static Device ObtenerDevice(String data){
		String[] sp = data.split("\\|");		
		Calendar ts = ParseUtils.ParseTimestamp(sp[1]);		
		if(ts == null){
			return null;
		}		
		Device device = new Device(Integer.valueOf(sp[0]),ts, sp[2], Integer.valueOf(sp[3]), sp[4], sp[5]);
		return device;
	}
	
	public static Frame ObtenerFrame(String data){
		String[] sp = data.split("\\|");
		Calendar ts = ParseUtils.ParseTimestamp(sp[1]);
		if(ts == null){
			return null;
		}	
		Frame frame = new Frame(Integer.valueOf(sp[0]),ts, sp[2], sp[3], Integer.valueOf(sp[4]), sp[5], sp[6], sp[7], sp[8]);
		return frame;
		
	}
	
	public static SmartphoneDetection ObtenerSmartphoneDetection(String data){
		String[] sp = data.split("\\|");
		Calendar ts = ParseUtils.ParseTimestamp(sp[0]);
		if(ts == null ){
			return null;
		}	
		SmartphoneDetection detection = new SmartphoneDetection(ts, sp[1], sp[2], Integer.valueOf(sp[3]), sp[4], sp[5], Double.valueOf(sp[7]), Double.valueOf(sp[8]));
		return detection;
		
	}

}
