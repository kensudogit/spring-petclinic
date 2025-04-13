/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.owner;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

/**
 * Repository class for <code>Owner</code> domain objects All method names are
 * compliant
 * with Spring Data naming conventions so this interface can easily be extended
 * for Spring
 * Data. See:
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 * @author Wick Dynex
 */
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

	/**
	 * データストアからすべての {@link PetType} を取得します。
	 * 
	 * @return {@link PetType} のコレクション。
	 */
	@Query("SELECT ptype FROM PetType ptype ORDER BY ptype.name")
	List<PetType> findPetTypes();

	/**
	 * データストアから姓で {@link Owner} を取得し、指定された名前で始まるすべてのオーナーを返します。
	 * 
	 * @param lastName 検索する値
	 * @return 一致する {@link Owner} のコレクション（見つからない場合は空のコレクション）
	 */
	Page<Owner> findByLastNameStartingWith(String lastName, Pageable pageable);

	/**
	 * ID でデータストアから {@link Owner} を取得します。
	 * <p>
	 * このメソッドは、見つかった場合は {@link Owner} を含む {@link Optional} を返します。提供された ID で
	 * {@link Owner} が見つからない場合は、空の {@link Optional} を返します。
	 * </p>
	 * 
	 * @param id 検索する ID
	 * @return 見つかった場合は {@link Owner} を含む {@link Optional}、見つからない場合は空の
	 *         {@link Optional}。
	 * @throws IllegalArgumentException ID が null の場合（null は ID の有効な入力ではないと仮定）
	 */
	@NonNull
	Optional<Owner> findById(@NonNull Integer id);

	/**
	 * データストアからすべてのオーナーを返します。
	 **/
	@NonNull
	Page<Owner> findAll(@NonNull Pageable pageable);

}
