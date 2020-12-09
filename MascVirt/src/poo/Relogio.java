package poo;

public class Relogio extends Thread {
	
	private static int minutos;
	
			
	public Relogio() {
		
		
		
	}

	@Override
	public void run() {
		
						
		for(minutos = 0; minutos<60; minutos ++) {
			
				System.out.println(minutos);
				
				try {
					Thread.sleep(60000);
					
										
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
		
    }

	public static int minutos() {
		
		return minutos;
	}
	
	
	
	
			
}
	
	
	

