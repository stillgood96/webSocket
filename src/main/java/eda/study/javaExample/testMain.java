package eda.study.javaExample;

public class testMain {
  
  static class Parent {
    public Parent() {
      System.out.println(" = A");
    }
    
    public void fn() {
      System.out.println(" = B");
    }
    
    public void fnA() {
      System.out.println(" = C");
    }
  }
    static class Child extends Parent {
      public Child() {
        System.out.println(" = D");
      }
      
      public void fn() {
        System.out.println(" = E" );
      }
      public void fnB() {
        System.out.println(" = F" );
      }
    }
  
  public static void main(String[] args) {
    Child c = new Child();
    c.fn();
    c.fnA();
    
    int i=0;
    int j=0;
    for(int k=0;k<3;k++) {
      if ((++i > 1) && (++j > 1)) {
        i++;
      }
    }
    System.out.println("i = " + i);
    System.out.println("j = " + j);
    System.out.println("i + \" \" + j = " + i + " " + j);
    
  }
}
