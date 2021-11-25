package Shows;

import java.util.Iterator;
import java.util.List;

import Characters.*;
import Events.*;

public interface Show {

	/**
	 * Metodo do tipo <strong>String</strong>.
	 * retorna a variavel <var>showName</var> que representa o nome do objeto do tipo <strong>Show</strong>.
	 * 
	 * @return (<strong>String</strong>) retorna o nome do objeto.
	 */
	String getName();
	/**
	 * Metodo do tipo <strong>Integer</strong>.
	 * Vai buscar a variavel <var>Nseasons</var> que representa o numero de seasons.
	 * 
	 * @return (<strong>Integer</strong>) retorna o numero se seasons.
	 */
	int getNseasons();
	/**
	 * Metodo do tipo <strong>Integer</strong>.
	 * Vai buscar a variavel <var>Nepisodes</var> que representa o numero de episodios.
	 * 
	 * @return (<strong>Integer</strong>) retorna o numero se seasons.
	 */
	int getNepisodes();
	/**
	 * Metodo do tipo <strong>String</strong>.
	 * Devolve uma representacao do objeto potencialmente utilizada na main.
	 * 
	 * @return (<strong>String</strong>) representacao do objeto.
	 */
	String toString();
	/**
	 * Metodo do tipo <strong>void</strong>.
	 * Adiciona uma season, inserindo uma nova key no mapa <var>seasons</var> e inicializa uma nova lista de objetos
	 * <strong>Episode</strong> no respetivo value.
	 */
	void addSeason();
	/**
	 * Metodo do tipo <strong>void</strong>.
	 * Adiciona um objeto do tipo <strong>Episode</strong> na lista de episodios que se encontra no value da key
	 * season,do tipo <strong>Integer</strong>, que e dada como parametro.
	 * 
	 * @param season (<strong>Integer</strong>) season/key ao qual, no seu value, sera adicionado o episodio.
	 * @param episode (<strong>Episode</strong>) episodio a ser adicionado na lista.
	 */
	void addEpisodeToSeason(int season, Episode episode);
	/**
	 * Metodo auxiliar a main do tipo <strong>Integer</strong>.
	 * Encontra o numero de episodios de uma certa season para eventualmente ser printado na main, procurando
	 * no mapa <var>seasons</var>, atraves da key season do tipo <strong>Integer</strong>. Ira ser recebido 
	 * entao o numero de objetos do tipo <strong>Episode</strong> que se encontra no value da key, usando o metodo
	 * size() para saber o tamanho da lista.
	 * 
	 * @param season (<strong>Integer</strong>) season/key a obter o value.
	 * @return (<strong>Integer</strong>) o tamanho da lista. 
	 */
	int numberOfEpisode(int season);
	/**
	 * Metodo de verificacao do tipo <strong>boolean</strong>.
	 * verifica se existe uma certa season na serie. Sera usado para testar condicoes usando o parametro <var>season</var>
	 * do tipo <strong>Integer</strong>, que se ira saber se esta ou nao contido no conjunto de keys do mapa <var>seasons</var>.
	 * 
	 * @param season (<strong>Integer</strong>) numero a saber se esta contido no conjunto de keys do mapa.
	 * @return <code>true</code> se a key esta contida, <code>false</code> caso contrario.
	 */
	boolean existSeason(int season);	
	/**
	 * Metodo do tipo <strong>void</strong>.
	 * Adiciona um novo ator ao a serie.
	 * @param charact (<strong>Characters</strong>) ator a ser adicionado.
	 */
	void addCharacter(Characters charact);
	/**
	 * Metodo de verfificacao do tipo <strong>boolean</strong>.
	 * Verifica se certo ator existe na serie
	 * @param charact (<strong>Characters</strong>) ator a ser verificado.
	 * @return <code>true</code> se o ator existe, <code>false</code> caso contrario.
	 */
	boolean existsCharacter(Characters charact);
	/**
	 * Metodo do tipo <strong>void</strong>.
	 * Adiciona um novo evento a serie no mapa <var>events</var>, que usa como key o numero da season e o numero do episodio
	 * transformado em <strong>String</strong> e somados.
	 * @param e (<strong>Event</strong>) evento a ser adicionado.
	 * @param season (<strong>Integer</strong>) season a qual pertence o evento.
	 * @param episode (<strong>Integer</strong>) episodio ao qual pertence o evento.
	 */
	void addEvent(Event e, int season, int episode);
	/**
	 * @param season
	 * @return
	 */
	Iterator<Episode> listEpisodes(int season);
	/**
	 * Metodo do tipo <strong>Iterator</strong> de objetos do tipo <strong>Event</strong>.
	 * Devolve o iterador da lista de eventos de determinado episodio de determinada season.
	 * @param key (<strong>String</strong>) key utilizada para retornar o seu valor.
	 * @return (<strong>Iterator</strong>) iterador da lista.
	 */
	Iterator<Event> listEvents(String key);
	/**
	 * Metodo do tipo <strong>String</strong>.
	 * Verifica se existe ou nao eventos em certo episodio de uma determinada season.
	 * @param key (<strong>String</strong>) key utilizada para procurar o size da lista contida no seu value.
	 * @return (<strong>boolean</strong>)  <code>true</code> se o size e maior que 0, <code>false</code> caso contrario.
	 */
	boolean hasEvent(String key);
	/**
	 * Metodo do tipo <strong>String</strong>.
	 * Procura o nome de certo episodio em determinada season.
	 * @param season (<strong>Integer</strong>) season que contem o episodio.
	 * @param episode (<strong>Integer</strong>) episodio a ver o nome.
	 * @return (<strong>String</strong>) o nome do episodio.
	 */
	String getEpisodeName(int season, int episode);
	/**
	 * Metodo do tipo <strong>Characters</strong>.
	 * Devolve o ator que esta guardado no mapa <var>characters</var> usando como key o nome de ator.
	 * @param actorName (<strong>String</strong>) nome de ator.
	 * @return (<strong>Characters</strong>) o Objeto do ator.
	 */
	Characters findCharacter(String actorName);
	/**
	 * Metodo do tipo <strong>void</strong>.
	 * Adiciona um evento a todos os atores que constam numa lista.
	 * @param e (<strong>Event</strong>) evento a ser adicionado.
	 * @param key (<strong>String</strong>) season e episodio transformados em string e somados.
	 * @param L (<strong>List</strong>) Lista que guarda os atores presentes no evento
	 */
	void addEventToCharacter(Event e, String key, List<Characters> L);
	/**
	 * Metodo do tipo <strong>boolean</strong>.
	 * Verifica se um ator esta presente numa serie, a partir de inputs.
	 * @param actorName (<strong>String</strong>) nome de actor.
	 * @return (<strong>boolean</strong>) <code>true</code> se esta presente, <code>false</code> caso contrario.
	 */
	boolean checkCharacters(String actorName);
	
}
