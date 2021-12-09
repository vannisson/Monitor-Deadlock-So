public class Monitor {

	boolean contaCredito; // Cria um booleano para saber se a contaCredito está sendo executada

	synchronized void contaCredito(boolean threadExecutando){

		if (!threadExecutando){ // Caso a thread não esteja mais executando, notifica e acaba a execução do método
			contaCredito = true;
			notify();
			return;
		}

		System.out.println("contaCredito ");

		contaCredito = true;

		notify(); // Notifica a contaDebito que já pode começar a execução

		try {
			while (contaCredito){
				wait(); // Espera a notificação da contaDebito, deixando a contaCredito em espera
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	synchronized void contaDebito(boolean threadExecutando){

		if (!threadExecutando){ // Caso a thread não esteja mais executando, notifica e acaba a execução do método
			contaCredito = false;
			notify();
			return;
		}

		System.out.println("contaDebito");

		contaCredito = false;

		notify(); // Notifica a contaCredito que já pode começar a execução

		try {
			while (!contaCredito){
				wait(); // Espera a notificação da contaCredito, deixando a contaDebito em espera
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
