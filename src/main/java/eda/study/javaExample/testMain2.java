package eda.study.javaExample;

public class testMain2 {

  static class Super{
    public void show() {
      print();
    }

    public void print() {
      print();
      System.out.println("Super");
    }
  }

  static class sub extends Super {
    @Override
    public void show() {
      super.print();
    }

    @Override
    public void print() {
      System.out.println("sub");
    }
  }
  public static void main(String[] args) {
    Super s = new sub();
    s.show();
  }
}
