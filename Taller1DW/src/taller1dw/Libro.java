/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1dw;

import java.util.Date;

/**
 *
 * @author Moxic Sama
 */
public class Libro {

    String titulo;
    String descripcion;
    int precio;
    Autor autor;
    int fecha;
    int paginas;

    public Libro(String titulo, String descripcion, int precio, String nombreAutor, String apellidoAutor, int fecha, int paginas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.autor = new Autor(nombreAutor, apellidoAutor);
        this.fecha = fecha;
        this.paginas = paginas;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Autor getAutor() {
        return autor;
    }

    
    public String autortoString() {
        return autor.toString();
    }
    
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }
    
}
