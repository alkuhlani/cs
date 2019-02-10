/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arslorem.hamzah.ejbs;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author user
 */
@Stateless
public class DataAccessObject {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "csPU")
    private EntityManager em;

    public void create(Object o) {
        em.persist(o);
    }

    public <T, I> T find(I id, Class<T> clazz) {
        return em.find(clazz, id);
    }

    public <T> T findBy(String q, Class<T> clazz, Long id) {
        TypedQuery<T> tq = em.createNamedQuery(q, clazz);
        tq.setParameter("id", id);
        return tq.getSingleResult();
    }

    public <T> T findOne(String namedQuery, Class<T> entityClass, Object... params) {
        try {
            TypedQuery<T> typedQuery = em.createNamedQuery(namedQuery, entityClass);
            for (int i = 0; i < params.length; i += 2) {
                typedQuery.setParameter(params[i].toString(), params[i + 1]);
            }
            return typedQuery.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public <T> List<T> find(String namedQuery, Class<T> entityClass, Object... params) {
        try {
            TypedQuery<T> typedQuery = em.createNamedQuery(namedQuery, entityClass);
            for (int i = 0; i < params.length; i += 2) {
                typedQuery.setParameter(params[i].toString(), params[i + 1]);
            }
            return typedQuery.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public <T> T findBy(String q, Class<T> clazz, Long id, Long id1) {
        TypedQuery<T> tq = em.createNamedQuery(q, clazz);
        tq.setParameter("id", id);
        tq.setParameter("id1", id1);
        return tq.getSingleResult();
    }

    public Object findSingleResult(String namedQuery, Class classs, Entry<String, Object>... params) {
        try {
            em.joinTransaction();
            TypedQuery typedQuery = em.createNamedQuery(namedQuery, classs);
            for (Entry<String, Object> e : params) {
                typedQuery.setParameter(e.getKey(), e.getValue());
            }
            return typedQuery.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List findAll(String q, Class clazz) {
        TypedQuery tq = em.createNamedQuery(q, clazz);
//        tq.getResultList().forEach(System.out::println);
//        Query query = em.createNamedQuery("SmsProduct.findAll2",clazz);
//        List<String> resultList = query.getResultList();
//        resultList.forEach(System.out::println);
        return (List) tq.getResultList();
    }

    public List findAll2(String q, Class clazz) {
        TypedQuery tq = em.createNamedQuery(q, clazz);
//        tq.getResultList().forEach(System.out::println);
//        List<Object[]> resultList = tq.getResultList();
//        Map<Long, Long> resultMap = new HashMap<Long, Long>(resultList.size());
//        for (Object[] result : resultList) {
//            resultMap.put((Long) result[0], (Long) result[1]);
////            System.out.println(""+resultMap.get((Long) result[0]));
//        }
//        System.out.println("tq.getResultList().get(0)"+tq.getResultList().get(0)[0]);
//        Query query = em.createNamedQuery("SmsProduct.findAll2",clazz);
//        List<String> resultList = query.getResultList();
//        resultList.forEach(System.out::println);
        return (List) tq.getResultList();
    }
//    public List findAllContent(String q, Class clazz) {
//        TypedQuery tq = em.createNamedQuery(q, clazz);
////        tq.getResultList().forEach(System.out::println);
////        Query query = em.createNamedQuery("SmsProduct.findAll2",clazz);
////        List<String> resultList = query.getResultList();
////        resultList.forEach(System.out::println);
//        return (List) tq.getResultList();
//    }

    public List findAll(String q, Class clazz, Long id) {
        TypedQuery tq = em.createNamedQuery(q, clazz);
        tq.setParameter("id", id);
        return (List) tq.getResultList();
    }

    public List findAll(String q, Class clazz, int id, String id2) {
        TypedQuery tq = em.createNamedQuery(q, clazz);
        tq.setParameter("commandId", id);
        tq.setParameter("status", id2);
        return (List) tq.getResultList();
    }

    public List findAll(String q, Class clazz, int id, String id2, String id3) {
        TypedQuery tq = em.createNamedQuery(q, clazz);
        tq.setParameter("commandId", id);
        tq.setParameter("status", id2);
        tq.setParameter("shortCode", id3);
        return (List) tq.getResultList();
    }

    public List findAll(String q, Class clazz, int id, String id2, String id3, String id4) {
        TypedQuery tq = em.createNamedQuery(q, clazz);
        tq.setParameter("commandId", id);
        tq.setParameter("status", id2);
        tq.setParameter("shortCode", id3);
        tq.setParameter("otherMobile", id4);
        return (List) tq.getResultList();
    }

    public List findAll(String q, Class clazz, int id) {
        TypedQuery tq = em.createNamedQuery(q, clazz);
        tq.setParameter("commandId", id);
        return (List) tq.getResultList();
    }

    public <T> List<T> findThem(String namedQuery, Class<T> clazz, Map.Entry<String, Object>... params) {
        em.joinTransaction();
        TypedQuery<T> typedQuery = em.createNamedQuery(namedQuery, clazz);
        for (Map.Entry<String, Object> e : params) {
            typedQuery.setParameter(e.getKey(), e.getValue());
        }
        return typedQuery.getResultList();
    }

    public List findAll(String q, Class clazz, Long id, Long id1) {
        TypedQuery tq = em.createNamedQuery(q, clazz);
        tq.setParameter("id", id);
        tq.setParameter("id1", id1);
        return (List) tq.getResultList();
    }

    public List findAll(String q, Class clazz, Long id, Character id1) {
        TypedQuery tq = em.createNamedQuery(q, clazz);
        tq.setParameter("id", id);
        tq.setParameter("id1", id1);
        return (List) tq.getResultList();
    }

    public List findAll(String q, Class clazz, Long id, Long id1, Long id2) {
        TypedQuery tq = em.createNamedQuery(q, clazz);
        tq.setParameter("id", id);
        tq.setParameter("id1", id1);
        tq.setParameter("id2", id2);
        return (List) tq.getResultList();
    }

    public List findAll(String q, Class clazz, Long id, Long id1, Long id2, Long id3) {
        TypedQuery tq = em.createNamedQuery(q, clazz);
        tq.setParameter("id", id);
        tq.setParameter("id1", id1);
        tq.setParameter("id2", id2);
        tq.setParameter("id3", id3);
        return (List) tq.getResultList();
    }

    public List findAll(String q, Class clazz, Long id, Long id1, Long id2, Character id4) {
        TypedQuery tq = em.createNamedQuery(q, clazz);
        tq.setParameter("id", id);
        tq.setParameter("id1", id1);
        tq.setParameter("id2", id2);
        tq.setParameter("id3", id4);
        return (List) tq.getResultList();
    }

    public List findAll(String q, Class clazz, String X) {
        TypedQuery tq = em.createNamedQuery(q, clazz);
        tq.setParameter("id", X);
        return (List) tq.getResultList();
    }

    public <T> T findOneResult(String namedQuery, Class<T> clazz, Object... params) {
        try {
            TypedQuery<T> typedQuery = em.createNamedQuery(namedQuery, clazz);
            for (int i = 0; i < params.length; i += 2) {
                typedQuery.setParameter(params[i].toString(), params[i + 1]);
            }
            return typedQuery.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public void delete(Object o) {
        em.remove(em.merge(o));
    }

    public void update(Object o) {
        em.merge(o);
    }

//    public SecurityUser findByUserNamePassword(String userName, String password) {
//        System.out.println("UserService : findByUserNamePassword()" + userName + "," + password);
//        return findOne("SecurityUser.findByUserNamePassword", SecurityUser.class, "userName", userName, "password", password);
//    }

    public class sl {

        public String n;

        public Long l;

        public String getN() {
            return n;
        }

        public void setN(String n) {
            this.n = n;
        }

        public Long getL() {
            return l;
        }

        public void setL(Long l) {
            this.l = l;
        }

    }
}
