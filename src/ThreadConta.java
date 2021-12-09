public class ThreadConta implements Runnable {
  
  Monitor monitor;
  Thread t;

  final int num_execucoes = 10;

  public ThreadConta(String nome, Monitor monitor){ // Criação do método construtor que inicia a thread a partir do monitor
    this.monitor = monitor;
		t = new Thread(this, nome);
		t.start();
  }

  @Override
	public void run() { // Método que inicia as threads
		
		if (t.getName().equalsIgnoreCase("contaCredito")){ // Checa que se o nome da Thread é contaCredito, se sim ele chama
			for (int i=0; i < num_execucoes; i++){ // o método dizendo que a thread está executando
				monitor.contaCredito(true);
			}
			monitor.contaCredito(false);
		} else { // Caso o contrário, ele inicia o método contaDebito dizendo que a thread está executando
			for (int i=0; i < num_execucoes; i++){
				monitor.contaDebito(true);
			}
			monitor.contaDebito(false);
		}
		
	}
}
