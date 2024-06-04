/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.bean;

import com.emergentes.entidades.Estudiante;
import com.emergentes.jpa.EstudianteJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ariel
 */
public class BeanContacto {
    private EntityManagerFactory emf;
    private EstudianteJpaController jpaEstudiante;

    public BeanContacto() {
        emf=Persistence.createEntityManagerFactory("UPSeguimiento");
        jpaEstudiante= new EstudianteJpaController(emf);
    }
    
    public List<Estudiante> listarTodos()
    {
        return jpaEstudiante.findEstudianteEntities();
    }
    
    public void insertar(Estudiante e){
        jpaEstudiante.create(e);
    }
    
    public void eliminar(Integer id){
        try {
            jpaEstudiante.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editar(Estudiante e){
        try {
            jpaEstudiante.edit(e);
        } catch (Exception ex) {
            Logger.getLogger(BeanContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public Estudiante buscar(Integer id)
     {
         Estudiante est = new Estudiante();
         est = jpaEstudiante.findEstudiante(id);
         return est;
     }
}
