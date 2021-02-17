package hw05;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class EntityDAO<E, K> {
    private SessionFactory sessionFactory;
    private Class<E> entityClass;
    private Class<K> keyType;

    public EntityDAO(Class<E> entityClass, Class<K> keyType) {
        this.entityClass = entityClass;
        this.keyType = keyType;
        sessionFactory = Main.getSessionFactory();
    }

    public E findById(K id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            E entity = session.find(entityClass, id);
            session.getTransaction().commit();
            return entity;
        }
    }

    public List<E> findAll() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<E> res = session.createQuery("from " + entityClass.getSimpleName(), entityClass).list();
            session.getTransaction().commit();
            return res;
        }
    }

    public void create(E entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        }
    }

    public boolean updateEntity(E entity) {
        try (Session session = sessionFactory.openSession()) {
            try {
                entity.getClass().getDeclaredField("id");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
            return true;
        }
    }

    public boolean deleteEntityById(K key) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            E entity = session.find(entityClass, key);
            if(entity == null){
                return false;
            }
            session.delete(entity);
            session.getTransaction().commit();
            return true;
        }
    }
}
