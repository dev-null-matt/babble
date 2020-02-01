package babble.hash

import com.google.common.hash.HashFunction
import com.google.common.hash.Hashing
import babble.dictionary.Dictionary

class BabbleHash {

    HashFunction hashFunction
    Dictionary library

    BabbleHash(HashFunction hashFunction = Hashing.murmur3_32(), Dictionary library = new Dictionary()) {
        this.hashFunction = hashFunction
        this.library = library
    }

    String hash(String input) {

        byte[] bytes = hashFunction.hashBytes(input.getBytes()).toString().getBytes()

        int segmentLength = (bytes.length - 2) / 2

        byte[] bytes1 = bytes[0..segmentLength - 1]
        byte[] bytes2 = bytes[segmentLength..segmentLength * 2 - 1]
        byte[] bytes3 = bytes[segmentLength * 2..segmentLength * 2 + 1]

        return "${getWord(bytes1)}${getWord(bytes2)}${String.format("%05X", new BigInteger(bytes3))}"
    }

    String getWord(byte[] indexBytes) {
        return library.getWord(indexBytes).capitalize()
    }
}
