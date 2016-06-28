/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.fursan.pdf.extract.service;

import com.naveed.fursan.pdf.extract.entities.PdfDocument;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author nmrehman
 */
public class PdfDocumentService {

    EntityManagerFactoryUtil util = EntityManagerFactoryUtil.getInstance();
    EntityManagerFactory emf = util.getEntityManagerFactory();
    private EntityManager em;
    private static final int batchSize = 300;

    public PdfDocumentService() {
        //emf = Persistence.createEntityManagerFactory("dbunit");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public PdfDocument save(PdfDocument entity) {
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

    public List<PdfDocument> save(List<PdfDocument> entities) {
        final List<PdfDocument> savedEntities = new ArrayList<>(entities.size());
        int i = 0;
        EntityManager entityManager = emf.createEntityManager();
        for (PdfDocument t : entities) {
            entityManager.persist(t);
            savedEntities.add(persistOrMerge(t, entityManager));
            i++;
            if (i % batchSize == 0) {
                entityManager.flush(); // Flush a batch of inserts and release memory.
                entityManager.clear();
            }
        }
        return savedEntities;
    }

    private PdfDocument persistOrMerge(PdfDocument t, EntityManager entityManager) {
        if (t.getId() == null) {
            entityManager.persist(t);
            return t;
        } else {
            return entityManager.merge(t);
        }
    }

    public PdfDocument find(Long id) {
        return (PdfDocument) getEntityManager().find(PdfDocument.class, id);
    }

    public List<PdfDocument> findAll() {
        return getEntityManager().createQuery("SELECT e FROM PdfDocument " + " e").getResultList();
    }

    public PdfDocument update(PdfDocument entity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            PdfDocument merge = entityManager.merge(entity);
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
            PdfDocument entity = entityManager.find(PdfDocument.class, id);
            entityManager.remove(entity);
            entityManager.flush();
        } finally {
            entityManager.getTransaction().commit();
        }
    }

    public PdfDocument getByFileName(String fileName) {
        Query query = getEntityManager().createQuery("SELECT e FROM PdfDocument " + " e WHERE e.fileName = :arg");
        query.setParameter("arg", fileName);
        PdfDocument pdfDocument = null;
        try {
            pdfDocument = (PdfDocument) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Ex " + e);
        }
        return pdfDocument;
    }

}
