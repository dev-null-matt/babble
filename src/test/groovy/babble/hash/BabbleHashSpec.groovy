package babble.hash

import babble.library.Library
import spock.lang.Specification

class BabbleHashSpec extends Specification {

    def "builds a consistent hash value"() {

        given:
        def subject = new BabbleHash(library: new Library(["aaa", "bbb", "ccc", "ddd"]))

        when:
        def result1 = subject.hash(input)
        def result2 = subject.hash(input)

        then:
        result1 == result2

        where:
        input                   | _
        "foo@bar.com"           | _
        "aaabbbccc"             | _
        "another random string" | _
    }
}
