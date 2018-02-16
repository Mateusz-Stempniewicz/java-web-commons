/**
 * 
 */
package com.java.web.commons.jpa.repository.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Nasze repozytorium rozszerzające możliwości stardardowego
 * {@link JpaRepository} o generyczne mechanizmy wyszukiwania encji po ID lub
 * kolekcji ID.
 * 
 * @param <T>
 *          - typ encji
 * @param <E>
 *          - typ ID encji
 * 
 * @author mateusz.stempniewicz
 *
 */
@NoRepositoryBean
public interface FindByIdJpaRepository<E, I extends Serializable> extends JpaRepository<E, I> {
	
	/**
	 * Metoda zwracająca po zadanym ID obiekt danego typu.<br />
	 * 
	 * @param id
	 *          - ID obiektu
	 * @param type
	 *          - klasa/projekcja, której obiekt ma być zwrócony
	 * 
	 * @return obiekt klasy podanej w parametrze type, np.<br />
	 *         encja - User.class lub<br />
	 *         projekcja dla usera - SimpleUserPrjection.class
	 */
	<T> Optional<T> findById(Integer id, Class<T> type);
	
	/**
	 * Metoda zwracająca po liscie ID obiekty danego typu.<br />
	 * 
	 * @param ids
	 *          - lista ID obiektów
	 * @param type
	 *          - klasa/projekcja, której obiekt ma być zwrócony
	 * 
	 * @return lista obiektów klasy podanej w parametrze type, np.<br />
	 *         lista encji - User.class lub<br />
	 *         lista projekcji dla usera - SimpleUserPrjection.class
	 */
	<T> List<T> findByIdIn(Collection<Integer> ids, Class<T> type);
	
}
