package org.great.daoFactory;

import dbDao.BaseInterface;

public class DaoFactory {
	
	
	public static BaseInterface getInstance(String className) {
		
		Class<?> c=null;
		BaseInterface baseInterface=null;		
		try
		{
			c= Class.forName(className);
			baseInterface = (BaseInterface)c.newInstance();
			
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baseInterface;
	}
}
