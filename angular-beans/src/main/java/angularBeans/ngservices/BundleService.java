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
package angularBeans.ngservices;

import angularBeans.boot.ModuleGenerator;



@NGExtention
public class BundleService implements NGService {

private ModuleGenerator moduleGenerator;
	@Override
	public String render() {
		String result = "";
		result += "app.service(\"bundleService\",['$http','$rootScope','$timeout',function($http,$rootScope,$timeout){"
				+ "this.loadBundle=function(bundleName,aleas){"
				+ " $http.get('resources/'+bundleName).success(function(data){"
				+ " $rootScope[aleas]=data;" + "});};;}]);";
		return result;
	}

	@Override
	public void setGenerator(ModuleGenerator generator) {
		this.moduleGenerator=generator;
		
	}

}
