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
				AlterarDado();
				break;
			case 3:
				procurarDado();
				break;
			case 4:
				ExcluirDado();
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

	static void iniciarArquivo(){
		String linha;
		try{
			BufferedReader arqEntrada;
			arqEntrada = new BufferedReader (new FileReader("1.txt"));
			linha = "";
			memoria.delete(0,memoria.length());
			while( (linha=arqEntrada.readLine()) != null){
				memoria.append(linha+"\n");
			}
			arqEntrada.close();
		}
		catch(FileNotFoundException erro1){
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado",null, JOptionPane.ERROR_MESSAGE);
		}
		catch(Exception erro2){
			JOptionPane.showMessageDialog(null, "Erro de leitura!",null, JOptionPane.ERROR_MESSAGE);
			// Colocar o Joption System.out.println("Erro de leitura!");
		}
	}

	public static void procurarDado() {
		String matricula, idade;
		
		int inicio =-1 , fim, ultimo, primeiro;
		iniciarArquivo();
		try{
			if (memoria.length()!=0) {
				System.out.println("Digite a matricula do aluno que deseja pesquisar: ");
				matricula = entrada.next();
				inicio = memoria.indexOf (matricula);
				if(inicio != -1){
					ultimo = memoria.indexOf("\t",inicio);
					matricula = memoria.substring(inicio, ultimo);
					primeiro = ultimo + 1;
					ultimo = memoria.indexOf("\t",primeiro);
					idade = memoria.substring(primeiro, ultimo);
					
					Idade reg = new Idade ();
					
					reg.setIdade(Integer.parseInt(idade));
					
					reg.setMatricula(Integer.parseInt(idade));
					
					System.out.println("Matricula: "+reg.getMatricula()+"\n"+" Idade: "+reg.getIdade());
				}else{
					System.out.println("Aluno inexistente.");
				}
			}else{
				System.out.println("Arquivo vazio.");
			}

		}catch(Exception erro2){
			System.out.println("Erro na pesquisa");
		}
	}

		public static void AlterarDado() {


		}

		public static void ConsultarDado() {
			

		}

		public static void ExcluirDado() {

		}


	}
