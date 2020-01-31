package babble.library

import babble.library.Library
import spock.lang.Specification

class LibrarySpec extends Specification {

    def "Library convenience method converts collection correctly" () {

        when:
        def subject = new Library(["foo", "bar", "baz"])

        then:
        subject.words.size() == 3
        subject.words[0] == "bar"
        subject.words[1] == "baz"
        subject.words[2] == "foo"
    }
}
