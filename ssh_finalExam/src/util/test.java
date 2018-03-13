package util;

import javafx.application.Application;
import org.apache.poi.ss.formula.functions.T;
import org.hibernate.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.*;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class test {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return this.sessionFactory.openSession();
    }

    public static void main(String[] args) throws HibernateException, SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        test t = (test) context.getBean("test");
        Session session = t.getSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(" from SignUpStatus s,Exam e where 1=1 and s.exam.exam_id =e.exam_id");
        List list = query.list();
        tx.commit();
    }
}
