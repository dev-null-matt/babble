# babble
A simple hashing library designed to create easy (for humans) to remember hash values

## Usage
Babble hash creates a hash value that is optimized for humans to remember the generated value.  The hash value consists of common English dictionary words and a short string of digits.

```
BabbleHash bh = new BabbleHash()

bh.hash("foo@bar.com") // output is "ForestCloud03264"
```

### Custom Libraries
Babble by default tries to create an inoffensive hash value by using a curated library of words.  If you want to use a different library of words, you can load a custom library from a yaml file.  Bear in mind that a small library could lead to hash collisions.

The size of the hash set for the default babble implementation is `library_size ^ 2 * 2 ^ 16`.

```
// Construct the library from a java.util.Collection
Library collectionLib = new Library(["fox", "kilo", "alpha"])
BabbleHash collectionHash = new BabbleHash(library: collectionLib)

// Read library from a yaml file
Library yamlLib = new Library(new File("path/to/file", "yamlKey")
BabbleHash yamlHash = new BabbleHash(library: yamlLib)
```

### Custom Hashing Functions
Babble by default will use a 32 byte murmur3 hash to digest the supplied string to hash. If desired, this algorithm can be replaced with a different one, for example, if a cryptographic hash is desired. Guave `Hashing` contains a variety of hash functions that can be passed to the `BabbleHash` class's constructor.

```
BabbleHash cryptoHash = new BabbleHash(hashFunction: Hashing.sha256())
```