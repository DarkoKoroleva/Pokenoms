public class Test {
    public static void main(String[] args) {
        Rolling rolling = () -> System.out.println("Rolling...");
        Rolling rolling2 = new Rolling() {
            @Override
            public void roll() {
                System.out.println("Rolling...");
            }
        };
        System.out.println(rolling.getClass().isAnonymousClass());
        System.out.println(rolling2.getClass().isAnonymousClass());
    }
}
