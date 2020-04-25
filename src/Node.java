public class Node<E>{
    
	private Association<String, String> value; // valor del nodo
    private Node<E> parent; // padre de nodo
    private Node<E> left, right; // hijos laterales de nod

    public Node(String ingles, String espanol){
        value = new Association<>(ingles, espanol);
        parent = null; 
        left = right = null;
    }

    public Association<String, String> getValue(){
    	/**
    	obtiene el valor contenido en el nodo
    	@return Association: vaor que contiene el nodo 
    	Key = palabra en ingles
    	value = palabra en español
    	**/
        return value; //devuelve la palabra en español
    }
    public void setVal(String nuevo){
        this.value.setValue(nuevo);
    }

     public String getEspanol(){
     	/**
     	obtiene la plabra en español
     	@return string de la palabra en español del nodo
     	**/
        return value.theValue;
    }

    public String getKey(){
    	/**
    	Obtiene la palabra en ingles
    	@return string de la palabra en ingles del nodo
    	**/
        return value.getKey(); //devuelve la palabra en ingles
    }

    public Node<E> getLeft(){
    	/**
    	Obtiene referencia del hijo izquierdo
    	@return node hijo izquierdo
    	**/
        return left;
    }

    public Node<E> getRight(){
    	/**
    	Obtiene referencia del hijo derecho
    	@return node hijo derecho
    	**/
        return right;
    }

     public Node<E> getParent(){
     	/**
     	Obtiene referencia del padre
    	@return node padre
     	**/
        return parent;
    }

    public void setLeft(Node left){
    	/**
    	establece referencia a hijo izquierdo
    	@param left una nueva referencia a hijo derecho del nodo
    	**/
        this.left = left;
    }

    public void setRight(Node right){
    	/**
    	establece referencia a hijo derecho
    	@param left una nueva referencia a hijo izquierdo del nodo
    	**/
        this.right = right;
    }

    public void setParent(Node newParent){
    	/**
    	Establece referencia del padre
    	@param newParent nuevo padre del nodo
    	post: re-parents this node to parent reference, or null
    	**/
        parent = newParent;
    }

    @Override
    public String toString(){
    	/**
    	obtiene descripcion en el String 
    	@return String de los valores del nodo
    	**/
       String hilo = "\t("+ value.theKey + ", " + value.theValue + ")";
       return hilo;
    }


    public String search(String value){
    	/**
    	Metodo que busca la palabra en ingles
    	@param value palabra en ingles para buscar
    	@return palabra traducida
    	**/
        if (value.equals(this.value.getKey())){
            
            return this.value.theValue;
        }else if (value.compareTo(this.value.getKey()) < 0) {
            
            if (left == null){
                return "*" + value + "*";
            }else{
                return left.search(value);
            }
        }else if(value.compareTo(this.value.getKey()) > 0) {
            
            if (right == null){
                return "*" + value + "*";
            }else{
                return right.search(value);

            }
        } return "*" + value + "*";
    }
}