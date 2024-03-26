package com.sof3011.hangnt.B10_Hibernate.repository;

import com.sof3011.hangnt.B10_Hibernate.config.HibernateConfig;
import com.sof3011.hangnt.B10_Hibernate.entity.Category1;
import org.hibernate.Session;

import java.util.List;

public class CategoryRepository {

    private Session s;

    public CategoryRepository() {
        // Mo phien session 1 lan
        s = HibernateConfig.getFACTORY().openSession();
    }

    // CRUD : CREATE/READ/UPDATE/DELETE
    // GET ALL => SELECT
    public List<Category1> getAll() {
        List<Category1> lists = s.createQuery("FROM Category1").list();
        return lists;
    }

    // GET ONE: SELECT * FROM .. WHERE id =??
    public Category1 getOne(Long id) {
        return s.find(Category1.class, id);
    }

    // Add: save/saveorupdate/persist
    public void add(Category1 c){
        try{
            // B1: bat dau transasion
            s.beginTransaction().begin();
            // B2: Add doi tuong
            s.persist(c);
            // B3: commit sau khi add xong
            s.beginTransaction().commit();
        }catch (Exception e){
            // Khi add fail => rollback tro ve trang thai ban dau
            s.beginTransaction().rollback();
        }
    }

    // Update: saveorupdate/merge
    public void update(Category1 c){
        try{
            // B1: bat dau transasion
            s.beginTransaction().begin();
            // B2: update doi tuong
            s.merge(c);
            // B3: commit sau khi add xong
            s.beginTransaction().commit();
        }catch (Exception e){
            // Khi add fail => rollback tro ve trang thai ban dau
            s.beginTransaction().rollback();
        }
    }

    // Delete: delete
    public void delete(Category1 c){
        try{
            // B1: bat dau transasion
            s.beginTransaction().begin();
            // B2: delete doi tuong
            s.delete(c);
            // B3: commit sau khi add xong
            s.beginTransaction().commit();
        }catch (Exception e){
            // Khi add fail => rollback tro ve trang thai ban dau
            s.beginTransaction().rollback();
        }
    }

    public static void main(String[] args) {
        System.out.println(new CategoryRepository().getAll());
    }
}
