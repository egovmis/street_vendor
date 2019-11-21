package com.sv.app.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DatabaseSequenceCreator {
   private static final String CREATE_SEQ_QUERY = "CREATE SEQUENCE %s";

   @PersistenceContext
   private EntityManager entityManager;

   @Transactional(propagation = Propagation.REQUIRES_NEW)
   public void createSequence(String sequenceName) {
       entityManager.unwrap(Session.class)
               .createSQLQuery(String.format(CREATE_SEQ_QUERY,sequenceName))
               .executeUpdate();
   }
}