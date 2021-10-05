import LeetCode.Companion.calculateTime
import LeetCode.Companion.kidsWithTheGreatestNumberOfCandies
import LeetCode.Companion.numberOfGoodPairs
import LeetCode.Companion.rangeSumBST
import LeetCode.Companion.smallerNumbersThanCurrent
import LeetCode.Companion.toLowerCase
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@Suppress("UnusedPrivateMember")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LeetCodeTest {
    private fun provideArgumentForGreatestCandies() = Stream.of(
        TestData(Pair(intArrayOf(2, 3, 5, 1, 3), 3), listOf(true, true, true, false, true)),
        TestData(Pair(intArrayOf(4, 2, 1, 1, 2), 1), listOf(true, false, false, false, false)),
        TestData(Pair(intArrayOf(12, 1, 12), 10), listOf(true, false, true))
    )

    @ParameterizedTest
    @MethodSource("provideArgumentForGreatestCandies")
    fun `1431 Kids With the Greatest Number of Candies`(testData: TestData) {
        val casted = testData.given as Pair<*, *>
        kidsWithTheGreatestNumberOfCandies(casted.first as IntArray, casted.second as Int)
        assertEquals(
            kidsWithTheGreatestNumberOfCandies(casted.first as IntArray, casted.second as Int),
            testData.expected
        )
    }

    private fun toLowerCaseProvider() = Stream.of(
        TestData("Hello", "hello"),
        TestData("here", "here"),
        TestData("LOVELY", "lovely"),
    )

    @ParameterizedTest
    @MethodSource("toLowerCaseProvider")
    fun `709 To Lower Case`(testData: TestData) {
        assertEquals(toLowerCase(testData.given as String), testData.expected as String)
    }

    private fun numberOfGoodParisProvider() = Stream.of(
        TestData(intArrayOf(1, 2, 3, 1, 1, 3), 4),
        TestData(intArrayOf(1, 1, 1, 1), 6),
        TestData(intArrayOf(1, 2, 3), 0)
    )

    @ParameterizedTest
    @MethodSource("numberOfGoodParisProvider")
    fun `1512 Number of Good Pairs`(testData: TestData) {
        assertEquals(numberOfGoodPairs(testData.given as IntArray), testData.expected as Int)
    }

    private fun rangeSumBSTProvider() = Stream.of(
        TestData(
            mapOf(
                TreeNode(10, TreeNode(5, TreeNode(3), TreeNode(7)), TreeNode(15, null, TreeNode(18))) to intArrayOf(
                    7,
                    15
                )
            ), 32
        )
    )

    @ParameterizedTest
    @MethodSource("rangeSumBSTProvider")
    fun `938 Range Sum of BST`(testData: TestData) {
        val input = testData.given as Map<TreeNode, IntArray>
        val expected = testData.expected
        val root = input.keys.first()
        val low = input.values.first().first()
        val high = input.values.first()[1]
        assertEquals(expected, rangeSumBST(root, low, high))
    }

    @Test
    fun `346 Moving Average from Data Stream`() {
        val movingAverage = MovingAverage(3)
        assertEquals(1.0, movingAverage.next(1))
        assertEquals(5.5, movingAverage.next(10))
        assertEquals(4.666666666666667, movingAverage.next(3))
        assertEquals(6.0, movingAverage.next(5))
    }

    @Test
    fun `1603 Design Parking System`() {
        val parkingSystem = ParkingSystem(1, 1, 0)
        assertEquals(true, parkingSystem.addCar(1))
        assertEquals(true, parkingSystem.addCar(2))
        assertEquals(false, parkingSystem.addCar(3))
        assertEquals(false, parkingSystem.addCar(1))
    }

    private fun numbersAreSmallerProvider() = Stream.of(
        TestData(intArrayOf(8, 1, 2, 2, 3), intArrayOf(4, 0, 1, 1, 3)),
        TestData(intArrayOf(7, 7, 7, 7), intArrayOf(0, 0, 0, 0))
    )

    @ParameterizedTest
    @MethodSource("numbersAreSmallerProvider")
    fun `1365 How Many Numbers Are Smaller Than the Current Number`(testData: TestData) {
        assertArrayEquals(testData.expected as IntArray, smallerNumbersThanCurrent(testData.given as IntArray))
    }

    @Suppress("MaxLineLength")
    private fun singleRowKeyboardProvider() = Stream.of(
        TestData(Pair("abcdefghijklmnopqrstuvwxyz", "cba"), 4),
        TestData(Pair("pqrstuvwxyzabcdefghijklmno", "leetcode"), 73),
        TestData(
            Pair(
                "pyevcountbgjklxfqwimrdhazs",
                "gxafwhexxykisciactyfdyfixqfchwanvmsjwycyyznpkykfkgfwpaajiqftklahgergnyxunfbmvkiyrifljolkkvcmdsimnmmdulqpirbdkhalakgsgomlnxivjqgbamnylecwmnulldjueppxptrjbyrijrqvagqklnglegiqoumqxftarrkhlkxufqhsqeacwzfonupihnjyzzwnrutdkcwtehzyjgvvsgevxewyhzhkwpoxkjjafdivqsabiayrgeytmkxtzhjeynttovyldlhfyfzwbfzaweoghgfyyblrrcqjzajmsjormweeqyzsiuqsgyoddkgzxskwpytbysvroanpplwjnucowvwdhimvjnosezxhrxswxlfyfqmiuyvrbngigbldvbejqlrnqffkhjdftnkgusegtpasapuwldmlmnxzxhckopukczpsbkqjdhonydgjdlfpldqawrzqojjulizkwvaoxykzmrupoaafwpvexihbrjjwxtzbjvdfqwrajuvlnxudwpqqqvzvfmfvesrqqfvugqhtavwemmonxwnmhblutoaafvbvkuhgbjnduwtsckhjnsnlmfaghqejyzmibbwzflskzfcycnjpebsmlihbetehuomyyhnnqthonqtxigfioarksrhwgjiirlwnaqnadbyrvtyxhrsezkdkfgawlfuchsugturgibjozlplqymlczcbmybntqosaxpmqijcljyqrkocsjvaqdqsfqfhmdzxudqvsxbsvgijquzbxktwqgexjiqgkbdowmjypybkprxmmhzhnogjhzpbgrkphqywunzeijgqzreonyrkheeoltbruxndrdnhuwstxsdzhnoqmngtbjynlijjlbopnderookdpcdqeqtkwrqdiplysdjvojhxylxcxqrjtdirwswdtlvrytdxrlwhmdegsqmhaazhdtozzwomgbwppcfbyhwmpzobvpnqbmzvtqworqlnuthhfkshbgpohlhopedlvfuuqcmsgewtkuuxocdzyejbhmihjjgdxaspcthpwtxzzvzxitemwjbquuepgcqpgilpsekkendrpxzfmfdjtelrhjiqbmofjarzywltvbjhjpcitoatpcnhovanuuvlcnhkfedzksmhywcnlslamdztgitssswkbgmdkjzqjioxontjluwfkyaejkvquqcixbcicxbgreyzdkgnxspuxusudyxqlojhifwpfziqjhgyharrsyhqacnlewifrxgggvxhfaqjcthzhspvyrxswmvkwkyqgfaltzgqyoemgqbxquufjalezvvjdurcazdirrljhauabesfkpzkskbwzrluazbovmveecgkwwpzxqrpwxfsiukjpfzxryndoofohvvramxfdbtyqzcstqjesshrcygtctkymeimreyszmddhqxyqurcxlnkksylixnfgrswwvrsrqpknvvcnhimbklsixqmdmcnmzrnbdswtfyuqnzlsqwqgologslbpokjudvvyvzcaxyaepdwtwdndslhswhnbpmphasxkglrukhmbjssdcgkiohelcdvoofvucgqotqiwmgxynjuggscsahqocuutariwloclmwigjbejrxvujxtjvbmgvfhpowxmniruncakpunfhjkunrzzzdteqomdsvjoegijuyggwjjibovzjjeycpvnmupdosrcsdvblhtvrykqljkhtbdboxwfzyhmuyqnaxctkfmiqogqqbvhkourtjahbqnnkvifsxdxqtcolgvqlrujumzgqcoxifwrrfgpyfgmlqpnamcvkjjjwybzgbyooatvnzpxdvloxivkrvtjbnnbqwtbrsfdswtknbaaggqcuclaxwqsoeuxunnnzfbsgmhpcpktiluazzkzaivzgyttccbpptaegucsbvirrafwxrkbconutpwsusseutxrypzhmvttvpftdbjhkfhctphrbzoszatydweonydryatfsibdhjwhegptkcikinentiazxugcdlpzmdayxjsgcjqtkdfvbkpmmiyjzyiwpvqsooucnmpquxbpjhltxmiqxhbcmoesxhdcpbuukosxnzmizsigrzdgtkpuprnpogpmegojfdwvupldjtglnkbszsmhnrhlqpkbtfulyfuqliovvovtcmayoqyxujrpwndfbzsmftpksoyoepkmablhiunnuybawetbvojblrgmenxfpmiomhgpqpyjrpvhrslxgnfhsajnfjslfiuoybumzmbigxkmmobsusdyzzuyrzieoxdrtescnnwxmleriqrbxwimfqqwnakfangowwauvoqtoxklvtvmyyjwvjcfrwtbxwrhvnatndbtvxxmprqkyjltmprfdasdhpgbkpeqmtzbqiuivwvxhpmcsnfgbejwewwilhfutrirbvmxnhsypoqhlptwqouawletsdklwusgyfjrlvrpwnionjtljnehbzyfxgveedbefowrzmnovtpiyfoemirwrfkmilpupmmldkoyjrbwmbjhnwunrmfrgovfwnkrcxkqjxscgpqxrgikqskqzwfqwnpebizmyuzqykoosskuveznhbohhdseshqniuocdxkbpwdkoyozmajyrhnppldvaltuscbhsqowpzsvlqrfjuvsrdsamqqqacxkzsxnbamqeoxnkevrelayinwdaypcxwiycpuktbdhxehpcatddkocanpgjmdglnoamallknslqdmyxilnmsddotlfztmurzmsiebwpgqkmmqyexclykoxawiidaykmalwjyrsmoumrsbhnqxjkqopwqipzqrnxdixqkqjbsbttdddyryccaccfafaqeumjeeryqteenfjmiyyauvgvagltgsndfrsxkasimlveesfxoqlynjabtzryosvhkdnodqnsgezkgrzidceyzisyryrhjkysjnqyswylbejrahoxvvhcscnqgdsaahvmldnphmwogikjyrauonlztpgyqcwylhzmbwdztdpahusbysqplhimbltdvtycqxisnipapxeoqtlhtkvivnwbhfgmxhdcaiqdmpxfuqoxtxakwswdnqycjwqwryirnxqgohnbbqogobroifsmwjtjzdzrtulkjynqxbnoyjbwosfodnbcdauosglhsjqfcnnbsarxxgkhbtxbdloukycpcoypvxogmfcerljogtrlzcqrlogulbiyfsesjybmmdytlmkbwefuvsmtjcojfxpapkqjwvhtyqwmzxdystgozdgogqbdqhvlkspuxxqfiacdvnzhibgfzuzakqqswoacytfsdhzesxksgimhwkvddzfyakjmzlgknmndytphqaunghtuhjkkjyicqgmjvxcutwoiqvqxfawzwuuikgjqrfdnfcqqwvwgvjffetmwcfemyuhzyvicqkezagbtrqvlsircpmaeczdujtqnlsyfumbqfouxhpmwrzaciqzfpkzkcscjaichjjsyftwjltcsnmbxsozyltyuyjbujgvsahibnagwwwkacqyrjkiftcpklkxnysytqoyhibqqpdgzmkynbwpndnsnxmarnhtwhunedneftdpenrykljvcdkknvitlyjznvaeqgdozvrxooqfgmvhnqxgrfravsxlkwlenrruibwrjoupgsqpvreryybmcuujimjqzidssolfevezfnsqmmixzsnhifjjmyjxoqzzfmmqdmomfayoguaqqhbzershztalosxventouwznjxohsekrtypunhlhhatckxnkqeujlgnoftnsteuxbdgpfwywhfmwszecborzrhgbeymiluidtrksraewipnjlcsngbjfxsjrofyroxdfcxsorakmefkdngohelizojjjncebhvvvphikvgippueimhwtfuedgloidjuyswvmqfvvphffxhoebbsatwswvsabbwrdbpfmvoegjlxzsguvetalhonbbsmnfafxxniadcjrmihctihttueaaumhoqivnkihelnjgntspgikzeysmiwdwwkkroblisdaddfshrcnjveeijvqdkmltmblbaifgzswboznvbmqeeqxjxlnizyydokojyrbdmmyzhdyebqzxqkohofgrvemrxorljvnfztnriartlzzikkzhbkjmpygeqpxbemnivpslvmcdrfekyrgofwcenkqtlogdptigkrgpthxiitjdsuxmlghvdsitwcuuoiaywzzdabarxouicuftepjydddlqtrcthrysgxlqebjnkreedlfqdezlkltuyhkcqguwtlzdmfdmaueafwjmrvzopqqszoluiokyoleadpgncpbbjbowtwxvfhtktqdtpuavgapekgogugcoidveqfatsnknvzsnzdijfagdvyskkaowwlacxtvynmkgckusacwbimgrlmpzfahdpkznmgapxomjqkawrtnzojjnihfjjwjvrsppiksqhqlgusmuwlomatlqpveqnmvazrwuadfiluktpsuzynmkngwwhakouaqxhohryfncgweyagjdwqkgfunhvxztdevtuioqzmepdniiysbzbkxivvpzqbyftzkakvdsconhnmycksledkiubhnvifliekqsucxivrxmpjeorrenthlfvawdnnmnujdsxdibtvvjqghxaklrubelvpufrzmshnuvmbvdbskaozdzszxuimsmjgwfexpvzqvfvbatcyyudkfmbyxdcayraydfogvmomqqriamcipkhoohvenkbcieqbzohqoejnujduwwbkmpnuzqyxnlzvbopeoasepgxgtxfimxsvzkohluzjqykzfnkdiaradcbhpqlcjqhmmuuwawynzyvzjulbkikvuerljdfrxquljjzlcjoxpgsqznuxykghydkqaybghxixeqnhtmnxlrgkcctjvnktcppnbeoocegxnwavtxxnyyqoiwihxmusviqumficjvsbsfqxszdcgboppsipnmghyaxcbzqaqfyitatqxantamritaynlahfnivgdvwexltgvpyuyqmdvhaglcbkqqbnerkwodjaniwuvippzuxambcvnjhyjngbfdctfzmdzydrhiinbzwrdjfiqjiehjexbqqdzvsqoitdfrfjauebfgklzkhrwrdcnxptrbaqzrwhlclzozixzqtsdploalrpkcbfecwakawamxqgfgxqtozyxswtpxeubtxjbcpqdxbegdjzxyqpmynsoeizdgrusdjfwxdqpgagxivuhnvbfkzyedcvuvviqdwoogjiohedhkjtmvolohkwdxivkpknrzwybvyvzgwpfmphhyikahqhcmqfgjlqtfxsmlcwityahsbscpqeizuvovzhkgjsszdnibvmkjpsgoxedclcrlvvmbuuomodgdwxlgurerxiovfdifofvohbeaqhzxlccyqopjcaiiawzqggqhiibhtcicxxnygdtimeoiiegnesserbrmczmvsctcmxtbpuuotcgilvampmbvtmocbwqbqqweanmqosttoczdmfkdtdsefeirypczqmegpzqfgiwmmvtggaggbgzsdjjupnipffyyabftxuckdcebapbhkjycdavlfgkiititnqgmykosvgfgvpienqvbftjsfhvsxnjklycalqxskwdoizdffwrszljkkvugggvicbxhslpvygssebblxugnsnwgqrsmboqtqzfjuaiyleuxycwedmjiovyzyvzsoypoohcufxftbkiffowxwhjtlnztbvwimhofnvcibzvkoneuszylbmaydsrbqaygtzqevtsufxpzijztftwniizuccexlrcfbyiiyohtbrbnlccmhmbpoxcfeeakndsllmjfazugxubpwbjqtkwuzkkjzdkwacxwosljycxfuffzbzknnbspidtbzasxlrhaeylslczfszgdrqkvcfwmuweqmoctzuyicbqpvzomtfaienpkcitijxymixqsujyovmhavxjxzckbvvemxcobkjajmqhjqxtnjhrxvefgyrowbsgizzckgbhgatqyxptdzumtgnhtevrzowkdwlleuohcceqoblzsmtnucshmwyrzvsdlgvwuxamjwyfhmxiyrlztlgzbzrgtlcohwytbrnsuftirarmubqjrmxnmkudptiaxfnwrfmiuqvyiljtjmlunchelckaigvfokttwvlnchbtpsinfvpsdzmkgfeigraosyfleiorumsaeqvgzncofcltgowmjoccnqpezjeonxghbxccldtcoykrntkyztgtspzhmenviunitoazwlvktdbgiadocnuvgxdwpwnpkrfasajtpcgeyjkbyjlgscejedhighludhpaznvgwmwzdtidotzjxisjkzprqmnwdrcqjdudzmivrkxgugcogtmaafupjqvhsagspwkdazjdjjmilpjhooubrvwxmwctgplgdsaujxdpgzhohffyafgkfxdkqsqadkwwdxjptryzjhsseqpgfdpefpbskvnfuvmtynsdzavupcdfecspnpqgfdkcnnpeoisojpftrhdppnjuloqoqrfhctrgtkmeqlzltnexeivpbfomrnftrzpaqnxpbthuqlihnoytwhelrhuhvcmiocyscxdsfqbqsfompvaxseoykbsknritjybarukxembzoowynkjxuporusjhezzwbdprmpgyxbzktiwubotwbleyzrqhnpajopklqksbfeixtvrebzrokoojpegdnrrtwlrcyfiabfauohrkeweyepfrjntxouxxghkabjbucnhzkstaafsgugjtxtzwdcvvgbwlseiqaxjissvhhxpxxarnfpwkcfbvecnlzlsomadlfabgxckuqjatvbfrddxcovnigerkzdavogizmqhyjmiyzttfxvscaaqjnjtlknyyyihfpvtierrjdybjfibvcfrpttuidtctpkaxvljturvmylgihazgtusycfgkqwmacpspiarqyumgstdbqntouptvjqmysdghtmgflzhjzwoyoxvpmaoeepzavnqpmzsszlkeiqmmhufoxahkiqvbvovdqqgojutqmrutguvusosdtfkzkmrcdeslqukzqncyfcpxsrgyzkkzemqmitqmdlfwmdvgeercsdtsmzjmnyewzmgkxncutuvfwozlifxxtxdwzufgevzrunqdhuoicvdueudxocnyruuqwylaujftanbaidzwaiaqzxcrmkshazhbaelzwnaqtkrjtexiskzrofqjzxtsjceiqldhsedyewqczqslccsrrijevqchauzkopwnmzsbjrypfdtaeycgidfhqggewingnihrnwbnmuhtayqqhlwnmmyuibwfhqgemkxgyoumtorkanclrhtupsklvhsolcejvhixmnblugbxciifmvkwauhuywvbuutzktocgcngzkvnwvrjdmoibalwxgxfbubupwisbajtuuxoxpdouqmdaezocfbpkeqezkmrugupulxgtpnlwlfunjuaatfzrggrotfsehswepguoapdpvtfgkyheqwbnpoowafotdzzowxyhxehfrekejjhzctdtqssthcmvmaznatprnjitwflwytwuwlknzwrnpnrymjeeljhyypokdjgiszpozrhojjebxjfrfoxatxhi"
            ), 66042
        ),
    )

    @ParameterizedTest
    @MethodSource("singleRowKeyboardProvider")
    fun `1165 Single-Row Keyboard`(testData: TestData) {
        val given = testData.given as Pair<*, *>
        assertEquals(testData.expected as Int, calculateTime(given.first as String, given.second as String))
    }
}

data class TestData(val given: Any, val expected: Any)
