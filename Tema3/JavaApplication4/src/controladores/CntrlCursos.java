/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelos.*;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class CntrlCursos {
    public static ArrayList<Cursos> CURSOS = new ArrayList<>();
    public static Session sesion;
    public static Transaction tx;
    public CntrlCursos(){}
    public static ArrayList<Cursos> getCursos(){
        sesion = HibernateSession.getSessionFactory().openSession();
        Query lista = sesion.createQuery("From Cursos");
        CURSOS = (ArrayList<Cursos>) lista.list();
        sesion.close();
        return CURSOS;
    }
    public static long addCurso(Cursos curso){
        int id = 0;
        try {
            sesion = HibernateSession.getSessionFactory().openSession();
            tx = sesion.beginTransaction();
            Object obj = sesion.save(curso);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            tx.rollback();
            id = -1;
        }finally{
            sesion.close();
        }
        return id;
    }
    public static long delCurso(Cursos curso){
        long id = 0;
        try{
            sesion = HibernateSession.getSessionFactory().openSession();
            tx = sesion.beginTransaction();
            sesion.delete(curso);
            tx.commit();
        } catch (HibernateException e){
            tx.rollback();
            id = -1;
        }finally{
            sesion.close();
        }
        return id;
    }
    public static boolean existMatriculaCurso(String codCurso){
        boolean aux = true;
        sesion = HibernateSession.getSessionFactory().openSession();
        Query lista = sesion.createQuery("From Matriculas Where cCodCurso = " + codCurso);
        if (lista.list().size() >= 1 ) {
            aux = false;
        }
        sesion.close();
        return aux;
    }
}
