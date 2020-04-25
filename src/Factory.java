import java.util.HashMap;
import java.util.Map;

public class Factory<E> {
    Tree implement;
     public Factory() {
    }
    public Tree getTree(String entry) {
    // seleccion de la implementacion a utilizar:
        
        if(entry.equals("HashMap"))
        {
         //   implement =  new HashMap<>();
        }else if(entry.equals("Splay Tree"))
        {
            implement = new SplayTree<>();
        }
        
        return implement;      
   }
}