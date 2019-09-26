Program 2
---------
In this assignment, you will implement some basic data structures and algorithms relating to linked
lists, stacks, and queues.

Doubly Linked List
------------------
Fill in the empty method stubs in `java/src/edu/berkeley/cs/util/LinkedList.java` with the
implementation for a doubly linked list. Ensure that your implementation has `O(1)` runtime for the
following operations:

- `insertFront(...)`
- `insertEnd(...)`
- `removeFront(...)`
- `removeEnd(...)`
- `front(...)`
- `back(...)`
- `size(...)`: track the size of the list in a variable, update when `insert/remove` methods called
- `isEmpty(...)`

Note: data structure operations are tricky to do in your head. For example, `remove(...)` has a lot
of corner cases and can be tricky to get right. Try drawing out the data structure on a piece of
paper, working through each individual step of the operations above, and then converting the steps
to code.

Move to Front
-------------
If the order that items in a list are stored is not important, you can frequently speed up searching
with a heuristic known as move to front. Whenever an item is accessed, move it to the front of the
list. This action usually results in an improvement because frequently accessed items tend to
migrate toward the front of the list, whereas less frequently accessed items tend to migrate toward
the end of the list. Consequently, the time complexity of `contains(...)` is often much less than
`O(n)` because the most frequently accessed items tend to require the least searching.

Extend the `LinkedList` class in `java/src/edu/berkeley/cs/util/SplayList.java` to implement the
move-to-front heuristic for linked lists.

Note: `front(...)` and `back(...)` should not implement the move-to-front heuristic.

Stack and Queue
---------------
A completed stack and queue implementation is available in the following files:

- `java/src/edu/berkeley/cs/util/Stack.java`
- `java/src/edu/berkeley/cs/util/Queue.java`

The stack and queue implementations are simply wrappers around the linked list implementation that
you wrote in the previous section of this assignment. Reusing the doubly linked list class in this
way allowed us to create a whole new set of data structures, simply by restricting certain access
patterns on the doubly linked list. Read and understand the implementation. Then read and understand
the unit tests that ensure the stack and queue work properly.

- `java/test/edu/berkeley/cs/util/Stack_T.java`
- `java/test/edu/berkeley/cs/util/Queue_T.java`

Calculator
----------
Dijkstra's two stack algorithm, as presented in class, is a simpler version of Dijkstra's real
algorithm. As presented, it has a serious limitation. It relies on the use of parenthesis to know
when to execute an operation and store a result on the stack. However, we cannot always rely on
input expressions to include parenthesis. For example, our algorithm should be able to compute the
expression `2 + 4 * 2 = 10`, knowing that the `*` operator has higher precedence than the `+`
operator, without the requirement of parenthesis as a guide.

Below is a slightly more advanced version of the algorithm with order of operations support built
in.

- Declare two stacks: values and operators
- Split input (by spaces) into tokens
- Process each token one by one
  - If value, push onto value stack
  - If operator
    - If operator stack is empty, push input operator onto operator stack
    - If input operator precedence is greater than precedence of top of operator stack, push input
      operator onto operator stack
    - If input operator precedence is less than or equal to precedence of top of operator stack
      - Repeat until operator stack is empty or token at top of operator stack has lower precedence
        than input operator
        - Pop two value tokens from value stack
        - Pop operator token from operator stack
        - Apply operator to value tokens
        - Push result onto value stack
      - Push input operator
- Upon reaching end of input, process operators remaining on operator stack until the operator stack
  is empty
- Result is single element remaining on top of value stack

Implement the above algorithm within `java/src/edu/berkeley/cs/app/Calculator.java`. Your
implementation should support the following operations:

- Addition
- Subtraction
- Multiplication
- Division
- Exponents (`^`)

Some starter code is already available in order to make this task easier for you.

### Extra Credit
The above algorithm doesn't support parenthesis and therefore cannot support expressions where the
user intends to override the order of operations. For example, users cannot evaluate expressions
like `(4 - 2) * 3`. Extend the above algorithm with the instructions below.

- If left parentheses token, push token onto operator stack
- If right parenthesis token
  - Repeat until top of operator stack is left parenthesis
    - Pop two value tokens from value stack
    - Pop operator token from operator stack
    - Apply operator to value tokens
    - Push result onto value stack
  - Pop left parenthesis token from top of operator stack
  - Discard right parenthesis token

### Further Reading
[The Shunting-Yard Algorithm](https://en.wikipedia.org/wiki/Shunting-yard_algorithm) is Dijkstra's
full two stack algorithm. The arithmetic expression evaluation algorithm summaries presented in this
assignment are only simplified versions of this algorithm. The full algorithm supports many more
mathematical operations (e.g. unary operators, variables, composite functions, functions with
multiple arguments, etc).

Testing your code
-----------------
Tests have already been written to help you ensure that your code works. The following commands will
be used to test and grade your code:

    $ bazel test java/test/edu/berkeley/cs/util:{linkedlist,splaylist,stack,queue}
    $ bazel test java/test/edu/berkeley/cs/app:calculator
