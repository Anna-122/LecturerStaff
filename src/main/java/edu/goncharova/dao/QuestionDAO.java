package edu.goncharova.dao;

import edu.goncharova.entities.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.util.List;

import static edu.goncharova.connection.HibernateSessionFactoryUtil.getSessionFactory;

public class QuestionDAO implements DAO<Question,Integer> {


    private static final Logger LOG = LogManager.getLogger(QuestionDAO.class);

    @Override
    public Question saveOrUpdate(Question question) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(question);
            transaction.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction.\n", e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public List<Question> findAll() {
        List<Question> result;
        final String query = "from Question";
        try (final Session session = getSessionFactory().openSession()) {
            final Query list = session.createQuery(query);
            final Transaction transaction = session.beginTransaction();

            result = list.list();
            transaction.commit();
        }
        return result;
    }

    @Override
    public Question find(Integer questionId) {
        return getSessionFactory().openSession().get(Question.class, questionId);
    }

    @Override
    public void delete(Question question) {

        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(question);
            transaction.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction.\n", e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    @Override
    public Question getByField(String questionName) {
        Question question;
        try (Session session = getSessionFactory().openSession()) {
            Query query = session.createQuery("from Question e where e.question=:question")
                    .setParameter("question", questionName);
            question = (Question) query.uniqueResult();
        } catch (NoResultException e) {
            LOG.info("\n Exception. Rolling back transaction.\n", e);
            question = null;
        }
        return question;
    }
}

