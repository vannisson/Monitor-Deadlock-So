public class Teste {
  
  public static void main(String[] args) {
		
    // Gerando as instâncias para realizar os testes
		Monitor monitor = new Monitor();
		ThreadConta credito = new ThreadConta("contaCredito", monitor);
		ThreadConta debito = new ThreadConta("contaDebito", monitor);
		
		try {
			credito.t.join(); // Inicializando a thread e utilizando o join para
			debito.t.join(); //  esperar que a thread termine de executar
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
