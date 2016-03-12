package org.ahhn.com.manytomany;

import org.ahhn.com.onetoone.foreign.Department;
import org.ahhn.com.onetoone.foreign.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

/**
 * Created by XJX on 2016/3/11.
 */
public class HibernateTest {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Before
	public void init() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry =
				new ServiceRegistryBuilder().applySettings(configuration.getProperties())
						.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}

	@After
	public void destroy() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void testGet() {
		Catagory catagory = (Catagory) session.get(Catagory.class, 3);
		System.out.println(catagory.getName());

		Set<Item> items = catagory.getItems();
		System.out.println(items.iterator().next().getName());

	}

	@Test
	public void testInsert() {
		Catagory catagory1 = new Catagory();
		catagory1.setName("C-AA");
		Catagory catagory2 = new Catagory();
		catagory2.setName("C-BB");

		Item item1 = new Item();
		item1.setName("I-AA");
		Item item2 = new Item();
		item2.setName("I-BB");

		catagory1.getItems().add(item1);
		catagory1.getItems().add(item2);
		catagory2.getItems().add(item1);
		catagory2.getItems().add(item2);

		item1.getCatagories().add(catagory1);
		item1.getCatagories().add(catagory2);
		item2.getCatagories().add(catagory1);
		item2.getCatagories().add(catagory2);

		session.save(catagory1);
		session.save(catagory2);
		session.save(item1);
		session.save(item2);
	}

}
