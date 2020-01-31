# babble
A simple hashing library designed to create easy (for humans) to remember hash values

## Usage
Babble hash creates a hash value that is optimized for humans to remember the generated value.  The hash value consists of common English dictionary words and a short string of digits.

```
HashBuilder hb = new HashBuilder()

hb.hash("foo@bar.com") // output is "ForestCloud03264"
```

### Custom Libraries
Babble by default tries to create an inoffensive hash value by using a curated library of words.  If you want to use a different library of words, you can load a custom library from a yaml file.  Bear in mind that a small library could lead to hash collisions.

The size of the hash set for the default babble implementation is `library_size ^ 2 * 2 ^ 16`.

```
HashBuilder hb = new HashBuilder(new Library(new File("path/to/file", "yamlKey"))
```