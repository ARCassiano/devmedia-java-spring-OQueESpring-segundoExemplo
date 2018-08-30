package br.com.andersoncassiano.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mailer {
	private String destinatario;
	
	@Value("contato@andersoncassiano.com.br")
	private String remetente;
	
	@Value("Lembrete de senha")
	private String titulo;
	
	private String mensagem;
	

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void enviarEmail() {
		//Simulando envio de e-mail
		System.out.println("*** E-mail enviado com sucesso! ***");
		System.out.println("Título do e-mail: " + this.titulo);
		System.out.println("Remetente: " + this.remetente);
		System.out.println("Destinatário: " + this.destinatario);
		System.out.println("Mensagem: " + this.mensagem);
	}
}
