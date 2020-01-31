package babble

import babble.hash.BabbleHash

class Babble {

    static void main(String[] args) {

        BabbleHash hb = new BabbleHash()

        ["brit.indrelie@smartthings.com",
         "matthew.rick@smartthings.com",
         "john.landa@smartthings.com",
         "lance.linder@smartthings.com",
         "richard.biga@smartthings.com",
         "jeff.beck@smartthings.com",
         "chris.smith@smartthings.com",
         "aaron.huus@smartthings.com",
         "dave.hastings@smartthings.com",
         "ryan.tubs@smartthings.com",
         "steven.stack@smartthings.com",
         "erik.jordan@smartthings.com",
         "josh.klun@smartthings.com"
        ].each {
            println("${it}  ->  ${hb.hash(it)}")
        }
    }
}