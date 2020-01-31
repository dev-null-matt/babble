package st.babble.library

import org.yaml.snakeyaml.Yaml

class Library {

    String[] words = []

    Library() {
        this(new File("src/main/resources/library.yml"), "library")
    }

    Library(File configFile, String libraryKey) {
        Map<String, Object> obj = new Yaml().load(new FileReader(configFile))
        this.words = (obj.get(libraryKey)as List<String>).toArray()
    }
}
