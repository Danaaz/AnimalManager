Animal Coding Test
==================

Create a fixed version of the Animal Test program.

Rules for the test:
-------------------
We want to measure your knowledge of certain aspects of Java, and your ability to find, understand and solve the problems in the provided code. 

There are lots of bugs in logic, design and algorithms, and you have to:

* Make the program run according to the specification below:
* Make the code run without crashing.
* You can change the code as much as you want, provided the result is correct. 
* The specification has some ambiguities, so feel free to make assumptions where applicable (notice as a result there must be more than one valid solution).
* We value a simple elegant solution with solid code principles.
* You may use any version of the Java SE.


Program specification:
----------------------
* Initially there is one wolf and ten sheep.
* One wolf:
    - Eats one sheep per update.
    - Always eats the last sheep to have been added.
* Each sheep:
    1. If the sheep has never had a partner.
         1. The sheep will attempt to find a free partner.
    2. Then if the sheep has a living partner:
        1. The sheep gives birth to one lamb per update.
        2. Once the sheep has had three lambs, it dies.
* The system will be updated six times.
* The world state should be printed for each cycle, giving the number of living sheep, dead sheep and wolves.
