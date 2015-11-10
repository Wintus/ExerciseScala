/**
 * TaraiInJava Function.
 * Created by Admin on 2015/10/28.
 */
public class TaraiInJava {
    @SuppressWarnings("SuspiciousNameCombination")
    static int tak(int x, int y, int z){
        if(x <= y)
            return z;
        else
            return tak(tak(x - 1, y, z), tak(y - 1, z, x), tak(z - 1, x, y));
    }

    public static void main(String[] args){
        long start = System.currentTimeMillis();
        System.out.println(tak(22, 11, 0));
        long end = System.currentTimeMillis();
        System.out.println((end - start)  + "ms");
    }
}
