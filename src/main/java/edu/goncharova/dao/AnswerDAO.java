package edu.goncharova.dao;

import edu.goncharova.connection.HibernateSessionFactoryUtil;
import edu.goncharova.entities.Answer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.util.List;

import static edu.goncharova.connection.HibernateSessionFactoryUtil.getSessionFactory;

public class AnswerDAO implements DAO<Answer, Integer> {
    private static final Logger LOG = LogManager.getLogger(AnswerDAO.class);

    @Override
    public Answer saveOrUpdate(Answer answer) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(answer);
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
    public List<Answer> findAll() {
        List<Answer> result;
        final String query = "from Answer";
        try (final Session session = getSessionFactory().openSession()) {
            final Query list = session.createQuery(query);
            final Transaction transaction = session.beginTransaction();

            result = list.list();
            transaction.commit();
        }
        return result;
    }

    @Override
    public Answer find(Integer answerId) {
        return getSessionFactory().openSession().get(Answer.class, answerId);
    }

    @Override
    public void delete(Answer question) {

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

    public List<Answer> findAll(Integer id) {
        List<Answer> result;
        final String query = "from Answer a where a.questionId=:questionId";
        try (final Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            final Query sessionQuery = session.createQuery(query);
            sessionQuery.setInteger("questionId", id);
            final Transaction transaction = session.beginTransaction();

            result = sessionQuery.list();
            transaction.commit();
        }
        return result;
    }

    @Override
    public Answer getByField(String answerName) {
        Answer answer;
        try (Session session = getSessionFactory().openSession()) {
            Query query = session.createQuery("from Answer e where e.answer=:answer")
                    .setParameter("answer", answerName);
            answer = (Answer) query.uniqueResult();
        } catch (NoResultException e) {
            LOG.info("\n Exception. Rolling back transaction.\n", e);
            answer = null;
        }
        return answer;
    }
}
