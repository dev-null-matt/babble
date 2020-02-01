package babble.hash

import com.google.common.hash.HashFunction
import com.google.common.hash.Hashing
import babble.dictionary.Dictionary

class BabbleHash {

    HashFunction hashFunction
    Dictionary dictionary

    BabbleHash(HashFunction hashFunction = Hashing.murmur3_128(), Dictionary dictionary = new Dictionary()) {
        this.hashFunction = hashFunction
        this.dictionary = dictionary
    }

    String hash(String input) {

        byte[] bytes = hashFunction.hashBytes(input.getBytes()).asBytes()

        int segmentLength = (bytes.length - 2) / 2

        byte[] bytes1 = bytes[0..segmentLength - 1]
        byte[] bytes2 = bytes[segmentLength..segmentLength * 2 - 1]
        byte[] bytes3 = bytes[segmentLength * 2..segmentLength * 2 + 1]

        return "${getWord(bytes1)}${getWord(bytes2)}${formatNumeric(new BigInteger(1, bytes3).toString())}"
    }

    String formatNumeric(String numeric) {
        "00000${numeric}".substring(numeric.length())
    }

    String getWord(byte[] indexBytes) {
        return dictionary.getWord(indexBytes).capitalize()
    }

    static void main(String[] args) {

        BabbleHash babbleHash = new BabbleHash()

        println babbleHash.hash("matthew.rick@smartthings.com")
    }
}
