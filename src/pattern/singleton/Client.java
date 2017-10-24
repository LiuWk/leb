/**
 * 
 */
package pattern.singleton;

/**
 * @author lwk
 *
 */
public class Client {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Goalkeeper.getInstance("aa").hashCode());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Goalkeeper.getInstance("aa").hashCode());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Goalkeeper.getInstance("aa").hashCode());
            }
        }).start();
    }
}
