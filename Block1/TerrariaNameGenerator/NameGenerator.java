package TerrariaNameGenerator;
public class NameGenerator
{
    // these should all just load from a JSON but i didn't want to bother with that for a simple 2 minute coding warmup
    String[] Adjective = new String[]{"Abandoned","Abhorent","Abusive","Adorable","Adventurous","Ageless",
        "Aggravating","Aggressive","Agile","Agreeable","Alert","Alien","Alive","Alleged","Amethyst","Amusing",
        "Ancient","Angry","Annoyed","Annoying","Anxious","Archaic","Ardent","Arrogant","Ashamed","Attractive",
        "Aunt Becky's","Average","Awful","Awkward","Babbling","Bad","Bashful","Best","Bewildered","Bitter",
        "Bizarre","Blackish","Black","Bleeding","Blistering","Blocky","Bloody","Blue","Blushful","Blushing",
        "Boatmurdered","Boorish","Bored","Boundless","Brainy","Brash","Brave","Breakable","Breakless","Breathtaking",
        "Brightish","Bright","Brilliant","Broken","Brown","Brutal","Budding","Burning","Busy","Calm","Canadian",
        "Careful","Cautious","Celestial","Chad's","Charming","Chartreuse","Cheap","Cheerful","Clean","Clearable",
        "Cleverish","Clever","Cloudy","Clumsy","Cold","Colourful","Combative","Comfortable","Comical","Common",
        "Complacent","Compulsive","Concerned","Condemnable","Confined","Confusable","Confused","Constant","Cooperative",
        "Corrupted","Cosmic","Courageous","Cracked","Cranky","Crass","Crazy","Creepy","Crowded","Crude","Cruel",
        "Cuddly","Curious","Cursed","Cute","Daft","Damaged","Dangerous","Dank","Dark","Daunting","Dead","Decaying",
        "Deceased","Defeated","Defiant","Delight","Demented","Demonic","Dense","Depressed","Deranged","Desolate","Dirt"};
    String[] Location = new String[]{"Abode","Abyss","Acres","Afterworld","Alcove","Alley","Apogee","Arbor","Archipelago",
        "Area","Arena","Armpit","Artwork","Asylum","Backcountry","Backwater","Badlands","Bank","Barleycorn","Barren","Base",
        "Basin","Bastion","Bayou","Bay","Beach","Bedrock","Bed","Beyond","Biosphere","Bluff","Bog","Boondocks","Boonies",
        "Border","Bottoms","Boundary","Breach","Brewery","Brook","Bubble","Bunker","Burrow","Bush","Butte","Camp","Canal",
        "Canopy","Canvas","Canyon","Cape","Center","Chaparral","Chasm","Citadel","City","Clearing","Climax","Cloudland"};
    String[] Noun = new String[]{"Ability","Absurdity","Accidents","Acne","Acorns","Adamantite","Aboration","Adulthood",
        "Advantage","Adventure","Agony","Alarm","Alcohol","Ale","Allergies","Amazement","Angels","Anger","Angry Gamer",
        "Anguish","Animal Carcasses","Annoyance","Anvils","Anxiety","Apples","Apricots","Argon","Arrows","Arsenic","Arson",
        "Arthritis","Asbestos","Ash","Assassins","Assault","Atrophy","Awareness","Awe","Bacon","Bad Decisions","Bad Jokes",
        "Bad Luck","Bad Omens","Balance","Bamboo","Bananas","Bandits","Bankruptcy","Bark","Bats","Beauty","Beenades","Bees",
        "Beggars","Beheadings","Belief","Betrayers","Birds","Birthdays","Bitterness","Bladders","Blasphemy","Blindness"};
    String Result;
    public void Generate(int amount)
    {
        int type;
        int the;
        for(int i = 0; i < amount; i++)
        {
            Result = "";
            type = (int)(Math.random() * 2);
            the = (int)(Math.random() * 3);
            if(type >= 1) { AL(type, the); }
            else { LN(the); }
            System.out.println(Result);
        }
    }
    
    // <Adjective> <Location> ( & <Noun>)
    String AL(int type, int the)
    {
        if(the == 0)
            Result = "The ";
        Result += (Adjective[(int)(Math.random() * Adjective.length - 1)] + " ");
        Result += (Location[(int)(Math.random() * Location.length - 1)]);
        if(type == 0) {
            Result += " of ";
            Result += (Noun[(int)(Math.random() * Noun.length - 1)]); }
        return Result;
    }
    
    // <Location> <Noun>
    String LN(int the)
    {
        if(the == 0) { Result = "The "; }
        Result += (Location[(int)(Math.random() * Location.length - 1)] + " ");
        Result += (Noun[(int)(Math.random() * Noun.length - 1)]);
        return Result;
    }
}