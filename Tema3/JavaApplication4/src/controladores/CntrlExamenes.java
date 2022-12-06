/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;
import modelos.Examenes;
import modelos.HibernateSession;
import modelos.Matriculas;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class CntrlExamenes {
    private static ArrayList<Examenes> EXAMENES = new ArrayList<>();
    private static Session sesion;
    private static Transaction tx;
    public static ArrayList<Examenes> getExamenes(Matriculas matricula){
        sesion = HibernateSession.getSessionFactory().openSession();
        Query lista = sesion.createQuery("from Examenes exa WHERE cCodAlu = '"
                + matricula.getAlumnos().getCcodalu() 
                +"' and cCodCurso = '" 
                + matricula.getCursos().getCcodcurso() + "' ");
        EXAMENES = (ArrayList<Examenes>) lista.list();
        sesion.close();
        return EXAMENES;
    }
    public static long modExamen(Examenes examen){
        long id = 0;
        try{
            sesion = HibernateSession.getSessionFactory().openSession();
            tx = sesion.beginTransaction();
            sesion.update(examen);
            tx.commit();
        } catch (HibernateException e){
            tx.rollback();
            id = -1;
        }finally{
            sesion.close();
        }
        return id ;
    }
}
