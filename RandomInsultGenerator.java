public class RandomInsultGenerator {
    public static final String[] insultOneArray = {"lazy", "stupid", "insecure", "idiotic", "slimy", "slutty", "smelly", "pompus", "communist", "dicknose", "pie-eating", "racist", "elitist", "white trash", "drug-loving", "butterface", "tone deaf", "ugly", "creepy"};
    public static final String[] insultTwoArray = {"duoche", "ass", "turd", "rectum", "butt", "cock", "shit", "crotch", "bitch", "queef", "prick", "slut", "taint", "fuck", "dick", "boner", "shart", "nut", "sphincter"};
    public static final String[] insultThreeArray = {"pilot", "canoe", "captain", "pirate", "hammer", "knob", "box", "jockey", "nazi", "waffle", "goblin", "blossum", "biscuit", "clown", "socket", "monster", "hound", "dragon", "balloon"};

    // Thank you Eunice for typing all of these for me :)
    public static final String[] shakespeareInsultOneArray = {"artless", "bawdy", "beslubbering", "bootless", "churlish", "cockered", "clouted", "craven", "currish", "dankish", "dissembling", "droning", "errant", "fawning", "fobbing", "froward", "frothy", "gleeking", "goatish", "gorbellied", "impertinent", "infectious", "jarring", "loggerheaded", "lumpish", "mammering", "mangled", "mewling", "paunchy", "pribbling", "puking", "puny", "qualling", "rank", "reeky", "rougish", "ruttish", "saucy", "spleeny", "spongy", "surly", "totterized", "unmuzzled", "vain", "venomed", "villainous", "warped", "wayward", "weedy", "yeasty"};
    public static final String[] shakespeareInsultTwoArray = {"basecourt", "bat-fowling", "beef-witted", "beetle-headed", "boil-brained", "clapper-clawed", "clay-brained", "common-kissing", "crook-pated", "dismal-dreaming", "dizzy-eyed", "doghearted", "dread-bolted", "earth-vexing", "elf-skinned", "fat-kidneyed", "fen-sucked", "flap-mouthed", "fly-bitten", "folly-fallen", "fool-born", "full-gorged", "guts-gripping", "half-faced", "hasty-witted", "hedge-born", "hell-hated", "idle-headed", "ill-breeding", "ill-nurtured", "knotty-patted", "milk-livered", "motley-minded", "onion-eyed", "plume-plucked", "pottle-deep", "pox-marked", "reeling-ripe", "rough-hewn", "rude-growing", "rump-fed", "shard-borne", "sheep-biting", "spur-galled", "swag-bellied", "tardy-gaited", "tickle-brained", "toad-spotted", "unchin-snouted", "weather bitten"};
    public static String[] shakespearinsultThreeArray = {"apple-john", "baggage", "barnacle", "bladder", "boar-pig", "bugbear", "bum-bailey", "canker-blossom", "clack-dish", "clotpole", "coxcomb", "codpiece", "death-token", "dewberry", "flap-dragon", "flax-wench", "flirt-gill", "foot-licker", "fustilarian", "giglet", "gudgeon", "haggard", "harpy", "hedge-pig", "horn-beast", "hugger-mugger", "joithead", "lewdster", "lout", "maggot-pie", "malt-worm", "mammet", "measle", "minnow", "miscreant", "moldwarp", "mumble-news", "nut-hook", "pigeon-egg", "pignut", "puttock", "pumpion", "ratsbane", "scut", "skainsmate", "strumpet", "varlot", "vassal", "whey-faced", "wagtail"};

    public static String randomInsultGenerator() {
        int one = (int) Math.floor(Math.random() * shakespeareInsultOneArray.length);
        int two = (int) Math.floor(Math.random() * shakespeareInsultTwoArray.length);
        int three = (int) Math.floor(Math.random() * shakespearinsultThreeArray.length);
        return shakespeareInsultOneArray[one] + " " + shakespeareInsultTwoArray[two] + " " + shakespearinsultThreeArray[three];
    }

    public static boolean isVowel(char a) {
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        //System.out.println("You know what? You're nothing but a " + randomInsultGenerator() + ".");
        String aeiou = "";
        String insult = randomInsultGenerator();
        if (isVowel(insult.charAt(0))) {
            aeiou = "an ";
        } else {
            aeiou = "a ";
        }
        System.out.println("Thou art " + aeiou + insult + ".");
    }
}
