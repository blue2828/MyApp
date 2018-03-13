package dao;

import javafx.application.Application;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import vo.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository("baseDao")
public class BaseDao extends HibernateDaoSupport {
    @Resource(name = "sessionFactory")
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    /*@Resource
    private SessionFactory sessionFactory;*/

   /* public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }*/

    /*public Session getSession() {
        return this.sessionFactory.openSession();
    }*/

    /*public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BaseDao b = (BaseDao) context.getBean("baseDao");
        Session session = null;
        Transaction tx = null;
        try {
            session = b.getSession();
            tx = session.beginTransaction();
            Member mem=(Member)session.get(Member.class,4);
            Student stu=mem.getStudent();
            //session.save(member);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }*/
}
