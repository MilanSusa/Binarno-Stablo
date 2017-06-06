package rs.ac.bg.fon.ai.domaci.stablo;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class BinarnoStablo<T> implements Map<Integer, T> {

	private CvorStabla<?> koren;

	public BinarnoStablo(CvorStabla<?> koren) {
		super();
		this.koren = koren;
	}

	@SuppressWarnings("unchecked")
	private T nadjiPodatakSaKljucem(CvorStabla<?> trenutniCvor, Integer kljuc) {
		if (trenutniCvor == null) {
			return null;
		}
		if (trenutniCvor.kljuc == kljuc) {
			return (T) trenutniCvor.podatak;
		}
		if (trenutniCvor.kljuc > kljuc) {
			return nadjiPodatakSaKljucem(trenutniCvor.levo, kljuc);
		}
		return nadjiPodatakSaKljucem(trenutniCvor.desno, kljuc);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<java.util.Map.Entry<Integer, T>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(Object key) {
		if (key == null) {
			throw new RuntimeException("Kljuc ne sme biti null.");
		}
		return nadjiPodatakSaKljucem(koren, (Integer) key);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Integer> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T put(Integer key, T value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends Integer, ? extends T> m) {
		// TODO Auto-generated method stub
	}

	@Override
	public T remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<T> values() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		int kljuc;
		// kreiranje korena stabla
		BinarnoStablo<Double> stablo = new BinarnoStablo<>(new CvorStabla<>(10, 6.33));
		// jednostavno ubacivanje elemenata u sortiranom redosledu kao po
		// zahtevu zadatka
		stablo.koren.levo = (CvorStabla<?>) new CvorStabla<String>(4, "5.36");
		stablo.koren.desno = (CvorStabla<?>) new CvorStabla<Double>(28, 112.534);
		stablo.koren.levo.levo = (CvorStabla<?>) new CvorStabla<String>(2, "sto");
		stablo.koren.levo.desno = (CvorStabla<?>) new CvorStabla<Integer>(7, 1);
		stablo.koren.desno.desno = (CvorStabla<?>) new CvorStabla<Double>(35, 63.234);
		stablo.koren.levo.desno.levo = (CvorStabla<?>) new CvorStabla<String>(6, "dan");
		stablo.koren.desno.desno.desno = (CvorStabla<?>) new CvorStabla<Integer>(41, 8);
		// jednostavno testiranje metode za rekurzivnu pretragu po kljucu
		kljuc = 4;
		System.out.println("Kljuc: " + kljuc + "\tPodatak: " + stablo.get(kljuc));
		kljuc = 6;
		System.out.println("Kljuc: " + kljuc + "\tPodatak: " + stablo.get(kljuc));
		kljuc = 1;
		System.out.println("Kljuc: " + kljuc + "\tPodatak: " + stablo.get(kljuc));
		kljuc = 41;
		System.out.println("Kljuc: " + kljuc + "\tPodatak: " + stablo.get(kljuc));
	}

}
