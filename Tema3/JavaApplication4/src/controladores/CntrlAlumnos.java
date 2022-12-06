/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;
import modelos.Alumnos;
import modelos.HibernateSession;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class CntrlAlumnos {
    private static ArrayList<Alumnos> ALUMNOS = new ArrayList<>();
    private static Session sesion;
    private static Transaction tx;
    public CntrlAlumnos(){}
    public static ArrayList<Alumnos> getAlumnos(){
        sesion = HibernateSession.getSessionFactory().openSession();
        Query lista = sesion.createQuery("From Alumnos");
        ALUMNOS = (ArrayList<Alumnos>) lista.list();
        sesion.close();
        return ALUMNOS;
    }
    public static long addAlumno(Alumnos alumnos){
        long id = 0;
        try {
            sesion = HibernateSession.getSessionFactory().openSession();
            tx = sesion.beginTransaction();
            Object obj = sesion.save(alumnos);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            id = -1;
        }finally{
            sesion.close();
        }
        return id;
    }
    public static long delAlumno(Alumnos alumno){
        long id = 0;
        try{
            sesion = HibernateSession.getSessionFactory().openSession();
            tx = sesion.beginTransaction();
            sesion.delete(alumno);
            tx.commit();
        } catch (HibernateException e){
            tx.rollback();
            id = -1;
        }finally{
            sesion.close();
        }
        return id;
    }
    public static long modAlumno(Alumnos alumno){
        long id = 0;
        try{
            sesion = HibernateSession.getSessionFactory().openSession();
            tx = sesion.beginTransaction();
            sesion.update(alumno);
            tx.commit();
        } catch (HibernateException e){
            tx.rollback();
            id = -1;
        }finally{
            sesion.close();
        }
        return id ;
    }
    public static boolean existMatriculaAlumno(String codAlumno){
        boolean aux = true;
        sesion = HibernateSession.getSessionFactory().openSession();
        Query lista = sesion.createQuery("From Matriculas Where cCodAlu = " + codAlumno);
        if (lista.list().size() >= 1 ) {
            aux = false;
        }
        sesion.close();
        return aux;
    }
}
