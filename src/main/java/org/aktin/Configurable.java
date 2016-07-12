package org.aktin;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/**
 * Marker interface to allow automatic injection of configuration preferences
 * 
 * @author R.W.Majeed
 *
 */
public interface Configurable {

	public default List<String> getPreferences(){
		List<String> prefs = new LinkedList<>();
		Method[] methods = getClass().getDeclaredMethods();
		for( int i=0; i<methods.length; i++ ){
			Preference pref = methods[i].getAnnotation(Preference.class);
			if( pref != null ){
				prefs.add(pref.id());
			}
		}
		return prefs;
	}

}
