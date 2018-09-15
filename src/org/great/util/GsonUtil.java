package org.great.util;

import com.google.gson.Gson;

public class GsonUtil {
	
	public static GsonUtil gsonUtil;
	private static Gson gson;
	
	private GsonUtil(){
		gson=new Gson();
	}
	
	public synchronized static GsonUtil getInstance(){
		if(gsonUtil==null){
			gsonUtil=new GsonUtil();
		}
		return gsonUtil;
	}
	
	public static Gson getGson() {
		
		return gson;
	}

}
