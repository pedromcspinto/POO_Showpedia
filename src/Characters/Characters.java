package Characters;

import java.util.Iterator;
import java.util.List;

import Events.Event;

public interface Characters {

	/**
	 * Metodo do tipo <strong>String</strong>.
	 * Devolve o nome de ator do objeto do tipo <strong>Characters</strong>.
	 * @return (<strong>String</strong>) nome de ator.
	 */
	String getActorName();
	/**
	 * Metodo do tipo <strong>String</strong>.
	 * Devolve o nome real do objeto do tipo <strong>Characters</strong>.
	 * @return (<strong>String</strong>) nome real.
	 */
	String getRealName();
	/**
	 * Metodo do tipo <strong>Integer</strong>.
	 * retorna quanto custa a entrada do ator por episodio em determinada serie, ou o custo por season, caso
	 * se trate de um ator virtual.
	 * @return (<strong>Integer</strong>) custo por episodio/season.
	 */
	int getFee();
	/**
	 * Metodo do tipo <strong>void</strong>.
	 * Aquando da criacao de um novo evento este metodo ira guardar no mapa <var>events</var> os eventos
	 * relacionados com este ator, utilizando como key a variavel <var>key</var> do tipo <strong>String</strong>, que representa o numero
	 * da season e do episodio transformados em <strong>String</strong> e somados.
	 * @param key
	 * @param event
	 */
	void addEvent(String key, Event event);
	void addFamily(String type, String name);
	Iterator<String> getFamily(String type);
	int getFamilyNumber(String type);
	boolean alreadyFamily(String type, String name);
}
