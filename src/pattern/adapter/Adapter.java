package pattern.adapter;

public class Adapter extends V220 implements Out5V {
    @Override
    public void out5V() {
        output220();
        System.out.println("转换为5V");
    }
}
