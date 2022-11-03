package bancoDio;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextArea;

public class FrameBanco {
	JButton btP = new JButton("Poupan\u00E7a");
	JButton btCC = new JButton("Corrente");
	private JFrame frame;
	private JButton Deposito;
	private JButton Transferencia;
	private JButton Ccorrente;
	private JButton Saldo;
	private JButton Cpoupanca;
	private JButton bt1;
	private JButton Confirmar;
	private JTextField textF;
	private JButton bt2;
	private JButton bt3;
	private JButton bt4;
	private JButton bt5;
	private JButton bt6;
	private JButton bt7;
	private JButton bt8;
	private JButton bt9;
	private JButton bt_0;
	boolean ccB = false;
	boolean pB = false;
	boolean saqueB, Db, Tb, Saldob, Eb, poupançaB, correnteB;
	String teste;
	char[] testeChar;

	int t = 0;

	Cliente cliente;
	Conta cc = new ContaCorrente(cliente);
	Conta poupança = new ContaPoupança(cliente);

	private JButton Corrigir;
	private JButton Limpar;
	private JButton Saque;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameBanco window = new FrameBanco();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameBanco() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 981, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Saque = new JButton("Saque");
		Saque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Saque.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.BLUE));
				Deposito.setBorder(null);
				Transferencia.setBorder(null);
				Saldo.setBorder(null);
				saqueB = true;
				ativarnumeros();
				btCC.setVisible(false);
				btP.setVisible(false);
				Db = false;
				Tb = false;
				Saldob = false;
				Eb = false;
				poupançaB = false;
				correnteB = false;

				textArea.setText("Insira o valor a ser sacado");

			}
		});
		Saque.setBounds(127, 167, 134, 54);
		frame.getContentPane().add(Saque);

		Deposito = new JButton("Dep\u00F3sito");
		Deposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Deposito.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.BLUE));
				Saque.setBorder(null);
				Transferencia.setBorder(null);
				Saldo.setBorder(null);
				Tb = false;
				Saldob = false;
				saqueB = false;
				Eb = false;
				Db = true;
				poupançaB = false;
				correnteB = false;
				btCC.setVisible(false);
				btP.setVisible(false);
				ativarnumeros();
				textArea.setText("Insira o valor a ser depositado");

			}
		});
		Deposito.setBounds(127, 232, 134, 54);
		frame.getContentPane().add(Deposito);

		Transferencia = new JButton("Transfer\u00EAncia ");
		Transferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		Transferencia.setBounds(127, 297, 134, 54);
		frame.getContentPane().add(Transferencia);

		Ccorrente = new JButton("Conta Corrente");

		Ccorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Ccorrente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.BLUE));
				ccB = true;
				pB = false;
				Cpoupanca.setBorder(null);
				ativarbotoes();
				if (ccB == true && Tb == true) {
					btCC.setVisible(false);
					btP.setVisible(true);

				}

				if (Saldob == true) {
					textF.setText(String.format("R$ " + "%.2f", cc.saldo));
				}
			}
		});
		Ccorrente.setBounds(692, 154, 134, 50);
		frame.getContentPane().add(Ccorrente);

		Saldo = new JButton("Saldo");

		Saldo.setBounds(127, 362, 134, 54);
		frame.getContentPane().add(Saldo);

		Cpoupanca = new JButton("Conta Poupan\u00E7a");
		Cpoupanca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pB = true;
				Cpoupanca.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.BLUE));
				ccB = false;
				Ccorrente.setBorder(null);
				ativarbotoes();

				if (btP.isVisible() == true && Tb == true) {
					btP.setVisible(false);
					btCC.setVisible(true);
				}
				if (Saldob == true) {
					textF.setText(String.format("R$ " + "%.2f", poupança.saldo));
				}

			}
		});
		Cpoupanca.setBounds(692, 217, 134, 54);
		frame.getContentPane().add(Cpoupanca);

		bt1 = new JButton("1");
		bt1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textF.setText(String.valueOf(textF.getText() + 1));
			}
		});
		bt1.setBounds(318, 217, 89, 39);
		frame.getContentPane().add(bt1);

		Confirmar = new JButton("Confirmar");
		Confirmar.setBackground(Color.GREEN);
		Confirmar.setFont(new Font("Tahoma", Font.BOLD, 15));
		Confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Tb == false && saqueB == false && Saldob == false && Db == true) {
					if (ccB == true) {
						cc.depositar(Double.parseDouble(textF.getText()));
						textF.setText(null);
					}
					if (pB == true) {
						poupança.depositar(Double.parseDouble(textF.getText()));
						textF.setText(null);
					}
				}

				if (saqueB == true) {
					if (ccB == true && cc.saldo > 0) {
						cc.saque(Double.parseDouble(textF.getText()));
						textF.setText(null);

					} else if (ccB == true && cc.saldo <= 0) {
						textArea.setText(
								"Você não possui saldo em conta para sacar. \n Deposite algum valor na sua conta na opção "
										+ "\"Depósito.\"");

					}

					if (pB == true && poupança.saldo > 0) {
						poupança.saque(Double.parseDouble(textF.getText()));
						textF.setText(null);
					} else if (pB == true && poupança.saldo <= 0) {
						textArea.setText(
								"Você não possui saldo em conta para sacar. \n Deposite algum valor na sua conta na opção "
										+ "\"Depósito.\"");
					}
				}

				if (pB == true && Tb == true && correnteB == true && poupança.saldo > 0) {
					poupança.transferencia(Double.parseDouble(textF.getText()), cc);
					textF.setText(null);
					textArea.setText("Transferência completada com sucesso!");
				} else if (pB == true && Tb == true && correnteB == true && poupança.saldo <= 0) {
					textArea.setText(
							"Valor insuficiente para completar a transferência. \n Deposite algum valor na sua conta na opção "
									+ "\"Depósito.\"");
					textF.setText(null);
				}
				if (ccB == true && Tb == true && poupançaB == true && cc.saldo > 0) {
					cc.transferencia(Double.parseDouble(textF.getText()), poupança);
					textF.setText(null);
					textArea.setText("Transferência completada com sucesso!");

				} else if (ccB == true && Tb == true && poupançaB == true && cc.saldo <= 0) {
					textArea.setText(
							"Valor insuficiente para completar a transferência. \n Deposite algum valor na sua conta na opção "
									+ "\"Depósito.\"");
					textF.setText(null);
				}

			}
		});
		Confirmar.setBounds(692, 360, 134, 54);
		frame.getContentPane().add(Confirmar);

		textF = new JTextField();
		textF.setHorizontalAlignment(SwingConstants.CENTER);
		textF.setEditable(false);
		textF.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textF.setBounds(390, 123, 178, 61);
		frame.getContentPane().add(textF);
		textF.setColumns(10);

		bt2 = new JButton("2");
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textF.setText(String.valueOf(textF.getText() + 2));
			}
		});
		bt2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		bt2.setBounds(437, 217, 89, 39);
		frame.getContentPane().add(bt2);

		bt3 = new JButton("3");
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textF.setText(String.valueOf(textF.getText() + 3));
			}
		});
		bt3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		bt3.setBounds(555, 217, 89, 39);
		frame.getContentPane().add(bt3);

		bt4 = new JButton("4");
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textF.setText(String.valueOf(textF.getText() + 4));
			}
		});
		bt4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		bt4.setBounds(318, 267, 89, 39);
		frame.getContentPane().add(bt4);

		bt5 = new JButton("5");
		bt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textF.setText(String.valueOf(textF.getText() + 5));

			}
		});
		bt5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		bt5.setBounds(437, 267, 89, 39);
		frame.getContentPane().add(bt5);

		bt6 = new JButton("6");
		bt6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textF.setText(String.valueOf(textF.getText() + 6));
			}
		});
		bt6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		bt6.setBounds(555, 267, 89, 39);
		frame.getContentPane().add(bt6);

		bt7 = new JButton("7");
		bt7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textF.setText(String.valueOf(textF.getText() + 7));
			}
		});
		bt7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		bt7.setBounds(318, 317, 89, 39);
		frame.getContentPane().add(bt7);

		bt8 = new JButton("8");
		bt8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textF.setText(String.valueOf(textF.getText() + 8));
			}
		});
		bt8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		bt8.setBounds(437, 317, 89, 39);
		frame.getContentPane().add(bt8);

		bt9 = new JButton("9");
		bt9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textF.setText(String.valueOf(textF.getText() + 9));
			}
		});
		bt9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		bt9.setBounds(555, 317, 89, 39);
		frame.getContentPane().add(bt9);

		bt_0 = new JButton("0");
		bt_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textF.setText(String.valueOf(textF.getText() + 0));
			}
		});
		bt_0.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		bt_0.setBounds(437, 368, 89, 39);
		frame.getContentPane().add(bt_0);

		Corrigir = new JButton("Corrigir");
		Corrigir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teste = textF.getText();

				textF.setText("");
				for (int i = 0; i < teste.length() - 1; i++) {
					textF.setText(textF.getText() + teste.charAt(i));

				}
			}
		});
		Corrigir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		Corrigir.setBounds(318, 368, 89, 39);
		frame.getContentPane().add(Corrigir);

		Limpar = new JButton("Limpar");
		Limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textF.setText(null);
			}
		});
		Limpar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		Limpar.setBounds(555, 368, 89, 39);
		frame.getContentPane().add(Limpar);

		btCC.setVisible(false);
		btCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				correnteB = true;
				poupançaB = false;
				btCC.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.BLUE));
				btP.setBorder(null);
				textArea.setText("Insira o valor a ser transferido");
				ativarnumeros();
				Confirmar.setEnabled(true);

			}
		});
		btCC.setBounds(285, 76, 118, 36);
		frame.getContentPane().add(btCC);

		btP.setVisible(false);
		btP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				poupançaB = true;
				correnteB = false;
				ativarnumeros();
				Confirmar.setEnabled(true);
				btP.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.BLUE));
				btCC.setBorder(null);
				textArea.setText("Insira o valor a ser transferido abaixo: ");
			}
		});
		btP.setBounds(555, 74, 112, 38);
		frame.getContentPane().add(btP);

		textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setFont(new Font("Arial Black", Font.ITALIC, 15));
		textArea.setForeground(Color.BLACK);
		textArea.setEditable(false);
		textArea.setBounds(230, 11, 478, 54);
		textArea.setText("Escolha a operação a ser realizada abaixo");
		frame.getContentPane().add(textArea);

		if (ccB == false && pB == false) {
			Deposito.setEnabled(false);
			Transferencia.setEnabled(false);
			Saldo.setEnabled(false);
			bt1.setEnabled(false);
			Confirmar.setEnabled(false);
			bt2.setEnabled(false);
			bt3.setEnabled(false);
			bt4.setEnabled(false);
			bt5.setEnabled(false);
			bt6.setEnabled(false);
			bt7.setEnabled(false);
			bt8.setEnabled(false);
			bt9.setEnabled(false);
			bt_0.setEnabled(false);
			Corrigir.setEnabled(false);
			Limpar.setEnabled(false);
			Saque.setEnabled(false);

			Transferencia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Tb = true;
					Saldob = false;
					Eb = false;
					Db = false;
					saqueB = false;

					Transferencia.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.BLUE));
					Saque.setBorder(null);
					Deposito.setBorder(null);
					Saldo.setBorder(null);

					poupançaB = false;
					correnteB = false;

					if (Tb == true && ccB == true) {
						btP.setVisible(true);
						btCC.setVisible(false);

					}
					if (Tb == true && pB == true) {
						btCC.setVisible(true);
						btP.setVisible(false);
					}

					desativarbotoes();

					textArea.setText("Escolha a conta destino da transferência abaixo: ");

				}

			});
		}

		Saldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Saldo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.BLUE));
				Deposito.setBorder(null);
				Transferencia.setBorder(null);
				Saque.setBorder(null);

				Tb = false;
				Saldob = true;
				Eb = false;
				Db = false;
				saqueB = false;
				btCC.setVisible(false);
				btP.setVisible(false);
				desativarbotoes();

				textArea.setText("Seu saldo atual é :");

				if (ccB == true) {
					textF.setText(String.format("R$ " + "%.2f", cc.saldo));
				}
				if (pB == true) {
					textF.setText(String.format("R$ " + "%.2f", poupança.saldo));
				}
			}
		});

	}

	void ativarbotoes() {

		Saque.setEnabled(true);
		Deposito.setEnabled(true);
		Transferencia.setEnabled(true);
		Saldo.setEnabled(true);

	}

	void desativarbotoes() {

		bt1.setEnabled(false);
		bt2.setEnabled(false);
		bt3.setEnabled(false);
		bt4.setEnabled(false);
		bt5.setEnabled(false);
		bt6.setEnabled(false);
		bt7.setEnabled(false);
		bt8.setEnabled(false);
		bt9.setEnabled(false);
		bt_0.setEnabled(false);
		Corrigir.setEnabled(false);
		Limpar.setEnabled(false);
		Confirmar.setEnabled(false);

	}

	void ativarnumeros() {
		textF.setText(null);
		bt1.setEnabled(true);
		bt2.setEnabled(true);
		bt3.setEnabled(true);
		bt4.setEnabled(true);
		bt5.setEnabled(true);
		bt6.setEnabled(true);
		bt7.setEnabled(true);
		bt8.setEnabled(true);
		bt9.setEnabled(true);
		bt_0.setEnabled(true);
		Corrigir.setEnabled(true);
		Limpar.setEnabled(true);
		Confirmar.setEnabled(true);

	}
}