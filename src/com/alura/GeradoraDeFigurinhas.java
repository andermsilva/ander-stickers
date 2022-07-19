package com.alura;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
	
	public void cria() throws Exception {
		//Leitura da imagem
		
		BufferedImage imagemOriginal= ImageIO.read(new File("entrada/TopMovies_1.jpg"));
		
		// criar nova imagem em memória com tranparencia e com tamanho novo
		int largura =  imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura,novaAltura,BufferedImage.TRANSLUCENT);
		
		// copia a imagem original para nova imagem(em memória)
		Graphics2D graphics =(Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal,0, 0,null);
		//configurar fonte
		var fonte = new Font(Font.SANS_SERIF,Font.BOLD,60); 
	    graphics.setColor(Color.GREEN);
	  
		graphics.setFont(fonte);
		
		
		//  	escrever uma frase na nova imagem
		graphics.drawString("TOPZERA",150,novaAltura -100);
		
		// escrever uma frase na nova imagem
		
		ImageIO.write(novaImagem,  "png", new File("saida/figurinha.png"));
	}
	public static void main(String [] asrgs)throws Exception {
	    var geradora = new GeradoraDeFigurinhas();
	    geradora.cria();
	}
}
