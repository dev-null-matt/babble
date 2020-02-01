package babble.hash

import babble.dictionary.Dictionary
import com.google.common.hash.HashCode
import com.google.common.hash.HashFunction
import spock.lang.Specification

class BabbleHashSpec extends Specification {

    def "builds a consistent hash value"() {

        given:
        def subject = new BabbleHash(dictionary: new Dictionary(["aaa", "bbb", "ccc", "ddd"]))

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

    def "Correctly splits the byte array from the hashed string"() {

        given:
        def dictionary = Mock(Dictionary.class)
        def hashFunction = Mock(HashFunction.class)
        def subject = new BabbleHash(dictionary: dictionary, hashFunction: hashFunction)

        byte[] fooBytes = firstBytes
        byte[] barBytes = secondBytes

        when:
        def actual = subject.hash("")

        then:
        1 * dictionary.getWord(fooBytes) >> "foo"
        1 * dictionary.getWord(barBytes) >> "bar"
        1 * hashFunction.hashBytes(_) >> hashCode

        and:
        actual == expected

        where:
        hashCode                                   | firstBytes                | secondBytes              | expected
        hash([100, 55, 50, 100] as byte[])         | [100 as byte]             | [55 as byte]             | "FooBar12900"
        hash([100, 90, 55, 54, 50, 100] as byte[]) | [100 as byte, 90 as byte] | [55 as byte, 54 as byte] | "FooBar12900"

    }

    def "Correctly formats the numeric segment of the name, by padding to 5 characters"() {

        given:
        def subject = new BabbleHash()

        when:
        def actual = subject.formatNumeric(input)

        then:
        actual == expected

        where:
        input   | expected
        ""      | "00000"
        "a"     | "0000a"
        "bb"    | "000bb"
        "ccc"   | "00ccc"
        "dddd"  | "0dddd"
        "eeeee" | "eeeee"
    }

    HashCode hash(byte[] byteHash) {
        return new HashCode.BytesHashCode(byteHash)
    }
}
