class access {
    public int x;
    public int y;

    void cal(int a, int b) {
        x = a + 1;
        y = b;
    }
}

public class Test {
    public static void main(String[] args) {
        access obj = new access();
        obj.cal(2,3);
        System.out.println(obj.x+" "+obj.y);
    }
}

