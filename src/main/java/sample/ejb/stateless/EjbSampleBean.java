package sample.ejb.stateless;

import javax.ejb.Stateless;

@Stateless // (mappedName = "ejb_mapname")
public class EjbSampleBean implements EjbSample {
  public void execute(String text) {
    System.out.println("Ejb3SampleBean#exec:" + text);
  }
}
