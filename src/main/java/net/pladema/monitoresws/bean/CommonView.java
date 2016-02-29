package net.pladema.monitoresws.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonView {
	
	public String prettyPrintDate(Date timestamp){
		String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
		return formattedDate;
	}

}
