# CodingExerciseA3M4J4

JAVA CODING TEST

This test consists of three questions.  While solving the problems, please pay attention to correctness of
the solution as well as coding style, such as cleanliness, error handling and resource control. You have
120 minutes to complete this test and email results back. Please zip up your Eclipse workspace and
attach to the response email. Response to the modeling question can be simply a scan of a handwritten
note or MS Paint picture.

Test A3 – Translate currency to English
In Eclipse environment, write and execute program which:
1. Creates a test text file with a number of lines. Each line should contain dollar
amount between $1 and $20, with dot as a separator between whole dollars and
cents. There should be no dollar sign but amounts with whole dollar amount may
omit decimal point, so 80, 80.0 and 80.00 are valid inputs.
1. Reads the test file and parses input into BigDecimal instances. Invalid input should
be skipped.
2. Writes results of step 2 into a new file, each line should contain English word
representation of the amount, e.g. amount 11.45 should be represented as
&quot;eleven dollars and forty five cents&quot;, like on a check.

Test M4 – Theater Ticket Sales Application
You are about to write a ticket sale system for a cinema. Please draw an UML diagram including the
following entities: THEATHRE, SCREEN (the room where movie is played), SEAT, MOVIE, PATRON,
BANK.

Test J4
In Eclipse environment, write:
1. A service with one method, which accepts an integer and:
a. Throws an exception if input argument is negative
a. Returns an array for integers containing prime numbers within the range between
0 and the input argument
1. Write Junit tests to verify that:
a. Service throws exception if argument is negative
b. For positive arguments, none of returned values in the array are outside of range 0
&lt; x &lt; input value.
c. For positive arguments, returned values in the array are prime numbers.
