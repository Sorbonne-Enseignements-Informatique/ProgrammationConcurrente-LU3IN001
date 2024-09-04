package pc.iter;

import pc.IList;

public class SimpleList<T> implements IList<T>{
	private Chainon<T> head; // Premier élément de la liste

	private static class Chainon<T> {
		T data; // Donnée du chaînon
		Chainon<T> next; // Référence au chaînon suivant

		public Chainon(T data) {
			this.data = data;
			// NB : next est null par défaut
		}

	}

	public SimpleList() {
		head = null;
	}

	@Override
	public int size() {
		int size = 0;
		Chainon<T> cur = head;
		while (cur != null) {
			size++;
			cur = cur.next;
		}
		return size;
	}

	@Override
	public void add(T element) {
		if (head == null) {
			head = new Chainon<>(element);
			return;
		}
		for (Chainon<T> cur = head; cur != null; cur = cur.next) {
			if (cur.next == null) {
				cur.next = new Chainon<>(element);
				break;
			}
		}
	}

	@Override
	public boolean contains(T element) {
		for (Chainon<T> cur = head; cur != null; cur = cur.next) {
			if (cur.data.equals(element)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void clear() {
		head = null;
		// NB : grace au gc, les éléments de la liste sont supprimés
		// dans d'autres langages, il faudrait les supprimer un par un (e.g. C++)
	}

}