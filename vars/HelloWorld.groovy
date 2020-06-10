#!/usr/bin/env groovy

// def call(Closure context = {}) {
//     def config = [:]
//     context.resolveStrategy = Closure.DELEGATE_FIRST
//     context.delegate = config
//     context()

//     hello()
// }

// def call(String name = 'human') {
//   echo "Hello, ${name}."
// }

def hey(String name = 'human'){
    echo "Hey, ${name}."
}

def hello(){
    echo "Hello, ${name}."
    println("Hello, ${name}.")
}

// void hello(){
//     echo "Hello, ${name}."
//     println("Hello, ${name}.")
// }
