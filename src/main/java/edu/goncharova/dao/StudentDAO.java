//package edu.goncharova.dao;
//
//import edu.goncharova.entities.Answer;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//
//import java.util.List;
//
//import static edu.goncharova.connection.HibernateSessionFactoryUtil.getSessionFactory;
//
//public class StudentDAO implements DAO<Answer,Integer> {
//    private static final Logger LOG = LogManager.getLogger(StudentDAO.class);
//
//
//    @Override
//    public Answer saveOrUpdate(Answer answer) {
//        Transaction transaction = null;
//        try (Session session = getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.saveOrUpdate(answer);
//            transaction.commit();
//        } catch (Exception e) {
//            LOG.info("\n Exception. Rolling back transaction.\n", e);
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public List<Answer> findAll() {
//        List<Answer> result;
//        final String query = "from Answer";
//        try (final Session session = getSessionFactory().openSession()) {
//            final Query list = session.createQuery(query);
//            final Transaction transaction = session.beginTransaction();
//
//            result = list.list();
//            transaction.commit();
//        }
//        return result;
//    }
//
//    @Override
//    public Answer find(Integer answerId) {
//        return getSessionFactory().openSession().get(Answer.class, answerId);
//    }
//
//    @Override
//    public void delete(Answer answer) {
//        Transaction transaction = null;
//        try (Session session = getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.delete(answer);
//            transaction.commit();
//        } catch (Exception e) {
//            LOG.info("\n Exception. Rolling back transaction.\n", e);
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//    }
//}
