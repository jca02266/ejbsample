package sample.ejb.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import sample.ejb.stateless.EjbSample;

public class EjbSampleClient {
  public static void main(String[] args) throws NamingException {
    Context ctx = initContext();

    EjbSample sample;

    try {
      System.out.println("ejb lookup:" + EjbSample.class.getName());
      // @StatelessでmappedNameを指定した
      // sample = (EjbSample)ctx.lookup("ejb_mapname#" + EjbSample.class.getName());

      // @StatelessでmappedNameを指定しな
      // sample = (EjbSample)ctx.lookup(EjbSample.class.getName() + "#" + EjbSample.class.getName());

      // 以下いずれも有効
      // sample = (EjbSample)ctx.lookup("java:global/ejbsample/EjbSampleBean");
      sample = (EjbSample)ctx.lookup("java:global/ejbsample/EjbSampleBean" + "!" + EjbSample.class.getName() );
    } finally {
      ctx.close();
    }

    sample.execute("batch");
  }

  private static Context initContext() throws NamingException {
    java.util.Hashtable<String, String> hashTable = new java.util.Hashtable<String, String>();
    // hashTable.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.impl.SerialInitContextFactory");

    // 省略可
    // hashTable.put("org.omg.CORBA.ORBInitialHost", "localhost");
    // hashTable.put("org.omg.CORBA.ORBInitialPort", "3700");

    // 省略可
    // hashTable.put(Context.STATE_FACTORIES, "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
    // hashTable.put(Context.URL_PKG_PREFIXES, "com.sun.enterprise.naming");
    Context ctx = new InitialContext(hashTable);

    return ctx;
  }
}
