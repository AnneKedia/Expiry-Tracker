package com.bit.expirytracker.et.utils;

import com.bit.expirytracker.et.entity.Product;
import java.text.SimpleDateFormat;  
import java.util.Date;

  


public class DaysLeft {
	private int days;
	
	public int calculateDays(Product product)throws Exception
	{
        String expdate = product.getExpiry_date();
        Date todate = new Date();
        Date expiry = new SimpleDateFormat("yyyy-MM-dd").parse(expdate);
       // System.out.println(expdate+"\t"+d +"\t"+d.getTime());
       // System.out.println(todate);
        days = (int) ((expiry.getTime() - todate.getTime()) / (1000*60*60*24));
        System.out.println("Days Left :" +days);
        return days;
	}

}
