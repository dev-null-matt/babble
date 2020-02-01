package babble.dictionary


import spock.lang.Specification

class DictionarySpec extends Specification {

    def "Dictionary convenience constructor converts collection correctly" () {

        when:
        def subject = new Dictionary(["foo", "bar", "baz"])

        then:
        subject.words.size() == 3
        subject.words[0] == "bar"
        subject.words[1] == "baz"
        subject.words[2] == "foo"
    }
}
