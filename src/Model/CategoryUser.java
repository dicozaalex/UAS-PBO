/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author juand
 */
public class CategoryUser {
    int id;
    String name;

    public CategoryUser(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryUser{" + "id=" + id + ", name=" + name + '}';
    }
    
}
