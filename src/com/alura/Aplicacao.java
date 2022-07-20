package com.alura;

import java.awt.Image;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

public class Aplicacao {

	public static void main(String[] args) throws Exception {
         Image image = null;
		// fazer uma conexão HTTP e buscar os top 250 filmes
		String url = "https://api.mocki.io/v2/549a5d8b";
		URI endereco = URI.create(url);
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
	
	   
	// Extrair só os dados que interessam (titulo, poster, classificação)
		JsonParser parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);

		for (Map<String, String> filme:listaDeFilmes) {
			
			String urlImagem = filme.get("image");
			String titulo = filme.get("title");
			InputStream inputStream = new URL(urlImagem).openStream();
			String nomeArquivo = titulo+".png";
		
				
				// Gerador de figurinhas
				GeradoraDeFigurinhas.cria(inputStream, nomeArquivo);
				
		
			System.out.println(filme.get("title"));
			System.out.println(filme.get("image"));
			Integer star = Integer.parseInt(filme.get("imDbRating").substring(0, 1));
			System.out.print("Rating: ");
			for(int i = 0; i <= star-1; ++i) {
				System.out.print("\u2721 ");
			}
			System.out.println(filme.get("imDbRating"));
			System.out.println();

		}
		
		
	}
}
