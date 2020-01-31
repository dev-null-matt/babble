package st.babble

import com.google.common.hash.Hashing
import org.yaml.snakeyaml.Yaml

class Babble {

    static void main(String[] args) {

        Babble b = new Babble()

        ["brit.indrelie@smartthings.com",
         "matthew.rick@smartthings.com",
         "john.landa@smartthings.com",
         "lance.linder@smartthings.com",
         "richard.biga@smartthings.com",
         "jeff.beck@smartthings.com",
         "chris.smith@smartthings.com",
         "aaron.huus@smartthings.com",
         "dave.hastings@smartthings.com",
         "ryan.tubs@smartthings.com",
         "steven.stack@smartthings.com",
         "erik.jordan@smartthings.com",
         "josh.klun@smartthings.com"
        ].each {
            println("${it}  ->  ${b.getWord(it)}")
        }
    }

    Babble() {
        Map<String, Object> obj = new Yaml().load(new FileReader(new File("src/main/resources/words.yml")))
        this.words = (obj.get("words") as List<String>).toArray()
    }

    String[] words = []

    String getWord(String input) {

        byte[] bytes = Hashing.murmur3_128().hashBytes(input.getBytes()).toString().getBytes()
        byte[] bytes1 = bytes[0..14]
        byte[] bytes2 = bytes[15..29]
        byte[] bytes3 = bytes[30..31]

        return "${getWord(bytes1)}${getWord(bytes2)}${String.format("%05X", new BigInteger(bytes3))}"
    }

    String getWord(byte[] index) {
        return words[new BigInteger(index).mod(words.length).intValue()].capitalize()
    }
}