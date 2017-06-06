package rs.ac.bg.fon.ai.domaci.stablo;

public class CvorStabla<T> {

	Integer kljuc;
	T podatak;
	CvorStabla<?> levo;
	CvorStabla<?> desno;

	public CvorStabla(Integer kljuc, T podatak, CvorStabla<T> levo, CvorStabla<T> desno) {
		super();
		this.kljuc = kljuc;
		this.podatak = podatak;
		this.levo = levo;
		this.desno = desno;
	}

	public CvorStabla(Integer kljuc, T podatak) {
		this(kljuc, podatak, null, null);
	}

}
