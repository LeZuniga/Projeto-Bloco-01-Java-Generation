// ! mostrar lista com elementos da cesta

package projetoJava;

import java.util.ArrayList;
import java.util.Scanner;

public class Pessoa {

	// Pessoa p1 = new Pessoa();
	// Atributos
	String nome;
	String end;
	int idade;
	String cpf;
	String telefone;
	int quantidadePessoas;
	int quantidadeCesta;
	double rendaTotal;
	double rendaPessoa;
	double salarioMinimo = 1212.00;
	String restricaoAlimentar;
	String GREEN_BG = "\u001B[42m";
	String RED_BG = "\u001B[41m";
	String BLACK = "\u001B[30m";
	String RESET = "\u001B[0m";

	Scanner leia = new Scanner(System.in);

	void checarIdade() {
		System.out.print("Digite a idade: ");
		idade = leia.nextInt();
		leia.nextLine();

		if (idade >= 18) {
			Inserir();
		} else if (idade < 18 && idade >= 0) {
			System.out.println(RED_BG + "Voc� n�o pode ter acesso." + RESET);
			System.exit(idade); // finalizar o programa
		} else {
			System.out.println(RED_BG + "Idade invalida." + RESET);
			System.exit(idade);
		}
	}

	void Inserir() {
		System.out.print("Digite o nome: ");
		nome = leia.nextLine();
		System.out.print("Digite o endere�o: ");
		end = leia.nextLine();
		// leia.nextLine();
		System.out.print("Digite o n�mero de telefone: ");
		telefone = leia.nextLine();
		System.out.print("Digite o CPF: ");
		cpf = leia.nextLine();
		System.out.println();
		System.out.print("Quantas pessoas moram com voc�? ");
		quantidadePessoas = leia.nextInt();
		System.out.print("Qual a renda total da fam�lia (incluindo voc�)? ");
		rendaTotal = leia.nextDouble();
		System.out.println();
	}

	void calcularRenda() {
		rendaPessoa = rendaTotal / quantidadePessoas;
		if (rendaPessoa <= salarioMinimo && rendaPessoa >= 600.00) {
			quantidadeCesta = 1;
			System.out.println(GREEN_BG + BLACK + "Voc� tem direito � 1 cesta!" + RESET);
		} else if (rendaPessoa < 600.00 && rendaPessoa >= 400.00) {
			quantidadeCesta = 2;
			System.out.println(GREEN_BG + BLACK + "Voc� tem direito � 2 cestas!" + RESET);
		} else if (rendaPessoa < 400.00 && rendaPessoa >= 200.00) {
			quantidadeCesta = 3;
			System.out.println(GREEN_BG + BLACK + "Voc� tem direito � 3 cestas!" + RESET);
		} else if (rendaPessoa < 200.00 && rendaPessoa >= 0.00) {
			quantidadeCesta = 4;
			System.out.println(GREEN_BG + BLACK + "Voc� tem direito � 4 cestas!" + RESET);
		} else {
			System.out.println(RED_BG + "Voc� n�o atende os requisitos para receber a cesta." + RESET);
		}
		System.out.println();
	}
	
	void cesta() {
		String tipoCesta1 = "Cesta Comum (Padr�o)";
		String tipoCesta2 = "Cesta Kids";
		String tipoCesta3 = "Cesta Zero A��car";
		String tipoCesta4 = "Cesta Fit";
		String tipoCesta5 = "Cesta Zero Gl�ten";

		ArrayList<String> tipoCestas = new ArrayList<>();

		tipoCestas.add(tipoCesta1);
		tipoCestas.add(tipoCesta2);
		tipoCestas.add(tipoCesta3);
		tipoCestas.add(tipoCesta4);
		tipoCestas.add(tipoCesta5);
		
		
		for (int i=0; i<tipoCestas.size(); i++) {
			System.out.println((i+1)+". "+tipoCestas.get(i));
			}
			
		System.out.println();
		
		System.out.println("Voc� gostaria de mudar alguma Cesta ? Caso selecione N�O, "
				+ "a cesta escolhida ser� a padr�o");
		System.out.println("Digite [1] para SIM ou [2] para N�O. ");
		int n = leia.nextInt();
		System.out.println();
		
		if (n == 1) {
				System.out.println("Quantas cestas gostaria de trocar ? ");
				int t = leia.nextInt();
				System.out.println();
				
				if(quantidadeCesta == t) {
					System.out.println("Digite o n�mero da Cesta que deseja trocar: ");
					
					
					System.out.println("Op��es de cestas: ");
					for (int i=1; i<tipoCestas.size(); i++) {
						System.out.println((i)+". "+tipoCestas.get(i));
						}
					int c = leia.nextInt();
					
					System.out.println("Suas Cestas s�o do tipo "+tipoCestas.get(c-1)+".");
				}
				else if(quantidadeCesta>t) {
					System.out.println("Digite o n�mero da Cesta que deseja trocar: ");
					System.out.println("Op��es de cestas: ");
					for (int i=1; i<tipoCestas.size(); i++) {
						System.out.println((i)+". "+tipoCestas.get(i));
					}
					int c = leia.nextInt();
					quantidadeCesta = quantidadeCesta - c;
				}
				
		}
		else if (n == 2) {
			System.out.println("Suas Cestas s�o do tipo "+tipoCestas.get(0)+".");
		}
		else {
			System.out.println(RED_BG + "Valor digitado inv�lido! Registre seus dados novamente." + RESET);
			System.exit(n);
		}
	}
	
	void imprimirInfo() {
		System.out.println();
		System.out.println("--------------Dados Cadastrados--------------");
		System.out.println("Nome: " + nome);
		System.out.println("Idade: " + idade);
		System.out.println("Endere�o: " + end);
		System.out.println("Telefone: "+telefone);
		System.out.println("CPF: " + cpf);
		System.out.println("Quantidade de pessoas da resid�ncia: " + quantidadePessoas);
		System.out.println("Renda Total da fam�lia: R$" + rendaTotal);
		System.out.printf("Renda por pessoa: R$%.2f\n", rendaPessoa);
		leia.close();
	}

}