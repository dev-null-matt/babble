package st.babble

import com.google.common.hash.Hashing
import st.babble.hash.HashBuilder

class Babble {

    static void main(String[] args) {

        HashBuilder hb = new HashBuilder(Hashing.sha256())

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