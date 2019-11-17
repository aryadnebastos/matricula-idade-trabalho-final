package TrabFinal;

import java.util.Scanner;

import javax.swing.JOptionPane;

import java.io.*;

public class IdadeMain {
	static Scanner entrada = new Scanner(System.in);
	static StringBuffer memoria = new StringBuffer();

	public static void main(String[] args) {
		int menu;

		do {
			System.out.println("----MENU----\n"
					+ "1- Adicionar dado\n"
					+ "2- Alterar dados\n"
					+ "3- Consultar dados \n"
					+ "4- Excluir dados\n"
					+ "0- sair \n\n");
			menu = entrada.nextInt();

			switch (menu) {

			case 1:
				AdicionarDado();
				break;
			case 2:
				// alterarDado(idade);
				break;
			case 3:
				// consultarDado(idade);
				break;
			case 4:
				// excluirDado(idade)
				break;
			case 0:
				System.out.println("FIM");
				break;
			default :
				System.out.println("TENTE NOVAMENTE");
				break;
			}

		}while(menu!=0);

	}

	public static void AdicionarDado(){
		int matricula, age;
		try{
			Idade reg = new Idade();
			BufferedWriter saida = new BufferedWriter(new FileWriter("1.txt", true));
			System.out.println("Digite a matricula");
			reg.setMatricula(entrada.nextInt());
			System.out.println("Digite a idade");
			reg.setIdade(entrada.nextInt()); 
			saida.write(reg.toString());
			saida.flush();
			saida.close();
		}
		catch(Exception erro4){
			JOptionPane.showMessageDialog(null, "Erro ao gravar, tente novamente.",null, JOptionPane.ERROR_MESSAGE);
		}
	}


}
