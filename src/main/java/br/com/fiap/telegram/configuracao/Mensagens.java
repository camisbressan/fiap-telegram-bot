package br.com.fiap.telegram.configuracao;

public class Mensagens {

	public String mensagemInicial(String nome) {

		return "Olá " + nome + "! \n Seja bem-vindo(a) ao Telegram de FullStack da FIAP!";
	}

	public String mensagemComOpcoes() {

		return "Por gentileza, digite o número da opção desejada: "
				+ "\n\n1. Saber o nome das meninas desse grupo "
				+ "\n2. Saber o nome da disciplina desse projeto"
				+ "\n3. Saber o nome do professor dessa disciplina";
	}
	
	public String mensagemMenuInicial() {

		return "\n\n Para retornar ao menu inicial digite 0.";
	}
	
	public String mensagemUm() {

		return "Esse grupo é formado por: "
				+ "\n\n Ana Carolina Vieira Batista"
				+ "\n Camila Bressan Silva"
				+ "\n Jaqueline da Silva de Oliveira";
	}
	
	public String mensagemDois() {

		return "Esse projeto pertence à disciplina Java Plataform.";
	}
	
	public String mensagemTres() {

		return "Esse projeto foi solicitado pelo professor Danilo Vitoriano.";
	}
	
	public String mensagemSemOfensa() {

		return "\n\n Poxa, também não precisa ofender! =/ \n\n";
	}
	
	public String mensagemDefault() {

		return "Desculpe, não entendi!";
	}

}
