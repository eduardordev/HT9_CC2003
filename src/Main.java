/*
* Universidad del Valle de Guatemala
* Algortimos y estructura de datos
* Hoja de Trabajo #9 
* @author Juan Pablo Pineda 19087
* @author Eduardo Ramírez Herrera
* @since  23/04/2020
* @version 26/04/2020
*/
import java.io.*;
import java.util.*; 

public class Main {

     public static void main(String [] args) throws FileNotFoundException, IOException {

     	BufferedReader br = new BufferedReader(new FileReader("Spanish.txt"));   

        StringBuilder sb = new StringBuilder();
        
        String line;
        
        Tree imp = null; //implementacion que escogera el Factory
        
        Factory factory = new Factory();

        SplayTree<Node<Association<String, String>>> rbt = new SplayTree<>(); //se crea nuevo arbol null

        Scanner teclado = new Scanner(System.in);

        int ciclo =0;

        try{

            while (ciclo ==0)
            {

                System.out.println("\n Implementacion a utilizar: \n\t1. HashMap \n\t2. Splay Tree \n\t3. Salir");
                String entryTree = teclado.nextLine();
                switch(entryTree)

                {
                    case "1":
                        imp = factory.getTree("HashMap");

                        break;

                    case "2":
                        imp = factory.getTree("Splay Tree");

                        break;

                    case "3":
                        ciclo = 1;

                        break;
                }
                if(ciclo == 0){

                    while ((line=br.readLine())!=null) {

                        String palabraIngles;
                        String palabraEspanol;

                        sb.append(line);

                        sb.append(System.lineSeparator()); 

                        line = line + " "; //Concatenado para que el ultimo valor sea leido sin problemas
                                           //por substring
                        for(int i=1;i<line.length();i++){

                            String iter = line.substring((i-1), i); 

                            if(iter.equals("\t"))
                            {
                                
                                if(line.contains(",")){

                                    palabraEspanol = line.substring(i, line.indexOf(",")).toLowerCase();

                                }else if(line.contains(";")){

                                    palabraEspanol = line.substring(i, line.indexOf(";")).toLowerCase();

                                }else{

                                    palabraEspanol = line.substring(i, line.length()-1).toLowerCase(); //se obtiene la subcadena luego de ","

                                }
                                
                                palabraIngles = line.substring(0, i-1).toLowerCase(); //se obtiene la subcadena antes de ","

                                imp.put(palabraIngles, palabraEspanol);
                            }
                        }
                    }
                     //Traduccion del documento.

                    File archivo = new File ("texto.txt");

                    FileReader fr = new FileReader (archivo);

                    BufferedReader br1 = new BufferedReader(fr);

                    String linea = "";

                    Scanner scanner = new Scanner(fr);

                    String palabra = "";

                    while (scanner.hasNextLine()) {

                        linea += scanner.nextLine();
                        
                        palabra = linea.replaceAll("\n", " ");

                    }

                    fr.close();

                    br1.close();

                    String palabras[] = palabra.split(" ");


                    String resultado = "";

                    String word;

                    for(String p: palabras){

                        word = p.toLowerCase();

                        if (imp.contains(word))
                            resultado += imp.get(word).toUpperCase() + " ";

                        else
                            resultado+= " *"+word.toUpperCase() + "* ";

                        }

                    System.out.println("----------------------------------");
                    System.out.println("Traduccion:");
                    System.out.println(resultado);
                    System.out.println("----------------------------------");
                    ciclo = 1;
                }
            }
        } finally{

            br.close();

        }
    }
}
