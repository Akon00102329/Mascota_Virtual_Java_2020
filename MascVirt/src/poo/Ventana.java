package poo;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Ventana extends JFrame {
	
				
	Mascota mascota = new Mascota();
	public JPanel panel1, panel2;
	private JButton iniciar, salir, revivir, alimentar, desinfectar;
	private JLabel mostrar_nombre, mostrar_vida, mostrar_edad, mostrar_hambre;
	private JLabel corna, corna_muerto, epitafio, eti_actividad;
	//public static JLabel comiendo;	
	public static JLabel desinfectando;
	static int time;
	private boolean alimento = false;
	
		
	public Ventana() {
		
		this.setSize(400, 350); // Establece las dimensiones de la ventana
		iniciarComponentes();
		this.setTitle("Mascota Virtual");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
	
	private void iniciarComponentes() {
		
		panel1 = new JPanel(); // Creación de un panel
		panel1.setLayout(null); // desactiva el diseño de panel por defecto
		this.getContentPane().add(panel1); // se agrega el panel a la ventana
		colocarBotones();
		
		
	}
	
	private void colocarBotones() {
		
		iniciar = new JButton("Iniciar");
		iniciar.setBounds(140, 100, 100, 40);
		ActionListener oyenteIni = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				panel1.setVisible(false);
				cargarPanel2();
				
								
					iniciarHiloLabelEdad();
					iniciarHiloLabelVida();
									
			}
			
			
		};
		
		iniciar.addActionListener(oyenteIni);
		panel1.add(iniciar);
		
        salir = new JButton("Salir");
		salir.setBounds(140, 150, 100, 40);
		ActionListener oyenteExit = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
			
			
		};
		
		salir.addActionListener(oyenteExit);
        panel1.add(salir);
				
		}
	
	
	private void cargarPanel2() {
		
		panel2 = new JPanel();
		panel2.setLayout(null);
		this.getContentPane().add(panel2);
		colocarBotones2();
		colocarJLabels();
				
       	}
	
	private void colocarBotones2() {
		
		
		alimentar = new JButton();
		alimentar.setText("Alimentar");
		alimentar.setBounds(37, 263, 100, 40);
		
		ActionListener oyenteAlim = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				iniciarHiloAlim();
																
			}
			
			
		};
		
		alimentar.addActionListener(oyenteAlim);
		panel2.add(alimentar);
		
		desinfectar = new JButton();
		desinfectar.setText("Desinfectar");
		desinfectar.setBounds(147, 263, 100, 40);
		
		ActionListener oyenteDesin = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				iniciarHiloDesin();
				
				System.out.println(Mascota.get_vida());
				
				
			}
			
			
		};
		
		desinfectar.addActionListener(oyenteDesin);
		panel2.add(desinfectar);
        
        revivir = new JButton();
		revivir.setText("Revivir");
		revivir.setBounds(257, 263, 100, 40);
		ActionListener oyenteReviv = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
									
					Mascota.setRevivir();
					
					Mascota.estado = true;
					
					reiniLabels();
					
					System.out.println("Vamos a ver que pasa");
												
			}
			
			
		};
		
		revivir.addActionListener(oyenteReviv);
		panel2.add(revivir);
        
        		
		
			
		
	}
	
	private void colocarJLabels() {
		
		mostrar_nombre = new JLabel(mascota.get_nombre());
		mostrar_nombre.setBounds(250, 60, 120, 40);
		panel2.add(mostrar_nombre);
		
		mostrar_vida = new JLabel("100 " + " %" );
		mostrar_vida.setBounds(250, 90, 120, 40);
		panel2.add(mostrar_vida);
		
		mostrar_edad = new JLabel("Edad : " + " 0 " + " años");
		mostrar_edad.setBounds(250, 120, 120, 40);
		panel2.add(mostrar_edad);
		
		mostrar_hambre = new JLabel("Nivel de hambre : 50");
		mostrar_hambre.setBounds(250, 150, 120, 40);
		panel2.add(mostrar_hambre);
		
		eti_actividad = new JLabel("Ñam ñam... estoy comiendo");
		eti_actividad.setBounds(50, 30, 180, 40);
		panel2.add(eti_actividad);
		eti_actividad.setVisible(false);
		
		desinfectando = new JLabel("Grrr..Grrr... Hijos de puta!");
		desinfectando.setBounds(50, 30, 180, 40);
		panel2.add(desinfectando);
		desinfectando.setVisible(false);
		
		corna = new JLabel(new ImageIcon("Cornavairus.gif"));
		corna.setBounds(90, 90, 80, 80);
		panel2.add(corna);
		
		corna_muerto = new JLabel(new ImageIcon("Cornavairus_muerto.png"));
		corna_muerto.setBounds(90, 90, 80, 80);
		corna_muerto.setVisible(false);
		panel2.add(corna_muerto);
		
		epitafio = new JLabel("Cornavairus ha muerto");
		epitafio.setBounds(50, 30, 180, 40);
		panel2.add(epitafio);
		epitafio.setVisible(false);
		
		
		
		
	}
	
	private void iniciarHiloLabelEdad() {
		
		System.out.println("Inicia el hilo edad");
		
		Cronometro miCronometro = new Cronometro(mostrar_edad, mostrar_hambre, mostrar_vida, eti_actividad);
		miCronometro.start();
	}
	
	
    private void iniciarHiloLabelVida() {
		
		System.out.println("Inicia el hilo vida");
		
		Cronometro2 cronometroVida = new Cronometro2(mostrar_vida, mostrar_edad, mostrar_hambre, eti_actividad);
		cronometroVida.start();
	
    }
    
    
   private void iniciarHiloAlim() {
    	
    	Thread tAlim = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
									
				if (Mascota.get_hambre() > 0 && Mascota.get_hambre() != 5) {
					
					
                 try {
                	    Mascota.set_alimentar();
						mostrar_hambre.setText("Nivel de hambre : " + Mascota.get_hambre());
						eti_actividad.setText("Ñam...ñam...Estoy comiendo");
						eti_actividad.setVisible(true);
						Thread.sleep(6000);
						eti_actividad.setVisible(false);
						
					} catch (Exception e) {
						// TODO: handle exception
				  }
					
					
				}else {
					
					try {
						
						eti_actividad.setText("No tengo hambre");
						eti_actividad.setVisible(true);
						Thread.sleep(6000);
						eti_actividad.setVisible(false);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
																							
			}
    		
    		
    	});    	
    	
    	tAlim.start();
    }
    
    private void iniciarHiloDesin() {
    	
    	Thread tDesin = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				Mascota.set_desinfectar();
				mostrar_vida.setText(Mascota.get_vida() + " %");
				
				try {
					
					eti_actividad.setText("Grrr...grrrr...Hijos de puta!");
					eti_actividad.setVisible(true);
					Thread.sleep(6000);
					eti_actividad.setVisible(false);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
    		
    		
    	});
    	
    	tDesin.start();
    }
    
 
    
 private void reiniLabels() {
    	
    	    	
    	mostrar_vida.setText(Mascota.get_vida() + " %");
    	mostrar_vida.setVisible(true);
		mostrar_edad.setText("Edad : " + Mascota.get_edad() + " años");
		mostrar_edad.setVisible(true);
		mostrar_hambre.setText("Nivel de hambre : " + Mascota.get_hambre());
		mostrar_hambre.setVisible(true);
		eti_actividad.setVisible(false);
    	
    }
 

}
