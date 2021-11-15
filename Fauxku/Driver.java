public class Driver
{
    public static void main()
    {
        FauxkuMaker fm = new FauxkuMaker();
        fm.Create((int)(Math.random() * 30) + 1);
    }
}
