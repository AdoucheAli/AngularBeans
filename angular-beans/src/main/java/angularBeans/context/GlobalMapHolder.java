/*
 * AngularBeans, CDI-AngularJS bridge 
 *
 * Copyright (c) 2014, Bessem Hmidi. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 */

/**
 @author Bessem Hmidi
 */
package angularBeans.context;

import java.util.HashMap;
import java.util.Map;

public class GlobalMapHolder {

	private static Map<String, NGSessionContextHolder> map = new HashMap<String, NGSessionContextHolder>();

	public static synchronized void destroySession(String holderId) {

		map.remove(holderId);

	}

	public static synchronized NGSessionContextHolder get(String holderId) {

		if (!map.containsKey(holderId)) {
			map.put(holderId, new NGSessionContextHolder());
		}
		return map.get(holderId);
	}

}
