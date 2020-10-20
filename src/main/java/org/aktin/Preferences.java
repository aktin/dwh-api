package org.aktin;

import java.util.Set;
import java.util.function.BiConsumer;

import org.aktin.dwh.PreferenceKey;

public interface Preferences {

	String get(String key);

	default String get(PreferenceKey key){
		return get(key.key());
	}
	Set<String> keySet();

	/**
	 * For each property with a key starting with {@code keyPrefix}, call a handler.
	 * The number of matching properties/keys is returned.
	 * @param keyPrefix prefix for the key to match
	 * @param handler handle to be called for key/value pairs
	 * @return number of matches
	 */
	default int forPrefix(String keyPrefix, BiConsumer<String, String> handler) {
		int count = 0;
		for( String key : keySet() ) {
			if( key.startsWith(keyPrefix) ) {
				count ++;
				handler.accept(key, get(key));
			}
		}
		return count;
	}
	
}
