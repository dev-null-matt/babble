package babble.dictionary

import org.yaml.snakeyaml.Yaml

class Dictionary {

    String[] words = []

    Dictionary() {
        this(new File("src/main/resources/dictionary.yml"), "words")
    }

    Dictionary(File configFile, String libraryKey) {
        Map<String, Object> obj = new Yaml().load(new FileReader(configFile))
        this.words = (obj.get(libraryKey)as List<String>).toArray()
    }

    Dictionary(Collection<String> library) {
        this.words = library.sort().toArray()
    }

    String getWord(byte[] indexBytes) {
        words[new BigInteger(indexBytes).mod(words.length).intValue()]
    }
}
