package bancoDio;

public class Conta implements IBanco {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	protected int agencia;

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	protected int numero;
	protected double saldo;
	Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;

	}

	@Override
	public void saque(double valor) {
		saldo -= valor;

	}

	@Override
	public void transferencia(double valor, Conta contaDestino) {
		this.saque(valor);
		contaDestino.depositar(valor);
	}

	@Override
	public void imprimirExtrato() {
         
		System.out.println(String.format("Cliente: %s", this.cliente.getName()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Conta: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println();
	}

}
