
package LOGICO;

import LOGICO.ICategoria;
import DATOS.CATEGORIA;


public class CategoriaFactory {
    ICategoria categoria;

    public CategoriaFactory(ICategoria categoria) {
        this.categoria = categoria;
    }
    
    public void insertarCategoriaNuevo (CATEGORIA temp){
        categoria.insertarcate (temp);
    }
    public void eliminarCategoriaNuevo( CATEGORIA temp){
        categoria.eliminarCATEGORIA (temp);
    }
    public void consultarCategoriaNuevo (){
        categoria.consultarcategoria();
    }
    
    
    
    
}
