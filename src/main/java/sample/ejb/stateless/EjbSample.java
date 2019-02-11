package sample.ejb.stateless;

import javax.ejb.Local;
import javax.ejb.Remote;

@Remote
// @Local  // <-- @Remote と @Localを同時に指定すると asadmin list-jndi-entries でJNDIに現れなくなる
public interface EjbSample {
  public void execute(String text);
}
