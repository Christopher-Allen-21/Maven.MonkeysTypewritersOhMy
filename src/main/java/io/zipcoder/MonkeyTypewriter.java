package io.zipcoder;

public class MonkeyTypewriter {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        public final int MAXThReAds = 4;
        private int max = 0;

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.

        public static void main(String[] args) {
            MonkeyTypewriter typewriter = new MonkeyTypewriter();
            typewriter.runThreads();
        }

        public void runThreads(){

            for(max = MAXThReAds; max<=MAXThReAds; max++){

                UnsafeCopier unsafeCopier = new UnsafeCopier(introduction);
                unsafeSplitStart(unsafeCopier);

                try {
                    Thread.sleep(100);
                    System.out.printf("***** UNSAFE (%d) *****\n", max);
                    System.out.println(unsafeCopier.copied);
                    System.out.printf("***** UNSAFE (%d) diff: (%d) *****\n", max, introduction.length() - unsafeCopier.copied.length());
                    if (unsafeCopier.copied.equals(introduction)) {
                        System.out.println("***** UNSAFE pass *****");
                    }
                    else {
                        System.out.println("***** UNSAFE FAIL!!! *****");
                    }

                }
                catch (InterruptedException e) {
                    System.out.println("MAIN INTERRUPTED");
                }



                SafeCopier safeCopier = new SafeCopier(introduction);
                safeSplitStarter(safeCopier);

                try {
                    Thread.sleep(100);
                    System.out.printf("***** SAFE (%d) *****\n", max);
                    System.out.println(unsafeCopier.copied);
                    System.out.printf("***** SAFE (%d) diff: (%d) *****\n", max, introduction.length() - unsafeCopier.copied.length());
                    if (unsafeCopier.copied.equals(introduction)) {
                        System.out.println("***** SAFE pass *****");
                    }
                    else {
                        System.out.println("***** SAFE FAIL!!! *****");
                    }

                }
                catch (InterruptedException e) {
                    System.out.println("MAIN INTERRUPTED");
                }


            }


        }

    public void unsafeSplitStart(UnsafeCopier unsafe) {
        // make sure you turn on tread ID printing to see what's happening.
        for (int i = 0; i < max; i++) {
            new Thread(unsafe).start();

            try {
                Thread.sleep(600);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void safeSplitStarter(SafeCopier safe) {
        for (int i = 0; i < max; i++) {
            new Thread(safe).start();

            try {
                Thread.sleep(600);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}