package newcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while(sc.hasNext()) {
            String material = sc.next();
            set.add(material);
        }
        System.out.println(set.size());
    }
}
