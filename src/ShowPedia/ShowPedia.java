package ShowPedia;

import java.util.Iterator;
import java.util.List;

import Characters.Characters;
import Events.Event;
import Shows.*;

public interface ShowPedia {
	/**
	 * Metodo do tipo <strong>void</strong>.
	 * Altera a variavel <var>currentShow</var> para o objeto do tipo <strong>Show</strong> recebida por
	 * parametro
	 * 
	 * @param show (<strong>Show</strong>) objeto a ser inserido na variavel <var>currentShow</var>
	 */
	public void setCurrentShow(Show show);
	/**
	 * Metodo do tipo <strong>Show</strong>.
	 * retorna o objeto do tipo <strong>Show</strong> que se encontra na variavel <var>currentShow</var>.
	 * 
	 * @return (<strong>Show</strong>) retorna um objeto
	 */
	public Show getCurrentShow();
	/**
	 * Metodo do tipo <strong>void</strong>.
	 * Cria um novo objeto do tipo <strong>Show</strong> recebendo como parametro uma variavel
	 * que representa o nome do objeto, sendo guardado no mapa <var>shows</var>. Esse mapa
	 * que guarda todos os objetos do tipo <strong>Show</strong>, usado o nome dos objetos como chave.
	 * 
	 * @param showName (<strong>String</strong>) nome do objeto a ser criado.
	 */
	void createNewShow(String showName);
	/**
	 * Metodo do tipo <strong>void</strong>.
	 * Adiciona uma nova season ao objeto do tipo <strong>Show</strong>, que esta representado
	 * na variavel <var>currentShow</var>.
	 */
	void addNewSeasonToShow();
	/**
	 * Metodo auxiliar a main do tipo <strong>Episode</strong>. 
	 * Devolve um objeto do tipo <strong>Episode</strong>, recebendo como parametro uma
	 * <strong>String</strong> que representa o nome a ser adicionado ao objeto <strong>Episode</strong>.
	 *  
	 * @param episodeName (<strong>String</strong>) que representa o nome do objeto.
	 * @return (<strong>Episode</strong>) retorna um objeto.
	 */
	Episode createNewEpisode(String episodeName);
	/**
	 * Metodo do tipo <strong>void</strong>.
	 * Adiciona um objeto do tipo <strong>Episode</strong> ao objeto <strong>Show</strong> representado na variavel
	 * <var>currentShow</var>. Esse que sera inserido no mapa <var>seasons</var>, que guarda as listas de episodios,
	 * sendo inserido na respetiva <var>season</var> que e dada como parametro do metodo e que serve de key do tipo
	 * <strong>Integer</strong> para o mapa.
	 * 
	 * @param season (<strong>Integer</strong>) season/key a qual sera adicionado o objeto <strong>Episode</strong>
	 * no respetivo value.
	 * @param episode (<strong>Episode</strong>) objeto a ser adicionado.
	 */
	void addEpisodeToShow(int season, Episode episode);
	/**
	 * Metodo auxiliar a main do tipo <strong>Show</strong>.
	 * Procura no mapa <var>shows</var> a key <var>showName</var> retornando o seu value do tipo <strong>Show</strong>.
	 * 
	 * @param showName (<strong>String</strong>) nome/key a ser procurado no mapa.
	 * @return (<strong>Show</strong>) retorna um objeto.
	 */
	Show findShow(String showName);
	/**
	 * Metodo de verificacao do tipo <strong>boolean</strong>.
	 * Verifica se uma serie esta contida na variavel <var>currentShow</var>.
	 * 
	 * @return <code>true</code> se <var>currentShow</var>!=null, <code>false</code> se <var>currentShow</var>==null.
	 */
	boolean isShowSelected();
	/**
	 * Metodo de verificacao do tipo <strong>boolean</strong>.
	 * Verifica se ja existe uma certa serie no sistema. Sera usado para testar condicoes usando o parametro <var>showName</var>
	 * do tipo <strong>String</strong>, que se ira saber se esta ou nao contido nas keys do mapa <var>shows</var>.
	 * 
	 * @param showName (<strong>String</strong>) nome da serie a saber se esta contida no conjunto de keys do mapa.
	 * @return <code>true</code> se a key esta contida, <code>false</code> caso contrario.
	 */
	boolean existShow(String showName);
	/**
	 * Metodo do tipo <strong>Characters</strong>.
	 * Mantem o comando de criacao da Main mais limpo. Cria um novo ator, virtual ou real.
	 * @param type (<strong>String</strong>) tipo do ator, virtual ou real.
	 * @param actorName (<strong>String</strong>) nome de ator.
	 * @param name (<strong>String</strong>) nome real do ator/ nome da companhia caso seja um ator virtual.
	 * @param fee (<strong>Integer</strong>) custo por episodio ou por season caso seja um ator virtual.
	 * @return (<strong>Characters</strong>) o novo ator.
	 */
	Characters createNewCharacter(String type, String actorName, String name, int fee);
	/**
	 * Metodo do tipo <strong>void</strong>.
	 * adiciona um novo ator ao objeto do tipo <strong>Show</strong>, que esta alojado na variavel <var>currentShow</var>.
	 * @param character (<strong>Characters</strong>) ator a ser adicionado.
	 */
	void addCharacterToShow(Characters character);
	/**
	 * Metodo do tipo <strong>boolean</strong>.
	 * Permite descobrir se o ator é real ou virtual.
	 * @param charact (<strong>Characters</strong>) objeto a ser verificado.
	 * @return <code>true</code> se o ator e real, <code>false</code> caso contrario.
	 */
	boolean isReal(Characters charact);
	/**
	 * Metodo do tipo <strong>boolean</strong>.
	 * Auxilia a perceber se o tipo que e dado, real ou virtual, aquando da criacao de um ator e valida.
	 * 
	 * @param type (<strong>String</strong>) tipo a ser testado se e valido.
	 * @return  <code>true</code> se e valido, <code>false</code> caso contrario.
	 */
	boolean isTypeKnown(String type);
	/**
	 * Metodo do tipo <strong>Event</strong>.
	 * Cria um novo evento.
	 * @param description (<strong>String</strong>) descricao do evento.
	 * @param season (<strong>Integer</strong>) numero da season a ser adicionado o evento.
	 * @param episode (<strong>Integer</strong>) o numero do episodio ao qual pertence o evento.
	 * @param l (<strong>List(</strong>) lista de atores que participam no evento.
	 * @return (<strong>Event</strong>) um novo evento.
	 */
	public Event createNewEvent(String description, int season, int episode, List<Characters> l);
	/**
	 * Metodo auxiliar a Main do tipo <strong>boolean</strong>.
	 * Procura numa lista de objetos do tipo <strong>Characters</strong> se existem atores com nome igual.
	 * @param L (<strong>List(</strong>) lista a ser verificada.
	 * @return <code>true</code> se a nomes duplicados, <code>false</code> caso contrario.
	 */
	public boolean searchForDuplicates(List<Characters> L);
	Iterator<Show> getRoles(String realName);
	boolean existCharacter(Characters character);
	int getNumberOfRoles(String realName);
	int getNumberOfRomaces(String realName);
	
}
