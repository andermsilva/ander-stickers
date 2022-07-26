package com.alura;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

	public static void cria(InputStream inputStream, String nomeArquivo) throws Exception {
		// Leitura da imagem
		
		//InputStream inputStream = new FileInputStream(new File("entrada/TopMovies_1.jpg"));
		//InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
		BufferedImage imagemOriginal = ImageIO.read(inputStream);

		// criar nova imagem em mem�ria com tranparencia e com tamanho novo
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

		// copia a imagem original para nova imagem(em mem�ria)
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);

		// configurar fonte

		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 60);
		graphics.setColor(Color.GREEN);

		graphics.setFont(fonte);

		// escrever uma frase na nova imagem
		graphics.drawString("TOPZERA", 150, novaAltura - 100);

		// escrever uma frase na nova imagem

		ImageIO.write(novaImagem, "png", new File("saida/"+nomeArquivo));
	}


}
