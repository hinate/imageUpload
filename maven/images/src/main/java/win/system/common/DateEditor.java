package win.system.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.PropertiesEditor;

public class DateEditor extends PropertiesEditor{
	@Override 
    public void setAsText(String text){
		if (text == null || "".equals(text.trim())) {  
			setValue(null);
			return ;
        }
		text = text.trim();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		dateFormat.setLenient(false);
		
		if(text.length() > 10){
			try {
				if(text.length() > 16){
					setValue(dateFormat.parse(text));
				}else{
					setValue(dateFormat1.parse(text));
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else{
			try {
				setValue(sdf.parse(text));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
    }  
   
    @Override 
    public String getAsText() {  
        return getValue().toString();  
    }
}