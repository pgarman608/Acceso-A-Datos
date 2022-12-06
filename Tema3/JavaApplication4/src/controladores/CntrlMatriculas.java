/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;
import javax.persistence.ParameterMode;
import modelos.HibernateSession;
import modelos.Matriculas;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;

public class CntrlMatriculas {
    private static ArrayList<Matriculas> MATRICULAS = new ArrayList<>();
    private static Session sesion;
    private static Transaction tx;
    public static ArrayList<Matriculas> getMatriculas(){
        sesion = HibernateSession.getSessionFactory().openSession();
        Query lista = sesion.createQuery("From Matriculas");
        MATRICULAS = (ArrayList<Matriculas>) lista.list();
        sesion.close();
        return MATRICULAS;
    }
    public static long addMatriculas(String codigoAlu,String codigoCur){
        long id = 0;
        sesion = HibernateSession.getSessionFactory().openSession();
        try {
            tx = sesion.beginTransaction();
            ProcedureCall procedure = sesion.createStoredProcedureCall("sp_AltaMatricula");
            procedure.registerParameter(1, String.class, ParameterMode.IN).bindValue(codigoAlu);
            procedure.registerParameter(2, String.class, ParameterMode.IN).bindValue(codigoCur);
            procedure.registerParameter(3, Integer.class, ParameterMode.OUT);
            id = (int) procedure.getOutputs().getOutputParameterValue(3);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            id = -1;
        }finally{
            sesion.close();
        }
        return id;
    }
    public static long updateMatriculas(Matriculas matricula){
        long id = 0;
        try{
            sesion = HibernateSession.getSessionFactory().openSession();
            tx = sesion.beginTransaction();
            sesion.update(matricula);
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
