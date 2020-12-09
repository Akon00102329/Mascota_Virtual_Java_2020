package poo;

public class Mascota {
	
	    // Atributos
	
	    private String nombre;
	    static int edad;
	    static int vida;
	    static int hambre;
	    static boolean estado = true;
	
	    // Método constructor
	
	   
	    public Mascota () {
		
		nombre = "Cornavairus";
		vida = 100;
		edad =  0;
		hambre = 50;
		
							
	}

		//  Métodos setters
		
		public void set_nombre (String nombre) { // este quizas no tenga sentido porque siempre va a tener el mismo nombre
			
			this.nombre = nombre;
		}
	   
						
		
		public static void	revivir() {
			
			vida = 100;
			edad = 0;
			hambre = 50;
			
		}
		
			
		
		public static void set_edad() { 
			
			edad ++;
		}
		
		public static void setVida() {
			
			vida--;
		}
		
		public static void set_hambre() {
			
			
			hambre += 5;	 				
			
							
		}
		
		public static void set_alimentar() {
			
			hambre -= 10;
		}
		
		   	               
	       					
		// Método getter
		
		         
		public String get_nombre() {  
			
									
			return nombre;			
		}
	
		public static int get_edad() {
			
								
			return edad; 
		}
		
		public static int get_vida() {
			
						
			return vida;
		}
			
		public static int get_hambre() {
			
						
			return hambre;
		}
		
	         
		public String get_estado(){
	       
	        String estado = "\n";
	        estado += "\n---------------------"; // marquito con salto de linea \n
	        estado += "\n" + this.nombre;
	        estado += "\n---------------------";
	        estado += "\n" + this.vida + " %";
	        estado += "\n---------------------"; // marquito con salto de linea \n
	        
	        return estado;
	        
	        
		} 
		
		
		public int get_alimentar(int tipo_alimento) {
			
			if (tipo_alimento == 1) hambre -= 10;
			if (tipo_alimento == 2) hambre -= 20;
			return hambre;
			
		}
		
        
		public static void set_desinfectar() {
			
			
			vida -= 5;
		
			
		}
		
		
		
		public static void setRevivir() {
			
			vida=100;
			hambre = 50;
			edad = 0;
		}
		
			
					
}
