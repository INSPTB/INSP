/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entidades.EntidadPrueba;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author User
 */
@Stateless
@LocalBean
public class EntidadPruebaSL {

    public static int EXITO = 1;
    public static int ENTIDAD_EXISTENTE = 0;
    @PersistenceContext(unitName = "InstitutoNacionalSaludPublica-ejbPU")
    private EntityManager em;

    public EntidadPrueba obtenerEntidadPorId(Integer id) {
        Query q = em.createNamedQuery("EntidadPrueba.findById");
        q.setParameter("i", id);
        List<EntidadPrueba> rm = q.getResultList();
        if (rm.isEmpty()) {
            return null;
        } else {
            return rm.get(0);
        }
    }

    public int guardaEntidad(EntidadPrueba entidad) {
        System.out.println("Guardando " + entidad.getP04id());
        EntidadPrueba rm = obtenerEntidadPorId(entidad.getP04id());
        if (rm == null) {
            em.persist(entidad);
            return EXITO;
        } else {
            return ENTIDAD_EXISTENTE;
        }
    }

    public List<EntidadPrueba> obtenerEntidades() {
        Query q = em.createNamedQuery("EntidadPrueba.findAll");
        return q.getResultList();
    }

}
