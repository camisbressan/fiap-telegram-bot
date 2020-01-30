package br.com.fiap.telegram.aplicacao;

import java.util.List;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

import br.com.fiap.telegram.configuracao.Mensagens;

/**
 * @author Camila Bressan
 *
 */
public class App {

	/**
	 * @param args inicial
	 */
	public static void main(String[] args) {

		// Criação do objeto bot com as informações de acesso --- Bot FullStack FIAP
		TelegramBot bot = TelegramBotAdapter.build("612318242:AAExbdLeFKWFkkCfOR5kK3II8nmPV5Q-mhg");
		
		Mensagens mensagens = new Mensagens();

		// objeto responsável por receber as mensagens
		GetUpdatesResponse updatesResponse;
		// objeto responsável por gerenciar o envio de respostas
		SendResponse sendResponse;
		// objeto responsável por gerenciar o envio de ações do chat
		BaseResponse baseResponse;

		// controle de off-set, isto é, a partir deste ID será lido as mensagens
		// pendentes na fila
		int m = 0;
		
		// loop infinito pode ser alterado por algum timer de intervalo curto
		while (true) {

			// executa comando no Telegram para obter as mensagens pendentes a partir de um
			// off-set (limite inicial)
			updatesResponse = bot.execute(new GetUpdates().limit(100).offset(m));

			// lista de mensagens
			List<Update> updates = updatesResponse.updates();

			// análise de cada ação da mensagem
			for (Update update : updates) {

				if (m == 0) {

					System.out.println("Recebendo mensagem inicial: " + update.message().text());

					// envio de "Escrevendo" antes de enviar a resposta
					baseResponse = bot
							.execute(new SendChatAction(update.message().chat().id(), ChatAction.typing.name()));

					// verificação de ação de chat foi enviada com sucesso
					System.out.println("Resposta de Chat Action Enviada? " + baseResponse.isOk());
					
					// envio da mensagem de resposta inicial
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(),
							mensagens.mensagemInicial(update.message().chat().firstName())));

					// verificação de mensagem enviada com sucesso
					System.out.println("Mensagem Enviada? " + sendResponse.isOk());
					
					// envio da mensagem de resposta com as opções
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(),
							mensagens.mensagemComOpcoes()));
					
				} else {
					String opcao = update.message().text().toLowerCase();
					System.out.println("Opção recebida:  " + update.message().text());
					
					switch (opcao) {
					case "0":
						sendResponse = bot.execute(new SendMessage(update.message().chat().id(),
								mensagens.mensagemComOpcoes()));
						System.out.println("Mensagem enviada com as oções:  " + mensagens.mensagemComOpcoes());
						break;
					case "1":
						sendResponse = bot.execute(new SendMessage(update.message().chat().id(),
								mensagens.mensagemUm() + mensagens.mensagemMenuInicial()));
						System.out.println("Mensagem enviada:  " + mensagens.mensagemUm());
						break;
					case "2":
						sendResponse = bot.execute(new SendMessage(update.message().chat().id(),
								mensagens.mensagemDois() + mensagens.mensagemMenuInicial()));
						System.out.println("Mensagem enviada:  " + mensagens.mensagemDois());
						break;
					case "3":
						sendResponse = bot.execute(new SendMessage(update.message().chat().id(),
								mensagens.mensagemTres() + mensagens.mensagemMenuInicial()));
						System.out.println("Mensagem enviada:  " + mensagens.mensagemTres());
						break;
					case "burro":
					case "idiota":
						sendResponse = bot.execute(new SendMessage(update.message().chat().id(),
								mensagens.mensagemSemOfensa() + mensagens.mensagemComOpcoes()));
						System.out.println("Mensagem enviada:  " + mensagens.mensagemSemOfensa());
						break;
					default:
						sendResponse = bot.execute(new SendMessage(update.message().chat().id(),
								mensagens.mensagemDefault()));
						System.out.println("Mensagem enviada:  " + mensagens.mensagemDefault());
						break;
					}	

				}

				// atualização do off-set
				m = update.updateId() + 1;
			}
		}
	}
}