package br.com.fiap.telegram.configuracao;

/**
 * @author Camila Bressan
 *
 */
public class Mensagens {

	
	/**
	 * @param nome do usuário
	 * @return mensagem inicial
	 */
	public String mensagemInicial(String nome) {

		return "Olá " + nome + "! \n Seja bem-vindo(a) ao Telegram de FullStack da FIAP!";
	}

	/**
	 * @return mensagens com opções de escolha
	 */
	public String mensagemComOpcoes() {

		return "Por gentileza, digite o número da opção desejada: "
				+ "\n\n1. Saber o nome das meninas desse grupo "
				+ "\n2. Saber o nome da disciplina desse projeto"
				+ "\n3. Saber o nome do professor dessa disciplina";
	}
	
	/**
	 * @return mensagem com opção para menu inicial
	 */
	public String mensagemMenuInicial() {

		return "\n\n Para retornar ao menu inicial digite 0.";
	}
	
	/**
	 * @return mensagem da opção um
	 */
	public String mensagemUm() {

		return "Esse grupo é formado por: "
				+ "\n\n Ana Carolina Vieira Batista"
				+ "\n Camila Bressan Silva"
				+ "\n Jaqueline da Silva de Oliveira";
	}
	
	/**
	 * @return mensagem da opção dois
	 */
	public String mensagemDois() {

		return "Esse projeto pertence à disciplina Java Plataform.";
	}
	
	/**
	 * @return mensagem da opção três
	 */
	public String mensagemTres() {

		return "Esse projeto foi solicitado pelo professor Danilo Vitoriano.";
	}
	
	/**
	 * @return mensagem sem ofensa
	 */
	public String mensagemSemOfensa() {

		return "\n\n Poxa, também não precisa ofender! =/ \n\n";
	}
	
	/**
	 * @return mensagem default de não entendi
	 */
	public String mensagemDefault() {

		return "Desculpe, não entendi!";
	}

}
