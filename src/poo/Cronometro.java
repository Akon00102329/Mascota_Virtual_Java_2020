package poo;

import javax.swing.*;

public class Cronometro extends Thread {
	
	private JLabel mostrar_edad, mostrar_hambre, mostrar_vida, eti_actividad;
		
	public Cronometro(JLabel mostrar_edad, JLabel mostrar_hambre, JLabel mostrar_vida, JLabel eti_actividad) {
		// TODO Auto-generated constructor stub
		
		this.mostrar_edad = mostrar_edad;
		this.mostrar_hambre = mostrar_hambre;
		this.mostrar_vida = mostrar_vida;
		this.eti_actividad = eti_actividad;
	}
	
	public void run() {
		
		try {
									
			for(int x = 0; x<6000; x ++) {
				
					if(Mascota.get_hambre()<100) {
						
						Thread.sleep(60000);					
						System.out.println("este es el de la edad");
						
						Mascota.set_edad();
						mostrar_edad.setText("Edad : " + Mascota.get_edad() + " años");
						
						Mascota.set_hambre();
						mostrar_hambre.setText("Nivel de hambre : " + Mascota.get_hambre());
						
						
					}
					else {
						
							mostrar_vida.setVisible(false);
							mostrar_edad.setVisible(false);
							mostrar_hambre.setVisible(false);
							eti_actividad.setText("Cornavairus ha muerto");
							eti_actividad.setVisible(true);
							Thread.sleep(6000);
							eti_actividad.setVisible(false);
														
						}
					
					
					
					}
				    
				    
						
							
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
