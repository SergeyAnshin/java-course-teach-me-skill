package org.sergey.ans.dao.impl.hibernatestorage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.sergey.ans.dao.CalculationResultDAO;
import org.sergey.ans.entity.CalculationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository(value = "calculationResultHibernateStorage")
@Transactional
public class CalculationResultHibernateStorage implements CalculationResultDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public CalculationResultHibernateStorage(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean exists(CalculationResult calculationResult) {
        Session session = sessionFactory.openSession();
        Query<Long> query = session.createQuery("SELECT COUNT(cr.id) " +
                "FROM CalculationResult cr " +
                "WHERE cr.creationDateTime = :creationDateTime " +
                        "AND cr.expression = :expression " +
                        "AND cr.result = :result " +
                        "AND cr.user = :user", Long.class);
        query.setParameter("creationDateTime", calculationResult.getCreationDateTime());
        query.setParameter("expression", calculationResult.getExpression());
        query.setParameter("result", calculationResult.getResult());
        query.setParameter("user", calculationResult.getUser());
        Long count = query.getSingleResult();
        session.close();
        return count > 0;
    }

    @Override
    public boolean save(CalculationResult calculationResult) {
        Session session = sessionFactory.openSession();
        Serializable resultId = session.save(calculationResult);
        session.close();
        return resultId != null;
    }

    @Override
    public List<CalculationResult> findAll() {
        Session session = sessionFactory.openSession();
        Query<CalculationResult> query = session.createQuery("SELECT cr FROM CalculationResult cr", CalculationResult.class);
        List<CalculationResult> calculationResults = query.getResultList();
        session.close();
        return calculationResults;
    }
}
