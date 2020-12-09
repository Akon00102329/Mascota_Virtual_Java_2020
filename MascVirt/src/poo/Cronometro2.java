package poo;

import javax.swing.JLabel;

public class Cronometro2 extends Thread {
	
	private JLabel mostrar_vida, mostrar_edad, mostrar_hambre, eti_actividad;
	

	public Cronometro2(JLabel mostrar_vida, JLabel mostrar_edad, JLabel mostrar_hambre, JLabel eti_actividad) {
		// TODO Auto-generated constructor stub
		
		this.mostrar_vida = mostrar_vida;
		this.mostrar_edad = mostrar_edad;
		this.mostrar_hambre = mostrar_hambre;
		this.eti_actividad = eti_actividad;
	}
	
	public void run() {
		
		try {
											
				for (int i = 99; i>0; i--) {
					
											
						Thread.sleep(120000);
						Mascota.setVida();
						System.out.println(i);
						System.out.println("Este es el de la vida " + Mascota.estado);
												
						Mascota.setVida();
						mostrar_vida.setText(Mascota.get_vida() + " %");
												
												
				}
				
					
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	
}
