/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.database;

/**
 *
 * @author II
 */
public class Set {
    Lihat lihat;
    Model model;
    Control control;

    public Set() {
        this.control = new Control(model, lihat);
        this.model = new Model();
        this.lihat = new Lihat();
    }
}
