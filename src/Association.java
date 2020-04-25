import java.util.Map;

public class Association<K, V> implements Map.Entry<K,V>{
	protected K theKey; // La clave del par key-value 
	protected V theValue; // La clave del par key-value 

	public Association(K key, V value){
        /**
        la clave previa no es nula
      	post construye un par clave-valor
        @param key Un objeto no nulo.
        @param value A (posiblemente nulo) objeto.
        **/
        theKey = key;
        theValue = value;
    }

    public Association(K key){
    	/**
    	Construye un par a partir de una clave; El valor es nulo.
        pre clave no es nula
        post construye un par clave-valor; el valor es nulo
        @param key Un valor de clave no nulo.
        **/
        this(key,null);
    }

    @Override
    public boolean equals(Object other){
    	/**
    	Función de comparación estándar. Comparación basada solo en claves.
	    pre other es una asociación no nula
	    post devuelve verdadero si las claves son iguales
	    @param otro Otra asociación.
	    @return true si las claves son iguales.
        **/
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey());
    }

    @Override
    public int hashCode(){
    	/**
    	Función estándar de código hash.
        post devuelve asociación de código hash con esta asociación
	    @return Un código hash para la asociación.
      	ver Hashtable
        **/
        return getKey().hashCode();
    }

    @Override
    public V getValue(){
    	/**
    	Obtener valor de la asociación. Puede volver nulo.
	    publicar devuelve valor de asociación
	    @return El campo de valor de la asociación.
        **/
        return theValue;
    }

    @Override
    public K getKey(){
    	/**
    	Recuperar clave de asociación. No debe devolver nulo.
        post devuelve la clave de la asociación
        @return Clave del par clave-valor.
        **/
        return theKey;
    }

    @Override
    public V setValue(V value){
    	/**
    	Establece el valor del par clave-valor.
        post establece el valor de la asociación en valor
        @param value El nuevo valor.
        **/
        V oldValue = theValue;
        theValue = value;
        return oldValue;
    }
}