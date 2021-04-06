package io.zipcoder;
import static java.lang.Thread.*;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{
    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public synchronized void run() {
        while(stringIterator.hasNext()){
            try {
                sleep(100);
                if (stringIterator.hasNext()) {
                    copied += stringIterator.next() + " ";
                    System.out.println(currentThread().getName());
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
