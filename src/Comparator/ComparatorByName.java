package Comparator;
import java.util.Comparator;

import Shows.*;

public class ComparatorByName implements Comparator<Show>{

	@Override
	public int compare(Show s1, Show s2) {
		int comparacao = s1.getName().compareTo(s2.getName());
		return comparacao;
	}
}
