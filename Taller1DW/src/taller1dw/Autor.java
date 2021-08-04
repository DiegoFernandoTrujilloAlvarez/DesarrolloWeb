/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1dw;

/**
 *
 * @author Moxic Sama
 */
public class Autor {
    String nombreAutor;
    String apellidoAutor;

    public Autor(String nombreAutor, String apellidoAutor) {
        this.nombreAutor = nombreAutor;
        this.apellidoAutor = apellidoAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getApellidoAutor() {
        return apellidoAutor;
    }

    public void setApellidoAutor(String apellidoAutor) {
        this.apellidoAutor = apellidoAutor;
    }

    @Override
    public String toString() {
        return nombreAutor + " " + apellidoAutor ;
    }
    
}
