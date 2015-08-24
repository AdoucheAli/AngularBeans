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

package angularBeans.ngservices;

/**
 * this component render  the angularJS service code
 * that contain the loadBundle() js method
 * (useful for i18n for example)
 * @author Bessem Hmidi
 *
 */

@NGExtension
public class BundleService implements NGService {

	@Override
	public String render() {
		String result = "";
		result += "app.service(\"bundleService\",['$http','$rootScope','$timeout',function($http,$rootScope,$timeout){"
				+ "this.loadBundle=function(bundleName,aleas){"
				+ " $http.get($rootScope.baseUrl+'resources/'+bundleName).success(function(data){"
				+ " $rootScope[aleas]=data;" + "});};;}]);";
		return result;
	}

}
