package org.care.dao;

import org.care.context.MyApplicationContext;
import org.care.model.Sitter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.logging.Logger;

public class SitterDAO extends MemberDAO<Sitter> {

    @Override
    public Integer create(Sitter obj) {
        Integer id = null;
        try {
            Session session = MyApplicationContext.getHibSession();
            Transaction transaction = session.beginTransaction();

            id = (Integer) session.save(obj);

            transaction.commit();

        } catch (Exception e) {
            Logger.getLogger(SitterDAO.class.getName()).severe("Can't insert sitter: " + e);
        }
        return id;
    }

    @Override
    public void update(Sitter obj) {
        try {
            Session session = MyApplicationContext.getHibSession();
            Transaction transaction = session.beginTransaction();

            session.update(obj);

            transaction.commit();

        } catch (Exception e) {
            Logger.getLogger(SitterDAO.class.getName()).severe("Can't update sitter: " + e);
        }
    }

    @Override
    public boolean delete(Serializable id) {
        return super.delete(id);
    }

    @Override
    public Sitter get(Serializable id) {
        Sitter sitter = null;

        try {
            Session session = MyApplicationContext.getHibSession();
            sitter = session.get(Sitter.class, id);

        } catch (Exception e) {
            Logger.getLogger(SitterDAO.class.getName()).info("Can't retrieve sitter: " + e);
        }
        return sitter;
    }
}
