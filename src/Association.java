/*
*
*@author Juan Pablo pineda 19087
*@author Eduardo Ramírez 19946
*
*Codigo adaptado de: Java Structures: Data Structures pagina 16 y pagina 257
*/

public class Association<K extends Comparable<K>, V> implements Comparable<Association<K,V>>{
    private K key;
    private V value;

    /**
    @param key          Llave
    @param value        Valor
    Post: Se construye la asosiaccion
    */
    public Association(K key, V value){
        this.key = key;
        this.value = value;
    }

    public Association(){}

    /**
    Pre: Asocacion a obtener la llave
    @return La llave de la asociacion
    */
    public K getKey(){
        return this.key;
    }

    /**
    Pre: Asocacion a obtener el valor
    @return El valor de la asociacion
    */
    public V getValue() {
        return this.value;
    }

    public void setKey(K key){
        this.key = key;
    }

    public void setValue(V value){
        this.value = value;
    }

    /**
    @param that         Se recibe la asociacion a comparar
    Pre: Tener una asociacion a comparar con otra asociacion
    @return Un entero que representa la comparacion 
    */
    public int compareTo(Association<K,V> that){
        return key.compareTo(that.key);
    }

}
