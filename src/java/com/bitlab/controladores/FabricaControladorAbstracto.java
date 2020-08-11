/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.controladores;

import com.bitlab.entidades.Empleado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Aguilar
 */
public abstract class FabricaControladorAbstracto<T> {

    //reflexion(obtener la instancia del tipo de clase)
    private Class<T> entityClass;

    //constructor abstracto
    public FabricaControladorAbstracto(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    //metodo para crear una nueva instancia en la base de datos
    public void crear(T entidad) throws Exception {
        EntityManager em = obtenerManejadorEntidades();
        try {
            //iniciar la transaccion
            em.getTransaction().begin();
            em.persist(entidad);
            em.getTransaction().commit();

        } catch (Exception e) {
            //regresar al estado original si ha ocurrido algun problema
            em.getTransaction().rollback();
            throw new Exception(e);
        }finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    //metodo para crear una nueva instancia pero se envia como parametro una lista de entidades
    public void crear(List<T> entidades) throws Exception {
        EntityManager em = obtenerManejadorEntidades();
        try {
            //iniciar la transaccion
            em.getTransaction().begin();
            //recorrer la lista para crear la persistencia
            for (T entidad : entidades) {
                em.persist(entidad);
            }
            System.out.println("Empezando el comit");
            em.getTransaction().commit();
            System.out.println("Transaccion realizada correctamente");

        } catch (Exception e) {
            //regresar al estado original si ha ocurrido algun problema
            em.getTransaction().rollback();
            throw new Exception(e);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    //metodo para modificar una entidad
    public void editar(T entidad) throws Exception {
        EntityManager em = obtenerManejadorEntidades();
        try {
            //iniciar la transaccion
//            if(!em.getTransaction().isActive()){
                em.getTransaction().begin();
                em.merge(entidad);
                em.getTransaction().commit();
//            }
        } catch (Exception e) {
            //regresar al estado original si ha ocurrido algun problema
            System.out.println("ERORRRRRR " +e.getMessage());
            em.getTransaction().rollback();
            throw new Exception(e);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    //metodo para eliminar una entidad
    public void destruir(T entidad) throws Exception {
        EntityManager em = obtenerManejadorEntidades();
        try {
            //iniciar la transaccion
            em.getTransaction().begin();
            em.remove(em.merge(entidad));//para poder eliminar hay q actualizar las entidades
            em.getTransaction().commit();

        } catch (Exception e) {
            //regresar al estado original si ha ocurrido algun problema
            em.getTransaction().rollback();
            throw new Exception(e);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    //encontrar una entidad por ID
    public T encontrar(Object id) throws Exception {
        EntityManager em = obtenerManejadorEntidades();
        try {
            return em.find(entityClass, id); //retorna la entidad instanciada
            
        } catch (Exception e) {
            //posible error en la busqueda
            throw new Exception(e);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    //metodos para obtener el listado de entidades y se aplica polimorfismo
    public List<T> encontrarEntidades() {
        return encontrarEntidades(true, -1, -1);
    }

    public List<T> encontrarEntidades(int maxResults, int firstResult) {
        return encontrarEntidades(false, maxResults, firstResult);
    }

    private List<T> encontrarEntidades(boolean all, int maxResults, int firstResult) {
        EntityManager em = obtenerManejadorEntidades();
        try {
            //realizar la busqueda de las entidades por medio de CriteriaQuery
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
           return q.getResultList();           
        } finally {
            em.close();
        }
    }

    //metodo para obtener la instancia del manejador de entidades
    protected abstract EntityManager obtenerManejadorEntidades();
    
    public List<Empleado> encontrarEmpleadoEstado(Boolean estado) {
        EntityManager em = obtenerManejadorEntidades();
        try {
            Query q = em.createQuery("SELECT e FROM Empleado e WHERE e.empEstado = :estado"); //codigo en jpql
            q.setParameter("estado", estado);
            return q.getResultList();
        } finally {
           if (em.isOpen()) {
                em.close();
            }
        }
    }
}
