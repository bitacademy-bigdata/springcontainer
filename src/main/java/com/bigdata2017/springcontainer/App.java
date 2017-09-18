package com.bigdata2017.springcontainer;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App {
    public static void main( String[] args ){
    	//testBeanFactory();
    	testApplicationContext();
    }
    
    public static void testApplicationContext() {
    	ApplicationContext ac =
    		new ClassPathXmlApplicationContext( "config/applicationContext.xml" );
    	
    	//같은 타입의 빈이 1개 이상 생성 된 경우
    	//타입으로 가져오면 예외 발생
    	//User user1 = ac.getBean( User.class );
    	
    	// id로 가져오기
    	User user1 = (User)ac.getBean( "user" );
    	// name으로 가져오기
    	User user2 = (User)ac.getBean( "usr" );
    	
    	// singleton
    	System.out.println( user1 == user2 );
    	
    	// 
    	User user4 = (User)ac.getBean( "user4" );
    	System.out.println( user1 == user4 );
    	
    	// User(Long, String) 생성된 빈 가져오기
    	User user5 = (User)ac.getBean( "user5" );
    	System.out.println( user5 );

    	// setter를 통한 빈 설정
    	User user6 = (User)ac.getBean( "user6" );
    	System.out.println( user6 );
    	
    }
    
    public static void testBeanFactory() {
    	BeanFactory bf =
    		new XmlBeanFactory(new ClassPathResource("config/applicationContext.xml"));
    
    	// 타입으로 가져오기
    	User user = bf.getBean( User.class );
    	System.out.println( user.getName() );
    	
    	//id로 가져오기
    	user = (User)bf.getBean( "user" );
    	System.out.println( user.getName() );
    	
    	// 해당 id의 빈이 존재하지 않는 경우 -> Exception
       	// user = (User)bf.getBean( "usr" );
    	// System.out.println( user.getName() );

    	BeanFactory bf2 =
        		new XmlBeanFactory(new ClassPathResource("config/applicationContext2.xml"));
    	user = bf2.getBean( User.class );
    	System.out.println( user.getName());
    	user = (User)bf2.getBean( "user" );
    	System.out.println( user.getName());
    }
}
