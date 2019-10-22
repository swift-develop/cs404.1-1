Program 3
---------
In this assignment, you will implement and make improvements to various sorting algorithms.

Before beginning on this assignment, make sure to read the abstract `Sort` class:

- Java: `java/src/edu/berkeley/cs/sort/Sort.java`
- Python: `python/src/sort/sort.py`

Within this file, there are some already implemented methods you can use while completing your
implementations.

Shellsort has already been implemented for you:

- Java: `java/src/edu/berkeley/cs/sort/Shell.java`
- Python: `python/src/sort/shell.py`

Quicksort has already been implemented for you:

- Java: `java/src/edu/berkeley/cs/sort/Quick.java`
- Python: `python/src/sort/quick.py`

Selection Sort
--------------
Implement selection sort.

The files you will need (depending on the language you are working in) for this exercise are:

- Java: `java/src/edu/berkeley/cs/sort/Selection.java`
- Python: `python/src/sort/selection.py`

Insertion Sort
--------------
When sorting an array, we normally want to sort it in its entirety. However, it is also useful to be
able to sort just a portion of the array. For example, when cutting off to insertion sort for small
subarrays in mergesort or quicksort, we want to be able to sort just the subarray. Implement
insertion sort to support sorting just the subarray starting from the index `low` and ending at the
index `high`.

The files you will need (depending on the language you are working in) for this exercise are:

- Java: `java/src/edu/berkeley/cs/sort/Insertion.java`
- Python: `python/src/sort/insertion.py`

Quicksort
----------
Quicksort has already been implemented for you in this exercise. However, there are various
improvements that can still be made to this implementation to make it faster in practice. Make the
following changes to the quicksort implementation.

### Use insertion sort for small subarrays
Quicksort is slower than insertion sort for tiny subarrays. For subarrays of size less than or equal
to 5, cut off to insertion sort.

### Pivot selection
Choosing the right pivot can make all the difference for the execution of quicksort. Ideally, we
would select the median value of all the elements in each subarray. However, finding the median
efficiently is a tricky problem. Instead, use the median value of first, middle, and last element of
the subarray to be sorted.

**Note**: for this step, you may find that `partition(...)` needs to be slightly modified for the
sort to continue working.

The files you will need (depending on the language you are working in) for this exercise are:

- Java: `java/src/edu/berkeley/cs/sort/Quick.java`
- Python: `python/src/sort/quick.py`

Merge Sort
----------
Implement top-down mergesort. Once you have a working implementation, make the following
improvements to your implementation:

### Use insertion sort for small subarrays
For subarrays of size less than or equal to 5, cut off to insertion sort.

### Test whether the array is already in order
Skip the call to `merge(...)` if `input[mid]` is less than or equal to `input[mid+1]`. This
effectively converts mergesort's time complexity to `O(n)` when sorting an array that is already in
sorted order.

The files you will need (depending on the language you are working in) for this exercise are:

- Java: `java/src/edu/berkeley/cs/sort/Merge.java`
- Python: `python/src/sort/merge.py`

Mergesort Linked Lists
----------------------
Up until now, all of our sorting algorithms have dealt with sorting arrays. However, we must also be
able to sort other data structures that hold ordered data (e.g. linked lists). In fact, mergesort is
the method of choice for sorting linked lists because it uses no extra space and is guaranteed to be
linearithmic. Unfortunately, our current implementation of mergesort will not work on linked lists.

Fill in the linked list specific `merge(...)` and `sort(...)` methods within your mergesort
implementation.

The files you will need (depending on the language you are working in) for this exercise are:

- Java: `java/src/edu/berkeley/cs/sort/Merge.java`
- Python: `python/src/sort/merge.py`

Testing your code
-----------------
Tests have already been written to help you ensure that your code works. The following commands will
be used to test and grade your code:

Java:

    $ bazel test java/test/edu/berkeley/cs/sort:{elementary,merge,quick}

Python:

    $ bazel test python/test/sort:{elementary,merge,quick}
