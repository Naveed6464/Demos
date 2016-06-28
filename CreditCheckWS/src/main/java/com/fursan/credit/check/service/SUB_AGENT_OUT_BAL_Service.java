/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fursan.credit.check.service;

import com.fursan.credit.check.entities.SUB_AGENT_OUT_BAL;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class SUB_AGENT_OUT_BAL_Service {

    EntityManagerFactory emf = null;
    private EntityManager em;

    public SUB_AGENT_OUT_BAL_Service() {
        emf = Persistence.createEntityManagerFactory("dbunit");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public SUB_AGENT_OUT_BAL save(SUB_AGENT_OUT_BAL entity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.flush();
        } finally {
            entityManager.getTransaction().commit();
        }
        return entity;
    }

    public SUB_AGENT_OUT_BAL find(Long id) {
        return (SUB_AGENT_OUT_BAL) getEntityManager().find(SUB_AGENT_OUT_BAL.class, id);
    }

    public List<SUB_AGENT_OUT_BAL> findAll() {
        return getEntityManager().createQuery("SELECT e FROM SUB_AGENT_OUT_BAL " + " e").getResultList();
    }

    public SUB_AGENT_OUT_BAL update(SUB_AGENT_OUT_BAL entity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            SUB_AGENT_OUT_BAL merge = entityManager.merge(entity);
            entityManager.flush();
            return merge;
        } finally {
            entityManager.getTransaction().commit();
        }
    }

    public void delete(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            SUB_AGENT_OUT_BAL entity = entityManager.find(SUB_AGENT_OUT_BAL.class, id);
            entityManager.remove(entity);
            entityManager.flush();
        } finally {
            entityManager.getTransaction().commit();
        }
    }

    public SUB_AGENT_OUT_BAL getAgentOutBalance(String CU_NO) {
        Query query = getEntityManager().createQuery("SELECT e FROM SUB_AGENT_OUT_BAL " + " e WHERE e.CU_NO = :arg");
        query.setParameter("arg", CU_NO);
        return (SUB_AGENT_OUT_BAL) query.getSingleResult();
    }
}
