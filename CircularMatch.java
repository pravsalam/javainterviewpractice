/**
 * Created by praveenkumaralam on 7/25/15.
 */
public class CircularMatch {
    public static void main(String[] args) {
        String original = "Praveen";
        String rotated ="veenPran";
        System.out.println(" they are same "+isRotated(original,rotated));

    }
    private static boolean isRotated(String original, String rotated)
    {
        if(original.length() != rotated.length())
            return false;
        String doubleOriginal = original + original;
        System.out.println(" Double of original String "+doubleOriginal);
        if(doubleOriginal.contains(rotated))
            return true;
        return false;
    }
}
