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
package org.springframework.samples.petclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;

/**
 * NamedEntityクラスは、BaseEntityクラスを拡張し、
 * nameプロパティを追加したシンプルなJavaBeanドメインオブジェクトです。
 * このクラスは、これらのプロパティを必要とするオブジェクトの基底クラスとして使用されます。
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Wick Dynex
 */
@MappedSuperclass
public class NamedEntity extends BaseEntity {

	@Column(name = "name")
	@NotBlank
	private String name; // 名前プロパティ

	public String getName() {
		return this.name; // 名前を取得
	}

	public void setName(String name) {
		this.name = name; // 名前を設定
	}

	@Override
	public String toString() {
		return this.getName(); // 名前を文字列として返す
	}

}
