package com.ustc.zwxu.offer;


class X{
    Y y=new Y();
    public X(){
        System.out.print("X");
    }
}
class Y{
    public Y(){
        System.out.print("Y");
    }
}
class TestDemo extends X{
    Y y=new Y();
    public TestDemo(){
        System.out.print("Z");
    }
    private static void testMethod(){
        System.out.println("testMethod");
   }
   public static void main(String[] args) {
        ((TestDemo)null).testMethod();
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        System.out.print(n1 == n2);
        System.out.print(",");
        System.out.println(n1 != n2);
   }
}