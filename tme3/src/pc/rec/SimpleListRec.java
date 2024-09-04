package pc.rec;

import pc.IList;

public class SimpleListRec<T> implements IList<T> {
	private Chainon<T> head; // Premier élément de la liste

	private static class Chainon<T> {
		T data; // Donnée du chaînon
		Chainon<T> next; // Référence au chaînon suivant

		public Chainon(T data) {
			this.data = data;
			// NB : next est null par défaut
		}

		public int size() {
			if (next == null) {
				return 1;
			} else {
				return 1 + next.size();
			}
		}

		public boolean contains(T element) {
			if (data.equals(element)) {
				return true;
			} else if (next == null) {
				return false;
			} else {
				return next.contains(element);
			}
		}

		public void add(T element) {
			if (next == null) {
				next = new Chainon<>(element);
			} else {
				next.add(element);
			}
		}

	}

	public void clear() {
        head = null;
    }

	public int size() {
		if (head == null) {
			return 0;
		} else {
			return head.size();
		}
	}

	public boolean contains(T element) {
		if (head == null) {
			return false;
		} else {
			return head.contains(element);
		}
	}

	public void add(T element) {
		if (head == null) {
			head = new Chainon<>(element);
		} else {
			head.add(element);
		}
	}

}
