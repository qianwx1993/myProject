import java.util.HashMap;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/12/3 21:08
 */
public class Tester {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        System.out.println(map.put("a", "A")); // 打印null
        System.out.println(map.put("a", "AA")); // 打印A
        System.out.println(map.put("a", "AB")); // 打印AA
    }
}
