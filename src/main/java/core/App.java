package core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.artistdomain.ArtistRepository;

public class App {

	public static void main(String[] args) {
		// vanillaJavaMain();
		// xmlSpringMain();
		// javaSpringMain();
		// xmlAnnotationMain();
		javaAnnotationMain();
	}

	public static void vanillaJavaMain() {
		ArtistRepository aDao = new ArtistRepository();
		Connection connection = new Connection();
		aDao.setConnection(connection);
		System.out.println(aDao.getAll());
	}

	public static void xmlSpringMain() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("xmlSpring-cfg.xml");
		ArtistRepository aDao = (ArtistRepository) ac.getBean("prodArtistRepository");
		System.out.println(aDao.getAll());

		((AbstractApplicationContext) ac).close();
	}

	public static void javaSpringMain() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(JavaSpringConfig.class);
		ArtistRepository aDao = ac.getBean("localArtistRepository", ArtistRepository.class);
		System.out.println(aDao.getAll());

		((AbstractApplicationContext) ac).close();
	}

	public static void xmlAnnotationMain() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("xmlAnnotation-cfg.xml");
		ArtistRepository aDao = ac.getBean(ArtistRepository.class);
		System.out.println(aDao.getAll());

		((AbstractApplicationContext) ac).close();
	}

	public static void javaAnnotationMain() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(JavaAnnotationConfig.class);
		ArtistRepository aDao = ac.getBean(ArtistRepository.class);
		System.out.println(aDao.getAll());

		((AbstractApplicationContext) ac).close();
	}

}
