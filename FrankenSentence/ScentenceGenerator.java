import java.util.ArrayList;
import java.util.Arrays;

public class ScentenceGenerator
{
    ArrayList<String> nouns = new ArrayList<String>(Arrays.asList("An Actor", "An Animal", "A Person", "The Woman", "A Child", "God", "Jesus Chris of Nazareth himself", "A group of creatures", "John", "The Hand", "Bill Clinton", "Bill Cosby", "Adolf Hitler", "John Hopkins from John Hopkins University", "Satan", "Mr. Richmond", "obe", "The Funniest Man", "The 'Creature Feature'"));
    ArrayList<String> verbs = new ArrayList<String>(Arrays.asList("smelled", "ate", "chased", "murdered", "birthed", "created", "enjoyed", "felt", "heard", "removed", "broke", "destroyed", "enlightened", "drew", "smelted", "decimated", "studied", "kissed"));
    ArrayList<String> dw = new ArrayList<String>(Arrays.asList("danced with", "laughed at", "jumped with"));
    ArrayList<String> phrases = new ArrayList<String>(Arrays.asList("on a Saturday morning", "with much excitement", "under the mistletoe", "until they died", "til the sun shinned no more", "once the ash turned to dust", "when slime rained from the sky", "on a grateful day", "when they were the last man standing", "on the day of the living (every day you moron)", "on the last monday of the year", "on the first monday of the year", "when God sneezed", "when I gave up writing phrases"));
    public void Generate(int times)
    {
        for(int i = 0; i < times; i++)
        {
            int c = (int)(Math.random() * 3);
            switch(c)
            {
                default: System.out.println(NVNP()); break; // 0 & default
                case 1: System.out.println(NDN()); break;
                case 2: System.out.println(NVN()); break;
            }
        }
    }
    
    String NVNP()
    {
        String output;
        output = nouns.get((int)(Math.random() * nouns.size())) + " ";
        output += verbs.get((int)(Math.random() * verbs.size())) + " ";
        output += nouns.get((int)(Math.random() * nouns.size())) + " ";
        output += phrases.get((int)(Math.random() * phrases.size())) + ".";
        return output;
    }
    
    String NDN()
    {
        String output;
        output = nouns.get((int)(Math.random() * nouns.size())) + " ";
        output += dw.get((int)(Math.random() * dw.size())) + " ";
        output += nouns.get((int)(Math.random() * nouns.size())) + ".";
        return output;
    }
    
    String NVN()
    {
        String output;
        output = nouns.get((int)(Math.random() * nouns.size())) + " ";
        output += verbs.get((int)(Math.random() * verbs.size())) + " ";
        output += nouns.get((int)(Math.random() * nouns.size())) + ".";
        return output;
    }
}
