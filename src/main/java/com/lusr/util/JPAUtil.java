package com.lusr.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ownlove on 2018/12/19.
 */
public class JPAUtil {
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("jpa");
    }
    private JPAUtil(){}

    public static EntityManager getManager(){
        return emf.createEntityManager();
    }

    /**
     * 保存一个Entity
     * @param obj
     * @param <T>
     */
    public static <T> void save(T obj){
        EntityManager em = null;
        try{
            em = getManager();
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        }catch (Exception e){

        }finally {
            if(em !=null){
                em.close();
            }
        }
    }

    /**
     * 直接修改后，即可送到这里
     * @param obj
     * @param <T>
     */
    public static <T>void update(T obj){
        EntityManager em = null;
        try{
            em = getManager();
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(em !=null){
                em.close();
            }
        }
    }

    /**
     * 通过Class字节码和ID
     * @param clz
     * @param id
     * @param <T>
     * @return
     */
    public static <T> T find(Class clz,Serializable id){
        EntityManager em =null;
        try{
            em = JPAUtil.getManager();
            em.getTransaction().begin();
            T obj = (T) em.find(clz,id);
            em.getTransaction().commit();
            return obj;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(em !=null){
                em.close();
            }
        }
        return null;
    }

    /**
     * 通过该类的字节码，查询出本类的所有Entity对象
     * @param clz
     * @param <T>
     * @return
     */
    public  static <T> List<T> findAll(Class clz){
        EntityManager em =null;
        try{
            em = JPAUtil.getManager();
            List<T> list = null;
            String name = clz.getName();
            String sql = "select a from "+ name+" a";
            Query query = em.createQuery(sql);
            list = (List<T>) query.getResultList();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(em !=null){
                em.close();
            }
        }
        return null;
    }

    /**
     * 通过主键删除
     * @param obj
     * @param <T>
     */
    public static <T>void delete(T obj){
        EntityManager em =null;
        try{
            em = JPAUtil.getManager();
            em.getTransaction().begin();
            em.remove(em.contains(obj) ? obj : em.merge(obj));
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(em !=null){
                em.close();
            }
        }
    }

    public static void delete(Class clz,Serializable s){
        EntityManager em =null;
        try{
            em = JPAUtil.getManager();
            em.getTransaction().begin();
            em.remove(em.find(clz,s));
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(em !=null){
                em.close();
            }
        }
    }

}



