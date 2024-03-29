CS 404.1
--------
This repository houses the code and scaffolding that UC Berkeley Extension students taking CS 404.1
use when completing their assignments.

Starter Code
------------
This repository contains various pieces of starter code that provide a skeleton and will help you
get started on your assignments. When working with this starter code, please remember that you may
not change or delete:

- Any of the code or tests already present
- Any of the interfaces, APIs, or methods already present

Supported Languages
-------------------
Quite a bit of work goes into preparing the course and the repository to use a particular language
(e.g. starter code, unit tests, solutions, etc). Currently, this course is offered in the following
languages. Other languages may be offered in the future.

- Java
- Python

Use of the Standard Library
---------------------------
This course focuses on data structures, algorithms, and their implementations. As such, in order for
you to learn about their internals, you must first implement them yourself. Therefore, in this
course, you may not use or import any standard library data structures or algorithms, unless
expressly permitted. If you need access to a particular data structure or algorithm, you must
implement it.

Code Style and Code Formatting
------------------------------
As a general rule, it is very important to keep source code in a consistent format. Most companies
have an established coding style for each language that they develop in. For this course, we will be
using Google's style guides for each language:

- Java: [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- Python: [Google Python Style Guide](http://google.github.io/styleguide/pyguide.html)

While it is useful to read the style guide and understand why the decisions were made as they were,
no one can expect to remember every detail every time. Therefore, we have tooling to help in
formatting the code in adherence to the style guide.

In order to format your code, simply run `format.sh` from the top level repository root. This script
formats all supported languages within the repository.

Submitting Your Work
--------------------
Submit your work by committing your changes and pushing them upstream before the due date.

Grading
-------
Each program description will include a command that will be used to run tests for the code you
write in each assignment. The percentage of tests that pass will be your final grade for the
assignment.

Student Setup
-------------
Normally, repositories house code that all developers use as a base to build their changes off of.
When other developers make changes, all developers pull them in and continue their work on top.
In our case, however, each student will have a separate fork of this repository in order to complete
their assignments. Furthermore, each student must keep their fork private so as to prevent any
possible plagiarism. Unfortunately, GitHub does not allow private forks of public repositories.

For this reason, we won't be using the standard GitHub workflow here. Instead, we have to jump
through some hoops in order to support our specific use case, while also using GitHub's repository
hosting platform.

- Ensure you have a GitHub account, have verified your email address, and are signed in
- Set up [SSH access with GitHub](https://help.github.com/en/articles/connecting-to-github-with-ssh)
- [Create a new repository](https://github.com/new) on GitHub
  - Name your repository `cs404.1`
  - Ensure the repository is marked private
  - Create the repository
- Add `fsareshwala` as a collaborator
  - Visit the `Settings` tab
  - Select the `Collaborators` section on the left
  - Add the `fsareshwala` user as a collaborator to your repository
- Bootstrap your repository
  - Execute the following command in a new terminal
  - **Note**: make sure to replace `username` in the command with your GitHub username
  ```
  curl https://raw.githubusercontent.com/fsareshwala/cs404.1/master/bootstrap.sh | bash -s username
  ```
  - You will now have a directory named `cs404.1` where you executed the command above. This is your
    assignment directory where you will do your work.
- Configure `git` properly
  - Tell `git` who you are (replace my information with yours)
    ```
    git config --global user.name 'Faraaz Sareshwala'
    git config --global user.email 'fsareshwala@berkeley.edu'
    ```
  - Tell `git` to fix whitespace problems for you:
    ```
    git config --global core.whitespace fix,-indent-with-non-tab,trailing-space,cr-at-eol
    ```
  - Tell `git` to update line endings automatically once you commit your changes:
    - Mac/Linux
      ```
      git config --global core.autocrlf input
      ```
    - Windows
      ```
      git config --global core.autocrlf true
      ```
- Identify yourself within your repository
  - Add your name to the `name.md` file in the top level root of the repository
  - Commit the addition and push the change to GitHub
  - This is how I know who the repository belongs to
- Identify your language of choice
  - Add your language of choice, in fully lowercase characters (e.g. java, python), to `language.md`
    in the top level root of the repository
  - Commit the addition and push the change to GitHub
  - This is how I know which language you will be using
- Optional: Select an IDE (Integrated Development Environment)
  - [IntelliJ IDEA](https://www.jetbrains.com/idea)
  - [VSCode](https://code.visualstudio.com)
  - **Note**: It is up to you to determine whichever development environment works best for your
    personal tastes. As such, detailed instructions on how to perform various environment related
    operations won't be provided. I assume that by this stage of your software engineering career,
    you are familiar with your tools of choice.
- Optional: Install the [Bazel](https://bazel.build) plugin for your selected IDE
- Optional: Install the [Google Java Formatter](https://github.com/google/google-java-format) plugin
  for your selected IDE
- Load your assignment repository in your environment (e.g. IDE) and ensure you can compile and run
  programs and tests

Contributing
------------
If you find any issues within this repository while completing your assignments, please
[open an issue](https://github.com/fsareshwala/cs404.1/issues/new) in the issue tracker. Better yet,
please open a pull request against the repository and I will be happy to merge it in.
