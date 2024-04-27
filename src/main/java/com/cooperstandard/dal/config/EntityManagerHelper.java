package com.cooperstandard.dal.config;

import java.net.InetAddress;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;

/**
 *
 * @author Tiago D. Teixeira
 * @param <T>
 */
public class EntityManagerHelper<T> {

    private final Map<String, ThreadLocal<EntityManager>> sessions = new HashMap<>();
    private static final Logger LOG = Logger.getLogger("EntityManagerHelper");
    private static final Map<String, String> propMap = new HashMap();
    public final static int SALVAR = 0, ATUALIZAR = 1, DELETAR = 2;
    public final static String DERBYDB_PU = "DERBYDB_PU", ORACLE11G_PU = "ORACLE11G_PU", SQLSERVER_PU = "RAL";

    public EntityManagerHelper() {

    }

    public synchronized boolean getOperation(int operation_type, Object object, String persistence_unit) {
        EntityManager session = getSession(persistence_unit);
        try {
            session.getTransaction().begin();
            switch (operation_type) {
                case SALVAR:
                    LOG.info("Salvando registro no banco de dados");
                    session.persist(object);
                    session.getTransaction().commit();
                    break;
                case ATUALIZAR:
                    LOG.info("Atualizando registro no banco de dados");
                    session.merge(object);
                    session.getTransaction().commit();
                    break;
                case DELETAR:
                    LOG.info("Deletando registro no banco de dados");
                    session.remove(session.merge(object));
                    session.getTransaction().commit();
                    break;
            }
            this.closeSession(persistence_unit);
            return true;
        } catch (Exception e) {
            this.closeSession(persistence_unit);
            e.printStackTrace();
            return false;
        }
    }

    private Map<String, String> getMap() {
        try {
            String url = "jdbc:derby://".concat(InetAddress.getLocalHost().getHostAddress().toString());
            url = url.concat(":1527/").concat(Utilidades.getCurrentPath()).concat("/FICHACONTROLE/");
            propMap.put("javax.persistence.jdbc.url", url);
            return propMap;
        } catch (Exception e) {
            return null;
        }
    }

    private synchronized EntityManager getSession(String persistence_unit) {
        EntityManager session = null;
        if (sessions.isEmpty()) {
            sessions.put(persistence_unit, new ThreadLocal());
            session = sessions.get(persistence_unit).get();
            session = session == null ? EntityManagerFactoryService.getEntityManagerFactory(persistence_unit, propMap).createEntityManager() : session;
        } else {
            session = sessions.get(persistence_unit).get();
            session = session == null ? EntityManagerFactoryService.getEntityManagerFactory(persistence_unit, propMap).createEntityManager() : session;
        }
        return session;
    }

    private synchronized void closeSession(String persistence_unit) {
        EntityManager session = null;
        if (!sessions.isEmpty()) {
            session = sessions.get(persistence_unit).get();
            LOG.info("Encerrando sessão do banco de dados");
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }
        LOG.info("Removendo Entity Manager desta sessão");
        sessions.remove(persistence_unit);
    }

    public void closeAll() {
        LOG.info("Encerrando todas as sessões");
        sessions.clear();
    }

    public synchronized Connection getConnection(String persistence_unit) {
        try {
            EntityManager entityManager = getSession(persistence_unit);
            Connection conn = ((EntityManagerImpl) (entityManager.getDelegate())).getServerSession().getAccessor().getConnection();
            return conn;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<?> getObjectList(String strHQL, String persistence_unit) {
        try {
            EntityManager session = this.getSession(persistence_unit);
            session.getTransaction().begin();
            Query query = session.createQuery(strHQL);
            List<?> objects = query.getResultList();
            this.closeSession(persistence_unit);
            return objects;
        } catch (Exception e) {
            this.closeSession(persistence_unit);
            return null;
        }
    }

    public List<?> getObjectList(String strHQL, String strParam, Object valor, String persistence_unit) {
        try {
            EntityManager session = this.getSession(persistence_unit);
            session.getTransaction().begin();
            Query query = session.createQuery(strHQL);
            query.setParameter(strParam, valor);
            List<?> objects = query.getResultList();
            this.closeSession(persistence_unit);
            return objects;
        } catch (Exception e) {
            this.closeSession(persistence_unit);
            return null;
        }
    }

    public Optional<List<?>> getObjectListNamedQuery(Class classType, String namedQuery, String[] strParam, Object[] valor, String persistence_unit) {
        try {
            EntityManager session = this.getSession(persistence_unit);
            session.getTransaction().begin();
            Query query = session.createNamedQuery(namedQuery, classType);
            int cont = 0;
            if (strParam != null) {
                for (String p : strParam) {
                    query.setParameter(p, valor[cont++]);
                }
            }
            Optional<List<?>> objects = Optional.ofNullable(query.getResultList());
            this.closeSession(persistence_unit);
            return objects;
        } catch (Exception e) {
            this.closeSession(persistence_unit);
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<?> getObjectNamedQuery(Class classType, String namedQuery, String strParam, Object valor, String persistence_unit) {
        try {
            EntityManager session = this.getSession(persistence_unit);
            session.getTransaction().begin();
            Query query = session.createNamedQuery(namedQuery, classType);
            if (strParam != null) {
                query.setParameter(strParam, valor);
            }
            Object object = query.getSingleResult();
            this.closeSession(persistence_unit);
            return Optional.ofNullable(object);
        } catch (Exception e) {
            e.printStackTrace();
            this.closeSession(persistence_unit);
            return Optional.empty();
        }
    }

    public List<?> getObjectList(String strHQL, String strParam, Boolean valor, String persistence_unit) {
        try {
            EntityManager session = this.getSession(persistence_unit);
            session.getTransaction().begin();
            Query query = session.createQuery(strHQL);
            query.setParameter(strParam, valor);
            List<?> objects = query.getResultList();
            this.closeSession(persistence_unit);
            return objects;
        } catch (Exception e) {
            this.closeSession(persistence_unit);
            return null;
        }
    }

    public Object getObject(String strHQL, String persistence_unit) {
        try {
            Object temp;
            EntityManager session = this.getSession(persistence_unit);
            session.getTransaction().begin();
            Query query = session.createQuery(strHQL);
            List<?> objects = query.getResultList();
            this.closeSession(persistence_unit);
            temp = objects.get(0);
            return temp;
        } catch (Exception e) {
            this.closeSession(persistence_unit);
            return null;
        }
    }

    public Object getObject(String strHQL, String strParam, Object valor, String persistence_unit) {
        try {
            Object temp;
            EntityManager session = this.getSession(persistence_unit);
            session.getTransaction().begin();
            Query query = session.createQuery(strHQL);
            query.setParameter(strParam, valor);
            List<?> objects = query.getResultList();
            this.closeSession(persistence_unit);
            temp = objects.get(0);
            return temp;
        } catch (Exception ex) {
            this.closeSession(persistence_unit);
            return null;
        }
    }

    public Object getObjectNativeQuery(String strSQL, Object valor, String persistence_unit) {
        try {
            Object temp;
            EntityManager session = this.getSession(persistence_unit);
            session.getTransaction().begin();
            Query query = session.createNativeQuery(strSQL);
            query.setParameter(1, valor);
            List<?> objects = query.getResultList();
            this.closeSession(persistence_unit);
            temp = objects.get(0);
            return temp;
        } catch (Exception ex) {
            ex.printStackTrace();
            this.closeSession(persistence_unit);
            return null;
        }
    }

    public Object getObject(String strHQL, String[] strParam, String[] valor, String persistence_unit) {
        try {
            Object temp;
            EntityManager session = this.getSession(persistence_unit);
            session.getTransaction().begin();
            Query query = session.createQuery(strHQL);
            for (int i = 0; i < strParam.length; i++) {
                if (strParam[i] != null) {
                    query.setParameter(strParam[i], valor[i]);
                }
            }
            Object objects = query.getSingleResult();
            this.closeSession(persistence_unit);
            temp = objects;
            return temp;
        } catch (Exception ex) {
            this.closeSession(persistence_unit);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
