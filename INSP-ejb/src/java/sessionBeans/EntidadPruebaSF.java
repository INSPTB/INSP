/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entidades.EntidadPrueba;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author User
 */
@Stateful
@LocalBean
public class EntidadPruebaSF {

    public static int EXITO = 1;
    public static int FALLA = 0;
    @PersistenceContext(unitName = "InstitutoNacionalSaludPublica-ejbPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
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

    public int eliminarEntidad(EntidadPrueba entidad) {
        System.out.println("La entidad a eliminar es " + entidad.getP04id());
        EntidadPrueba rm = obtenerEntidadPorId(entidad.getP04id());
        if (rm == null) {
            return FALLA;
        } else {
            em.remove(entidad);
            return EXITO;

        }
    }

     public int actuliazarEntidad(EntidadPrueba entidad) {
        System.out.println("Actualizar entidad con el id: " + entidad.getP04id());
        EntidadPrueba rm = obtenerEntidadPorId(entidad.getP04id());
        if (rm == null) {
            return FALLA;
        } else {
           em.merge(entidad);
            return EXITO;

        }
    }
}
