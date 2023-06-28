
package upskilling.javalists;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class UpskillingJavaLists {

    public static void main(String[] args) {
        //-------------Libros ordenados por year---------------------
        
        Libro quijote = new Libro ("Don Quijote", "Miguel de Cervantes", 1605);
        Libro orgullo = new Libro ("Orgullo y Prejuicio", "Jane Austen", 1813);
        Libro mosqueteros = new Libro ("Los Tres Mosqueteros", "Alexander Dumas", 1844);
        Libro visitante = new Libro ("El visitante", "Stephen King", 2018);
        Libro persusion = new Libro ("Persuasion", "Jane Austen", 1817);
        Libro viajeCentro = new Libro ("Viaje al centro de la tierra","Julio Verne", 1864);
        List <Libro> libros = new ArrayList();
        
        //List <Libro> libros = Arrays.asList (quijote,orgullo,mosqueteros,visitante,persusion,viajeCentro);
          
        libros.add(quijote);
        libros.add (orgullo);
        libros.add (mosqueteros);
        libros.add(visitante);
        libros.add(persusion);
        libros.add(viajeCentro);
       /* System.out.println("--Lista libros sin ordenar por year --");
        for (Libro model : libros) {
            System.out.println(model.toString());
        }*/
        
        //Steam ayuda a hacer una copia de la lista, recordando lecciones anteriores
        // las propiedades de  la clase libro son privadas, por lo tanto no deben ser modificadas sin una funcion set
        //se opta usar stream para crear una copia de la lista o proyeccion, 
        // la funcion sorted, buscando el como poder ordenar elementos, nos permite ordenar letras, numeros, etc
        // Comparator es una interface que nos sirve para comparar, y llamando a la clase y la funcion getYear Publicacion,
        // Collect, revise el notepad donde dice que la misma lista la original debe ser modificada no una copia steam
        //https://www.delftstack.com/es/howto/java/convert-stream-to-list-in-java/
        
        libros = libros.stream().sorted(Comparator.comparingInt(Libro::getYearPublication)).collect(Collectors.toList());
        
        System.out.println("  ");
        System.out.println("-------Lista libros ordenados por year ---------");
        for (Libro model : libros) {
            System.out.println(model.toString());
        }
        
        //------------------------Parentesis balanceado-----------------------------
            System.out.println("------------------Parentesis balanceado---------------------");

        String cadenano = "(()((())";
        String cadenasi= "(())()((()))";
        System.out.println("Valida si los parentesis son balanceados: " + cadenano + " resultado: " + validaParentesis(cadenano));   
        System.out.println("Valida si los parentesis son balanceados: " + cadenasi + " resultado: " + validaParentesis(cadenasi));

        //------------------Contador binario-----------------------------
           Queue <String> cola = new ArrayDeque <String> ();
            
           /* cola.add("itzel");
            cola.add("Kevin");
            cola.add("kevin");
            
            System.out.println("Cantidad de elementos: " + cola.size());
            System.out.println("Extrae un elemento: " + cola.poll() );
            System.out.println("Consulta primer elemento: " + cola.peek());
           System.out.println("que elemento saldra despues de la cola : " + cola.element());
           System.out.println("Sacando elemento de la cola: " + cola.remove());*/
           contarBinario(3);
        
        
    }
    
    public static void contarBinario (int num){
    
        Queue <Integer> cola = new ArrayDeque <Integer> ();
        int i = 0;
        while (i < num){
            
        
            if ( cola.size() == 0 ){            
                cola.add(1);
            } else {
            
                if (cola.peek()== 1){
                
                    cola.add(0);
                    
                }else if (cola.peek() == 0){
                
                    cola.poll();
                }
            }
            
            System.out.println(cola.peek());
            i ++;
        }
        
        
    
    }
    
        
        public static boolean validaParentesis (String cadena){
         Deque <String> stack = new ArrayDeque <String>();
         int i = 0;
         
         while (i < cadena.length()){
         
             if (cadena.charAt(i) == '('){
                 stack.push("(");
             } else if (cadena.charAt(i) == ')'){
             
                 if(stack.isEmpty()){
                     stack.push(")");
                     break;
                     
                 } else {
                     stack.pop();
                 }
                 
             }
               i++;
         }
         
        return stack.isEmpty(); 
        
    }
  /* 
    public static void ordenarPorYear( List<Libro> a){

      
       a.stream()
               .sorted(Comparator.comparingInt(Libro::getYearPublication))
               .forEach(System.out::println);
       
    }*/
}
