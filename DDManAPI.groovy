
#!/usr/bin/env groovy
// com/cleverbuilder/GlobalVars.groovy
package com.cleverbuilder

class GlobalVars {
    static String foo = "bar"
}

def call(String name = 'human') {
    echo "Hello, ${name}."
}

