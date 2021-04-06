package io.zipcoder;

public class MonkeyTypewriter {
    public static void main(String[] args) {
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

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.


        UnsafeCopier unsafeMonkey1 = new UnsafeCopier(introduction);
        UnsafeCopier unsafeMonkey2 = new UnsafeCopier(introduction);
        UnsafeCopier unsafeMonkey3 = new UnsafeCopier(introduction);
        UnsafeCopier unsafeMonkey4 = new UnsafeCopier(introduction);
        UnsafeCopier unsafeMonkey5 = new UnsafeCopier(introduction);

        unsafeMonkey1.run();
        unsafeMonkey2.run();
        unsafeMonkey3.run();
        unsafeMonkey4.run();
        unsafeMonkey5.run();

        SafeCopier safeMonkey1 = new SafeCopier(introduction);
        SafeCopier safeMonkey2 = new SafeCopier(introduction);
        SafeCopier safeMonkey3 = new SafeCopier(introduction);
        SafeCopier safeMonkey4 = new SafeCopier(introduction);
        SafeCopier safeMonkey5 = new SafeCopier(introduction);

        safeMonkey1.run();
        safeMonkey2.run();
        safeMonkey3.run();
        safeMonkey4.run();
        safeMonkey5.run();


        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        System.out.println("\nUnsafe Monkey 1:\n"+unsafeMonkey1.copied);
        System.out.println("\nUnsafe Monkey 2:\n"+unsafeMonkey2.copied);
        System.out.println("\nUnsafe Monkey 3:\n"+unsafeMonkey3.copied);
        System.out.println("\nUnsafe Monkey 4:\n"+unsafeMonkey4.copied);
        System.out.println("\nUnsafe Monkey 5:\n"+unsafeMonkey5.copied);

        System.out.println("\nSafe Monkey 1:\n"+safeMonkey1.copied);
        System.out.println("\nSafe Monkey 2:\n"+safeMonkey2.copied);
        System.out.println("\nSafe Monkey 3:\n"+safeMonkey3.copied);
        System.out.println("\nSafe Monkey 4:\n"+safeMonkey4.copied);
        System.out.println("\nSafe Monkey 5:\n"+safeMonkey5.copied);

    }
}