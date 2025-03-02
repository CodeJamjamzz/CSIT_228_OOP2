package Multi_Threading.Midterm_Review.Activity4;

public class DecoderThread implements Runnable {
    static int ID = 0;
    int vowelIndex, stringLength, Threadid;
    char vowel;

    public DecoderThread(char vowel, int vowelIndex, int stringLength, int id){
        this.Threadid = id;
        this.vowel = vowel;
        this.vowelIndex = vowelIndex;
        this.stringLength = stringLength;
    }

    @Override
    public void run(){
        char[] str = new char[stringLength];
        for(int i = 0; i < stringLength; i++){
            str[i] = '-';
        }
        str[vowelIndex] = vowel;

        bruteforce(str,0);

    }

    public void interruptThreads(){
        for(Thread t: Main.threads){
            t.interrupt();
        }
    }

    public void bruteforce(char[] str, int index){
        if (Main.found || Thread.interrupted()) return;
        synchronized (Main.class) {
            if (index == str.length) {

                if (new String(str).equals(Main.password)) {
                    Main.found = true;
                    String res = new String(str);
                    System.out.println("Thread " + Threadid + ": sucessfull" + " Result:" + res);
                    interruptThreads();
                    return;
                }
                String res = new String(str);
                System.out.println("Thread " + Threadid + ": failed" + " Result:" + res);
                return;
            }
        }

        if(str[index] == '-'){
            for(char c = 'a'; c <= 'z'; c++){
                str[index] = c;
                bruteforce(str, index+1);
                if (Main.found) return;
            }
            str[index] = '-';
        } else {
            bruteforce(str, index+1);
        }

    }
}
