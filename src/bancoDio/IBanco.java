package bancoDio;

public interface IBanco {

	void depositar(double valor);

	void saque(double valor);

	void transferencia(double valor, Conta conta);

	void imprimirExtrato();

}
