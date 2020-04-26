public class SplayTree <E> implements Tree{

	public Node root;
	private final int count = 0;
	
	@Override
	public boolean contains(String key){
		return get(key) != null; 
	/**
	revisa si el arbol contiene una llave especifica
	@param key palabra clase
	@return boolean
	**/
	}

	@Override
	public String get(String key){
		root = splay(root, key);
		int comparar = key.compareTo(root.getKey());
		if(comparar == 0 ){
			return root.getValue().getValue().toString();
		}
		else{
			return null;
		}
		/**
		@param key
		@return el valor asociado con la clave dada, sino hay valor retorna null
		**/
	}

	@Override
	public void put(String key, String value){
		//Splay key to root
		if (root == null){
			root = new Node(key, value);
			return;
		}
		root = splay(root, key);
		int comparar = key.compareTo(root.getKey());

		//Insetar un nuevo nodo a la raiz 
		if (comparar < 0){
			Node n = new Node(key, value);
			n.setLeft(root.getLeft());
			n.setRight(root);
			root.setLeft(null);
			root = n;
		}
		if (comparar > 0){
			Node n = new Node(key, value);
			n.setRight(root.getRight());
			n.setLeft(root);
			root.setRight(null);
			root = n;
		}
	}

	//Elimminar
	public void remove(String key){
		if(root == null){
			return;
		}
		root = splay(root, key);
		int comparar = key.compareTo(root.getKey());
		if (comparar == 0){
			if (root.getLeft() == null){
				root = root.getRight();
			}else{
				Node x = root.getRight();
				root = root.getLeft();
				splay(root, key);
				root.setRight(x);
			}
		}
	}

	private Node splay(Node h, String key) {
        if (h == null) return null;

        int cmp1 = key.compareTo(h.getKey());

        if (cmp1 < 0) {
            // La clave no esta en el arbol
            if (h.getLeft() == null) {
                return h;
            }
            int cmp2 = key.compareTo(h.getLeft().getKey());
            if (cmp2 < 0) {
                h.getLeft().setLeft(splay(h.getLeft().getLeft(), key));
                h = rotateRight(h);
            }
            else if (cmp2 > 0) {
                h.getLeft().setRight(splay(h.getLeft().getRight(), key));
                if (h.getLeft().getRight() != null)
                    h.setLeft(rotateLeft(h.getLeft()));
            }
            
            if (h.getLeft() == null) return h;
            else                return rotateRight(h);
        }

        else if (cmp1 > 0) { 
            // La llave no esta en el arbol
            if (h.getRight() == null) {
                return h;
            }

            int cmp2 = key.compareTo(h.getRight().getKey());
            if (cmp2 < 0) {
                h.getRight().setLeft(splay(h.getRight().getLeft(), key));
                if (h.getRight().getLeft() != null)
                    h.setRight(rotateRight(h.getRight()));
            }
            else if (cmp2 > 0) {
                h.getRight().setRight(splay(h.getRight().getRight(), key));
                h = rotateLeft(h);
            }
            
            if (h.getRight() == null) return h;
            else                 return rotateLeft(h);
        }

        else return h;
    }

    public int height() { 
    	return height(root);
    }

    private int height(Node x) {
        if (x == null){
        	return -1;
        }
        return 1 + Math.max(height(x.getLeft()), height(x.getRight()));
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return 1 + size(x.getLeft()) + size(x.getRight());
    }

    private Node rotateRight(Node h) {
        Node x = h.getLeft();
        h.setLeft(x.getRight());
        x.setRight(h);
        return x;
    }
    
    private Node rotateLeft(Node h) {
        Node x = h.getRight();
        h.setRight(x.getLeft());
        x.setLeft(h);
        return x;
    }

}