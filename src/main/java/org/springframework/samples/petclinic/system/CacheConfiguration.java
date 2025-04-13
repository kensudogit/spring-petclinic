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

package org.springframework.samples.petclinic.system;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.configuration.MutableConfiguration;

/**
 * JCache
 * APIを提供するキャッシュ用のキャッシュ設定。この設定は、アプリケーションで使用されるキャッシュを作成し、JMXを介してアクセス可能な統計を有効にします。
 */
@Configuration(proxyBeanMethods = false)
@EnableCaching
class CacheConfiguration {

	@Bean
	public JCacheManagerCustomizer petclinicCacheConfigurationCustomizer() {
		// "vets"という名前のキャッシュを作成し、カスタム設定を適用します。
		return cm -> cm.createCache("vets", cacheConfiguration());
	}

	/**
	 * JCacheプログラムによる設定APIを介して統計を有効にするシンプルな設定を作成します。
	 * <p>
	 * JCache API標準によって提供される設定オブジェクト内には、非常に限られた設定オプションしかありません。
	 * 本当に重要な設定オプション（サイズ制限など）は、選択したJCache実装によって提供される設定メカニズムを介して設定する必要があります。
	 */
	private javax.cache.configuration.Configuration<Object, Object> cacheConfiguration() {
		// 統計を有効にした新しいMutableConfigurationを返します。
		return new MutableConfiguration<>().setStatisticsEnabled(true);
	}

}
