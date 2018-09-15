package org.great.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;

import org.apache.struts2.interceptor.SessionAware;
import org.great.util.ImageUtil;


public class ImageAction implements SessionAware{
	
	public Map<String,Object> session;
	private InputStream inputStream;
	private String flag="success";
	
	public String changeImage() {
		Map<String, BufferedImage> imageb = ImageUtil.createImage();

		Iterator map1it = imageb.entrySet().iterator();

		while (map1it.hasNext()) {
			
			Map.Entry<String, BufferedImage> entry = (Entry<String, BufferedImage>) map1it.next();

			String imageCode = entry.getKey();
			
			System.out.println("验证码: " + imageCode);
			
			BufferedImage bImage = entry.getValue();

			try {
				
				inputStream=ImageUtil.getInputStream(bImage);
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		session=arg0;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
}
