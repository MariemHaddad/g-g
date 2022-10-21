/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.gg.services;

import java.util.List;

/**
 *
 * @author yassine
 * @param <R>
 */
public interface IserviceReclam <R> {
    public void ajouter(R r);
    public void modifier(R r);
    public void supprimer(int id);
    public R getOne(R r);
    public List<R> getAll();
}
