package org.ahhn.com.onetoone.primary;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by XJX on 2016/3/11.
 */
public class HibernateTest {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Before
	public void init(){
//		Configuration configuration = new Configuration().configure();
//		ServiceRegistry serviceRegistry =
//				new ServiceRegistryBuilder().applySettings(configuration.getProperties())
//						.buildServiceRegistry();
//		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//
//		session = sessionFactory.openSession();
//		transaction = session.beginTransaction();
	}

	@After
	public void destroy(){
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void testGet2(){
		//在查询没有外键的实体对象时, 使用的左外连接查询, 一并查询出其关联的对象
		//并已经进行初始化.
		Manager manager=(Manager)session.get(Manager.class,1);
		System.out.println(manager.getMgrName());
		System.out.println(manager.getDepartment().getDeptName());
	}

	@Test
	public void testGet(){
		//1. 默认情况下对关联属性使用懒加载
		// 2. 所以会出现懒加载异常的问题.
		Department department=(Department)session.get(Department.class,1);
		System.out.println(department.getDeptName());

		//3. 查询 Manager 对象的连接条件应该是 department.manager_id = manager.manager_id
		//而不应该是 manager0_.MGR_ID=department1_.DEPT_ID
		Manager manager=department.getManager();
		System.out.println(manager.getMgrName());
	}

	@Test
	public void testInsert(){
		Department department=new Department();
		department.setDeptName("DEPT-BB");

		Manager manager=new Manager();
		manager.setMgrName("MGR-BB");

		department.setManager(manager);
		manager.setDepartment(department);

		session.save(manager);
		session.save(department);
	}
}
