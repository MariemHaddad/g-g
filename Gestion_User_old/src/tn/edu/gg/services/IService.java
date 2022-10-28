/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.gg.services;

import java.util.List;

/**
 *
 * @author chalg
 * @param <T>
 * @param <E>
 * @param <F>
 * @param <L>
 */
public interface IService <T,E,F,L>{
    public void ajouter(T t);
    public void modifier(T t);
     public void modifierRole(T t);
      public void ajouterE(E e);
      public void ajouterF(F f);
      public void ajouterL(L l);
      public void modifierF(F f);
     public void modifierE(E e);
     public void modifierL(L l);
    

    public void supprimer(int id_User);
    public T getOne(int id_User);
     public E getOneE (int id_User);
    public List<T> getAll();
      public List<E> getAllE();
       public F getOneF (int id_User);
    public List<F> getAllF();
     public L getOneL (int id_User);
    public List<L> getAllL();
}
