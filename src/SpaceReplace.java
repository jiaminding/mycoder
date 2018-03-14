public class SpaceReplace {
    public static void main(String[] args) {
        String str = "we are happy";
        String result = str.replaceAll("\\s", "%20");
        System.out.println(result);
    }
}
