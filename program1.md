Program 1
---------
In this task, you will complete a series of shell scripts. To get you started, each shell script
file along with the appropriate Bazel configuration has already been setup for you in the `shell`
directory. You simply need to fill out each file with the appropriate code.

In order for tests to pass and ensure that you get the proper grade that you deserve, you must
ensure that your output case-sensitively matches the output that the tests expect.

Note: some students have reported issues with working with `bash` under Windows. For Windows users,
it is recommended to use the [Linux Subsystem](https://docs.microsoft.com/en-us/windows/wsl/faq) to
get a native Linux environment under Windows.

`survey.md` (optional)
----------------------
Add responses to the questions in `survey.md`, located in the top-level root of the repository.

Answering these questions is completely optional and do not affect your grade on this assignment.
However, your responses do help me understand your current experience and better tailor the course
to your individual needs. Your responses will be kept confidential and will never be shared.

`info.sh`
---------
Write a shell script which displays information about the user's current session. The displayed
information should look exactly like the following:

    Current date: Fri Sep  6 19:31:17 PDT 2019
    Login name: fsareshwala
    Current directory: /home/fsareshwala/code
    Home directory: /home/fsareshwala

Hint: use the `date`, `whoami`, `pwd`, `realpath`, and `echo` commands.

Note: `realpath` is not available by default on Mac OS. To get it, install it using homebrew:

    brew install coreutils

`sum.sh`
--------
Write a shell script that takes a list of numbers as command line arguments. The output is the sum
of the numbers.

`seq.sh`
--------
Write a shell script that takes two integer arguments. The script should output all the numbers
between the first and last number, inclusive. Your script should be able to take in arguments in the
following ways:

    $ seq.sh last
    $ seq.sh first last
    $ seq.sh first increment last

If only a single argument is provided, `first` and `increment` default to `1`. If two arguments are
provided, then `increment` defaults to `1`. The sequence of numbers ends when the sum of the current
number and `increment` would become greater than `last`. Make sure to check that `increment` is not
zero. If more than three arguments are provided, print out a suitable error message and exit the
script with a return status of `1`.

Hint: Arithmetic in bash uses `$[...]` syntax. To increment variable `var` by 1, you would write
`var=$[var + 1]`.

Note: this script is inspired by a real command, `seq`. To ensure that your script is working
properly, compare its output to the real `seq` command output.

`stdio.sh`
----------
Write a script which takes in directories as arguments on the command line. For each directory, it
looks up every `.c` file in that directory for the strings `printf` or `fprintf`. If found, the
script adds the statement `#include <stdio.h>` at the beginning of the file, but only if it doesn't
already have it included.

Testing your code
-----------------
Tests have already been written to help you ensure that your code works. The following commands will
be used to test and grade your code:

    $ bazel test shell:tests
