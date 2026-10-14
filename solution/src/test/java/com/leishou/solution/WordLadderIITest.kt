package com.leishou.solution

import org.junit.Test
import kotlin.test.assertEquals

class WordLadderIITest {
    @Test
    fun testExample1() {
        val wordList = arrayListOf("hot", "dot", "dog", "lot", "log", "cog")
        val expected = listOf(
            listOf("hit", "hot", "dot", "dog", "cog"),
            listOf("hit", "hot", "lot", "log", "cog")
        )
        val result = WordLadderII().findLadders("hit", "cog", wordList)
        val sortedActual = result.sortedBy { it.toString() }
        val sortedExpected = expected.sortedBy { it.toString() }
        assertEquals(sortedExpected, sortedActual)
    }

    @Test
    fun testExample2() {
        val wordList = arrayListOf("hot", "dot", "dog", "lot", "log")
        val expected = emptyList<List<String>>()
        assertEquals(expected, WordLadderII().findLadders("hit", "cog", wordList))
    }

    @Test
    fun testExample3() {
        val wordList = arrayListOf("hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot")
        val expected = listOf(
            listOf("hot", "dot", "dog"),
            listOf("hot", "hog", "dog")
        )
        val result = WordLadderII().findLadders("hot", "dog", wordList)
        val sortedActual = result.sortedBy { it.toString() }
        val sortedExpected = expected.sortedBy { it.toString() }
        assertEquals(sortedExpected, sortedActual)
    }

    @Test
    fun testExample4() {
        val wordList = arrayListOf("flail", "halon", "lexus", "joint", "pears", "slabs", "lorie",
            "lapse", "wroth", "yalow", "swear", "cavil", "piety", "yogis", "dhaka", "laxer",
            "tatum", "provo", "truss", "tends", "deana", "dried", "hutch", "basho", "flyby",
            "miler", "fries", "floes", "lingo", "wider", "scary", "marks", "perry", "igloo",
            "melts", "lanny", "satan", "foamy", "perks", "denim", "plugs", "cloak", "cyril",
            "women", "issue", "rocky", "marry", "trash", "merry", "topic", "hicks", "dicky",
            "prado", "casio", "lapel", "diane", "serer", "paige", "parry", "elope", "balds",
            "dated", "copra", "earth", "marty", "slake", "balms", "daryl", "loves", "civet",
            "sweat", "daley", "touch", "maria", "dacca", "muggy", "chore", "felix", "ogled",
            "acids", "terse", "cults", "darla", "snubs", "boats", "recta", "cohan", "purse",
            "joist", "grosz", "sheri", "steam", "manic", "luisa", "gluts", "spits", "boxer",
            "abner", "cooke", "scowl", "kenya", "hasps", "roger", "edwin", "black", "terns",
            "folks", "demur", "dingo", "party", "brian", "numbs", "forgo", "gunny", "waled",
            "bucks", "titan", "ruffs", "pizza", "ravel", "poole", "suits", "stoic", "segre",
            "white", "lemur", "belts", "scums", "parks", "gusts", "ozark", "umped", "heard",
            "lorna", "emile", "orbit", "onset", "cruet", "amiss", "fumed", "gelds", "italy",
            "rakes", "loxed", "kilts", "mania", "tombs", "gaped", "merge", "molar", "smith",
            "tangs", "misty", "wefts", "yawns", "smile", "scuff", "width", "paris", "coded",
            "sodom", "shits", "benny", "pudgy", "mayer", "peary", "curve", "tulsa", "ramos",
            "thick", "dogie", "gourd", "strop", "ahmad", "clove", "tract", "calyx", "maris",
            "wants", "lipid", "pearl", "maybe", "banjo", "south", "blend", "diana", "lanai",
            "waged", "shari", "magic", "duchy", "decca", "wried", "maine", "nutty", "turns",
            "satyr", "holds", "finks", "twits", "peaks", "teems", "peace", "melon", "czars",
            "robby", "tabby", "shove", "minty", "marta", "dregs", "lacks", "casts", "aruba",
            "stall", "nurse", "jewry", "knuth")
        val expected = listOf(
            listOf("magic", "manic", "mania", "maria", "maris", "paris", "parks", "perks", "peaks",
                "pears", "pearl"),
            listOf("magic", "manic", "mania", "maria", "marta", "marty", "party", "parry", "perry",
                "peary", "pearl"),
            listOf("magic", "manic", "mania", "maria", "marta", "marty", "marry", "merry", "perry",
                "peary", "pearl"),
            listOf("magic", "manic", "mania", "maria", "marta", "marty", "marry", "parry", "perry",
                "peary", "pearl"),
            listOf("magic", "manic", "mania", "maria", "maris", "marks", "parks", "perks", "peaks",
                "pears", "pearl")
        )
        val result = WordLadderII().findLadders("magic", "pearl", wordList)
        val sortedActual = result.sortedBy { it.toString() }
        val sortedExpected = expected.sortedBy { it.toString() }
        assertEquals(sortedExpected, sortedActual)
    }

    @Test
    fun testExample5() {
        val wordList = arrayListOf("aaaaa", "caaaa", "cbaaa", "daaaa", "dbaaa", "eaaaa", "ebaaa",
            "faaaa", "fbaaa", "gaaaa", "gbaaa", "haaaa", "hbaaa", "iaaaa", "ibaaa", "jaaaa",
            "jbaaa", "kaaaa", "kbaaa", "laaaa", "lbaaa", "maaaa", "mbaaa", "naaaa", "nbaaa",
            "oaaaa", "obaaa", "paaaa", "pbaaa", "bbaaa", "bbcaa", "bbcba", "bbdaa", "bbdba",
            "bbeaa", "bbeba", "bbfaa", "bbfba", "bbgaa", "bbgba", "bbhaa", "bbhba", "bbiaa",
            "bbiba", "bbjaa", "bbjba", "bbkaa", "bbkba", "bblaa", "bblba", "bbmaa", "bbmba",
            "bbnaa", "bbnba", "bboaa", "bboba", "bbpaa", "bbpba", "bbbba", "abbba", "acbba",
            "dbbba", "dcbba", "ebbba", "ecbba", "fbbba", "fcbba", "gbbba", "gcbba", "hbbba",
            "hcbba", "ibbba", "icbba", "jbbba", "jcbba", "kbbba", "kcbba", "lbbba", "lcbba",
            "mbbba", "mcbba", "nbbba", "ncbba", "obbba", "ocbba", "pbbba", "pcbba", "ccbba",
            "ccaba", "ccaca", "ccdba", "ccdca", "cceba", "cceca", "ccfba", "ccfca", "ccgba",
            "ccgca", "cchba", "cchca", "cciba", "ccica", "ccjba", "ccjca", "cckba", "cckca",
            "cclba", "cclca", "ccmba", "ccmca", "ccnba", "ccnca", "ccoba", "ccoca", "ccpba",
            "ccpca", "cccca", "accca", "adcca", "bccca", "bdcca", "eccca", "edcca", "fccca",
            "fdcca", "gccca", "gdcca", "hccca", "hdcca", "iccca", "idcca", "jccca", "jdcca",
            "kccca", "kdcca", "lccca", "ldcca", "mccca", "mdcca", "nccca", "ndcca", "occca",
            "odcca", "pccca", "pdcca", "ddcca", "ddaca", "ddada", "ddbca", "ddbda", "ddeca",
            "ddeda", "ddfca", "ddfda", "ddgca", "ddgda", "ddhca", "ddhda", "ddica", "ddida",
            "ddjca", "ddjda", "ddkca", "ddkda", "ddlca", "ddlda", "ddmca", "ddmda", "ddnca",
            "ddnda", "ddoca", "ddoda", "ddpca", "ddpda", "dddda", "addda", "aedda", "bddda",
            "bedda", "cddda", "cedda", "fddda", "fedda", "gddda", "gedda", "hddda", "hedda",
            "iddda", "iedda", "jddda", "jedda", "kddda", "kedda", "lddda", "ledda", "mddda",
            "medda", "nddda", "nedda", "oddda", "oedda", "pddda", "pedda", "eedda", "eeada",
            "eeaea", "eebda", "eebea", "eecda", "eecea", "eefda", "eefea", "eegda", "eegea",
            "eehda", "eehea", "eeida", "eeiea", "eejda", "eejea", "eekda", "eekea", "eelda",
            "eelea", "eemda", "eemea", "eenda", "eenea", "eeoda", "eeoea", "eepda", "eepea",
            "eeeea", "ggggg", "agggg", "ahggg", "bgggg", "bhggg", "cgggg", "chggg", "dgggg",
            "dhggg", "egggg", "ehggg", "fgggg", "fhggg", "igggg", "ihggg", "jgggg", "jhggg",
            "kgggg", "khggg", "lgggg", "lhggg", "mgggg", "mhggg", "ngggg", "nhggg", "ogggg",
            "ohggg", "pgggg", "phggg", "hhggg", "hhagg", "hhahg", "hhbgg", "hhbhg", "hhcgg",
            "hhchg", "hhdgg", "hhdhg", "hhegg", "hhehg", "hhfgg", "hhfhg", "hhigg", "hhihg",
            "hhjgg", "hhjhg", "hhkgg", "hhkhg", "hhlgg", "hhlhg", "hhmgg", "hhmhg", "hhngg",
            "hhnhg", "hhogg", "hhohg", "hhpgg", "hhphg", "hhhhg", "ahhhg", "aihhg", "bhhhg",
            "bihhg", "chhhg", "cihhg", "dhhhg", "dihhg", "ehhhg", "eihhg", "fhhhg", "fihhg",
            "ghhhg", "gihhg", "jhhhg", "jihhg", "khhhg", "kihhg", "lhhhg", "lihhg", "mhhhg",
            "mihhg", "nhhhg", "nihhg", "ohhhg", "oihhg", "phhhg", "pihhg", "iihhg", "iiahg",
            "iiaig", "iibhg", "iibig", "iichg", "iicig", "iidhg", "iidig", "iiehg", "iieig",
            "iifhg", "iifig", "iighg", "iigig", "iijhg", "iijig", "iikhg", "iikig", "iilhg",
            "iilig", "iimhg", "iimig", "iinhg", "iinig", "iiohg", "iioig", "iiphg", "iipig",
            "iiiig", "aiiig", "ajiig", "biiig", "bjiig", "ciiig", "cjiig", "diiig", "djiig",
            "eiiig", "ejiig", "fiiig", "fjiig", "giiig", "gjiig", "hiiig", "hjiig", "kiiig",
            "kjiig", "liiig", "ljiig", "miiig", "mjiig", "niiig", "njiig", "oiiig", "ojiig",
            "piiig", "pjiig", "jjiig", "jjaig", "jjajg", "jjbig", "jjbjg", "jjcig", "jjcjg",
            "jjdig", "jjdjg", "jjeig", "jjejg", "jjfig", "jjfjg", "jjgig", "jjgjg", "jjhig",
            "jjhjg", "jjkig", "jjkjg", "jjlig", "jjljg", "jjmig", "jjmjg", "jjnig", "jjnjg",
            "jjoig", "jjojg", "jjpig", "jjpjg", "jjjjg", "ajjjg", "akjjg", "bjjjg", "bkjjg",
            "cjjjg", "ckjjg", "djjjg", "dkjjg", "ejjjg", "ekjjg", "fjjjg", "fkjjg", "gjjjg",
            "gkjjg", "hjjjg", "hkjjg", "ijjjg", "ikjjg", "ljjjg", "lkjjg", "mjjjg", "mkjjg",
            "njjjg", "nkjjg", "ojjjg", "okjjg", "pjjjg", "pkjjg", "kkjjg", "kkajg", "kkakg",
            "kkbjg", "kkbkg", "kkcjg", "kkckg", "kkdjg", "kkdkg", "kkejg", "kkekg", "kkfjg",
            "kkfkg", "kkgjg", "kkgkg", "kkhjg", "kkhkg", "kkijg", "kkikg", "kkljg", "kklkg",
            "kkmjg", "kkmkg", "kknjg", "kknkg", "kkojg", "kkokg", "kkpjg", "kkpkg", "kkkkg",
            "ggggx", "gggxx", "ggxxx", "gxxxx", "xxxxx", "xxxxy", "xxxyy", "xxyyy", "xyyyy",
            "yyyyy", "yyyyw", "yyyww", "yywww", "ywwww", "wwwww", "wwvww", "wvvww", "vvvww",
            "vvvwz", "avvwz", "aavwz", "aaawz", "aaaaz")
        val expected = listOf(
            listOf("aaaaa", "aaaaz", "aaawz", "aavwz", "avvwz", "vvvwz", "vvvww", "wvvww", "wwvww",
                "wwwww", "ywwww", "yywww", "yyyww", "yyyyw", "yyyyy", "xyyyy", "xxyyy", "xxxyy",
                "xxxxy", "xxxxx", "gxxxx", "ggxxx", "gggxx", "ggggx", "ggggg")
        )
        val result = WordLadderII().findLadders("aaaaa", "ggggg", wordList)
        val sortedActual = result.sortedBy { it.toString() }
        val sortedExpected = expected.sortedBy { it.toString() }
        assertEquals(sortedExpected, sortedActual)
    }

    @Test
    fun testExample6() {
        val wordList = arrayListOf("dose", "ends", "dine", "jars", "prow", "soap", "guns", "hops",
            "cray", "hove", "ella", "hour", "lens", "jive", "wiry", "earl", "mara", "part", "flue",
            "putt", "rory", "bull", "york", "ruts", "lily", "vamp", "bask", "peer", "boat", "dens",
            "lyre", "jets", "wide", "rile", "boos", "down", "path", "onyx", "mows", "toke", "soto",
            "dork", "nape", "mans", "loin", "jots", "male", "sits", "minn", "sale", "pets", "hugo",
            "woke", "suds", "rugs", "vole", "warp", "mite", "pews", "lips", "pals", "nigh", "sulk",
            "vice", "clod", "iowa", "gibe", "shad", "carl", "huns", "coot", "sera", "mils", "rose",
            "orly", "ford", "void", "time", "eloy", "risk", "veep", "reps", "dolt", "hens", "tray",
            "melt", "rung", "rich", "saga", "lust", "yews", "rode", "many", "cods", "rape", "last",
            "tile", "nosy", "take", "nope", "toni", "bank", "jock", "jody", "diss", "nips", "bake",
            "lima", "wore", "kins", "cult", "hart", "wuss", "tale", "sing", "lake", "bogy", "wigs",
            "kari", "magi", "bass", "pent", "tost", "fops", "bags", "duns", "will", "tart", "drug",
            "gale", "mold", "disk", "spay", "hows", "naps", "puss", "gina", "kara", "zorn", "boll",
            "cams", "boas", "rave", "sets", "lego", "hays", "judy", "chap", "live", "bahs", "ohio",
            "nibs", "cuts", "pups", "data", "kate", "rump", "hews", "mary", "stow", "fang", "bolt",
            "rues", "mesh", "mice", "rise", "rant", "dune", "jell", "laws", "jove", "bode", "sung",
            "nils", "vila", "mode", "hued", "cell", "fies", "swat", "wags", "nate", "wist", "honk",
            "goth", "told", "oise", "wail", "tels", "sore", "hunk", "mate", "luke", "tore", "bond",
            "bast", "vows", "ripe", "fond", "benz", "firs", "zeds", "wary", "baas", "wins", "pair",
            "tags", "cost", "woes", "buns", "lend", "bops", "code", "eddy", "siva", "oops", "toed",
            "bale", "hutu", "jolt", "rife", "darn", "tape", "bold", "cope", "cake", "wisp", "vats",
            "wave", "hems", "bill", "cord", "pert", "type", "kroc", "ucla", "albs", "yoko", "silt",
            "pock", "drub", "puny", "fads", "mull", "pray", "mole", "talc", "east", "slay", "jamb",
            "mill", "dung", "jack", "lynx", "nome", "leos", "lade", "sana", "tike", "cali", "toge",
            "pled", "mile", "mass", "leon", "sloe", "lube", "kans", "cory", "burs", "race", "toss",
            "mild", "tops", "maze", "city", "sadr", "bays", "poet", "volt", "laze", "gold", "zuni",
            "shea", "gags", "fist", "ping", "pope", "cora", "yaks", "cosy", "foci", "plan", "colo",
            "hume", "yowl", "craw", "pied", "toga", "lobs", "love", "lode", "duds", "bled", "juts",
            "gabs", "fink", "rock", "pant", "wipe", "pele", "suez", "nina", "ring", "okra", "warm",
            "lyle", "gape", "bead", "lead", "jane", "oink", "ware", "zibo", "inns", "mope", "hang",
            "made", "fobs", "gamy", "fort", "peak", "gill", "dino", "dina", "tier")
        val expected = listOf(
            listOf("nape", "nope", "mope", "mole", "mold", "mild"),
            listOf("nape", "naps", "nips", "nils", "mils", "mild"),
            listOf("nape", "rape", "ripe", "rile", "mile", "mild"),
            listOf("nape", "tape", "tale", "tile", "mile", "mild"),
            listOf("nape", "tape", "tale", "male", "mile", "mild"),
            listOf("nape", "nope", "mope", "mole", "mile", "mild"),
            listOf("nape", "nate", "mate", "mite", "mile", "mild"),
            listOf("nape", "gape", "gale", "male", "mile", "mild"),
            listOf("nape", "nate", "mate", "male", "mile", "mild")
        )
        val result = WordLadderII().findLadders("nape", "mild", wordList)
        val sortedActual = result.sortedBy { it.toString() }
        val sortedExpected = expected.sortedBy { it.toString() }
        assertEquals(sortedExpected, sortedActual)
    }
}