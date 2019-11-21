package com.sv.app.util;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DatabaseSequenceProvider {

   private static final String NEXT_SEQ_QUERY = "SELECT NEXTVAL (%s) AS NEXTVAL";

   @PersistenceContext
   private EntityManager entityManager;

   @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW, noRollbackFor = SQLGrammarException.class)
   public Serializable getNextSequence(String sequenceName) throws SQLGrammarException {
       return (Serializable) entityManager.unwrap(Session.class)
               .createSQLQuery(String.format(NEXT_SEQ_QUERY, sequenceName))
               .uniqueResult();
   }
}
