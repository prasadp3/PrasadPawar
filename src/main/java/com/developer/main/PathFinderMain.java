package com.developer.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.developer.business.BagPathFinder;

public class PathFinderMain {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		BagPathFinder finder = context.getBean(BagPathFinder.class);
		finder.execute();
		context.close();
	}

}
