/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.fursan.pdf.extract.service;

import com.naveed.fursan.pdf.extract.entities.AgentAnalysis;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author nmrehman
 */
public class AgentAnalysisService {

    EntityManagerFactoryUtil util = EntityManagerFactoryUtil.getInstance();
    EntityManagerFactory emf = util.getEntityManagerFactory();
    private EntityManager em;
    private static final int batchSize = 300;

    public AgentAnalysisService() {
        //emf = Persistence.createEntityManagerFactory("dbunit");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public AgentAnalysis save(AgentAnalysis entity) {
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

    public List<AgentAnalysis> save(List<AgentAnalysis> entities) {
        //final List<AgentAnalysis> savedEntities = new ArrayList<>(entities.size());        
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            int i = 0;
            for (AgentAnalysis entity : entities) {
                entityManager.persist(entity);
                //savedEntities.add(persistOrMerge(entity, entityManager));
                i++;
                if (i % batchSize == 0) {
                    entityManager.flush(); // Flush a batch of inserts and release memory.
                    entityManager.clear();
                }
            }
        } finally {
            entityManager.getTransaction().commit();
        }
        return entities;
    }

    private AgentAnalysis persistOrMerge(AgentAnalysis t, EntityManager entityManager) {
        if (t.getId() == null) {
            entityManager.persist(t);
            return t;
        } else {
            return entityManager.merge(t);
        }
    }

    public AgentAnalysis find(Long id) {
        return (AgentAnalysis) getEntityManager().find(AgentAnalysis.class, id);
    }

    public List<AgentAnalysis> findAll() {
        return getEntityManager().createQuery("SELECT e FROM AgentAnalysis " + " e").getResultList();
    }

    public AgentAnalysis update(AgentAnalysis entity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            AgentAnalysis merge = entityManager.merge(entity);
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
            AgentAnalysis entity = entityManager.find(AgentAnalysis.class, id);
            entityManager.remove(entity);
            entityManager.flush();
        } finally {
            entityManager.getTransaction().commit();
        }
    }

    public AgentAnalysis getAgentOutBalance(String CU_NO) {
        Query query = getEntityManager().createQuery("SELECT e FROM AgentAnalysis " + " e WHERE e.CU_NO = :arg");
        query.setParameter("arg", CU_NO);
        return (AgentAnalysis) query.getSingleResult();
    }

}
