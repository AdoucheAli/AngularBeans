package angularBeans.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.InjectionException;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import angularBeans.context.NGSessionScoped;

@NGSessionScoped
public class ModelQueryFactory implements Serializable {//PassivationCapable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<Class, ModelQuery> allQueries = new HashMap<Class, ModelQuery>();

	RootScope rootScope = new RootScope();

	public ModelQuery get(Class clazz) {

		if(allQueries.get(clazz)==null)return null;
		
		ModelQueryImpl query = (ModelQueryImpl) allQueries.get(clazz);		
		query.setOwner(clazz);

		return query;

	}

	@Produces
	public ModelQuery getModelQuery(InjectionPoint injectionPoint){

		return get(injectionPoint.getMember().getDeclaringClass());
		
	}
	
	// @Produces
	// @ModelQueryProducer
	// public Query create(InjectionPoint ip){
	//
	// Annotated gtAnnotated = ip.getAnnotated();
	// System.out.println(ip);
	//
	// String val=ip.toString();
	// val= val.substring(0,val.lastIndexOf("."));
	//
	// //System.out.println("---"+val);
	// val=val.substring(val.lastIndexOf(" ")+1,val.length());
	// Class service=null;
	// try {
	// service=Class.forName(val);
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// System.out.println("-----"+service);
	//
	// return get(service);
	// }
	//

	// @Produces
	// public Scope getScope(InjectionPoint ip){
	//
	// System.out.println(ip.getAnnotated().getBaseType());
	// return null;
	// }

	public void addQuery(Class clazz) {
		allQueries.put(clazz, new ModelQueryImpl());
	}

	public RootScope getRootScope() {
		return rootScope;
	}
}
