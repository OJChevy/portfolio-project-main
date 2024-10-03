# Portfolio Part 1: Component Brainstorming

- **Name**: Owen Chevalier
- **Dot Number**: chevalier.52
- **Due Date**: 09/15 @ 12:40 PM

## Assignment Overview

The overall goal of the portfolio project is to have you design and implement
your own OSU component. There are no limits to what you choose to design and
implement, but your component must fit within the constraints of our software
sequence discipline. In other words, the component must extend from Standard and
must include both a kernel and a secondary interface.

Because this is a daunting project, we will be providing you with a series of
activities to aid in your design decisions. For example, the point of this
assignment is to help you brainstorm a few possible components and get some
feedback. For each of these components, you will need to specify the high-level
design in terms of the software sequence discipline. In other words, you will
describe a component, select a few kernel methods for your component, and select
a few secondary methods to layer on top of your kernel methods.

You are not required to specify contracts at this time. However, you are welcome
to be as detailed as you'd like. More detail means you will be able to get more
detailed feedback, which may help you decide which component to ultimately
implement.

## Assignment Checklist

To be sure you have completed everything on this assignment, we have littered
this document with TODO comments. You can browse all of them in VSCode by
opening the TODOs window from the sidebar. The icon looks like a tree and will
likely have a large number next to it indicating the number of TODOS. You'll
chip away at that number over the course of the semester. However, if you'd
like to remove this number, you can disable it by removing the following
line from the `settings.json` file:

```json
"todo-tree.general.showActivityBarBadge": true,
```

Which is not to be confused with the following setting that adds the counts
to the tree diagram (you may remove this one as well):

```json
"todo-tree.tree.showCountsInTree": true,
```

## Assignment Learning Objectives

Without learning objectives, there really is no clear reason why a particular
assessment or activity exists. Therefore, to be completely transparent, here is
what we're hoping you will learn through this particular aspect of the portfolio
project. Specifically, students should be able to:

1. Integrate their areas of interest in their personal lives and/or careers with
   their knowledge of software design
2. Determine the achievablility of a software design given time constraints
3. Design high-level software components following the software sequence
   discipline

## Assignment Rubric: 10 Points

Again, to be completely transparent, most of the portfolio project, except the
final submission, is designed as a formative assessment. Formative assessments
are meant to provide ongoing feedback in the learning process. Therefore,
the rubric is designed to assess the learning objectives *directly* in a way
that is low stakes—meaning you shouldn't have to worry about the grade. Just
do good work.

1. (3 points) Each design must align with your personal values and long-term
   goals. Because the goal of this project is to help your build out a
   portfolio, you really ought to care about what you're designing. We'll give
   you a chance to share your personal values, interests, and long-term goals
   below.
2. (3 points) Each design must be achievable over the course of a single
   semester. Don't be afraid to design something very small. There is no shame
   in keeping it simple.
3. (4 points) Each design must fit within the software sequence discipline. In
   other words, your design should expect to inherit from Standard, and it
   should contain both kernel and secondary methods. Also, null and aliasing
   must be avoided, when possible. The methods themselves must also be in
   justifiable locations, such as kernel or secondary.

## Pre-Assignment

> Before you jump in, we want you to take a moment to share your interests
> below. Use this space to talk about your career goals as well as your personal
> hobbies. These will help you clarify your values before you start
> brainstorming. Plus it helps us get to know you better! Feel free to share
> images in this section.

I enjoy creating mobile applications in my spare time. With that being said, I
have experience with several different database designs. Lately, one of my other
interests has been artificial intelligence and machine learning. Creating algorithms
is something I find a lot of interest in. Lastly, I'm also big into sports and
lifting when I am not working on computer-related projects.

## Assignment

As previously stated, you are tasked with brainstorming 3 possible components.
To aid you in this process, we have provided [some example components][example-components]
that may help you in your brainstorming. All of these components were made at
some point by one of your peers, so you should feel confident that you can
accomplish any of them.

There is no requirement that you use any of the components listed above.
If you want to model something else, go for it! Very common early object
projects usually attempt to model real-world systems like banks, cars,
etc. Make of this whatever seems interesting to you, and keep in mind that
you're just brainstorming right now. You do not have to commit to anything.

### Example Component

To help you brainstorm a few components, we've provided an example below of a
component you already know well: NaturalNumber. We highly recommend that you
mirror the formatting as close as possible in your designs. By following this
format, we can be more confident that your designs will be possible.

- Example Component: `NaturalNumber`
  - **Description**:
    - The purpose of this component is to model a non-negative
      integer. Our intent with this design was to keep a simple kernel that
      provides the minimum functionality needed to represent a natural number.
      Then, we provide more complex mathematical operations in the secondary
      interface.
  - **Kernel Methods**:
    - `void multiplyBy10(int k)`: multiplies `this` by 10 and adds `k`
    - `int divideBy10()`: divides `this` by 10 and reports the remainder
    - `boolean isZero()`: reports whether `this` is zero
  - **Secondary Methods**:
    - `void add(NaturalNumber n)`: adds `n` to `this`
    - `void subtract(NaturalNumber n)`: subtracts `n` from `this`
    - `void multiply(NaturalNumber n)`: multiplies `this` by `n`
    - `NaturalNumber divide(NaturalNumber n)`: divides `this` by `n`, returning
      the remainder
    - ...
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, basically all OSU components have to be mutable as long as they
        inherit from Standard. `clear`, `newInstance`, and `transferFrom` all
        mutate `this`.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
        - No. All methods work with integers or other NaturalNumbers.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
        - Yes. NaturalNumber is base 10, and we track that in a constant called
          `RADIX`.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yes. The kernel methods `multiplyBy10` and `divideBy10` can be used to
        manipulate our natural number as needed. For example, to implement
        `increment`, we can trim the last digit off with `divideBy10`, add 1 to
        it, verify that the digit hasn't overflown, and multiply the digit back.
        If the digit overflows, we reset it to zero and recursively call
        `increment`.

Keep in mind that the general idea when putting together these layered designs
is to put the minimal implementation in the kernel. In this case, the kernel is
only responsible for manipulating a digit at a time in the number. The secondary
methods use these manipulations to perform more complex operations like
adding two numbers together.

Also, keep in mind that we don't know the underlying implementation. It would be
completely reasonable to create a `NaturalNumber1L` class which layers the
kernel on top of the existing `BigInteger` class in Java. It would also be
reasonable to implement `NaturalNumber2` on top of `String` as seen in
Project 2. Do not worry about your implementations at this time.

On top of everything above, there is no expectation that you have a perfect
design. Part of the goal of this project is to have you actually use your
component once it's implemented to do something interesting. At which point, you
will likely refine your design to make your implementation easier to use.

### Component Designs

> Please use this section to share your designs.

- Component Design #1: Google Firebase Firestore Clone
  - **Description**:
    - The firestore in Google Firebase is the main database used for several
    applications, specifically mobile. It consists of a main database made up of
    several collections and documents. Collections can be thought of as a bucket
    that holds several documents within it. Documents can be thought of as a package
    of data of something specific. For example, you can have a collection called
    users that contains several documents with information regarding a specific
    user.
  - **Kernel Methods**:
    - ref() - creates a reference to the main database
    - collection(String collectionName) - points to a specific collection in the database
    - document(String documentName) - points to a specific document in the database
    - snapshots() - grabs every document in a specified collection
    - increment(int numToAdd) - increments an integer field value in a document by how much the user inputs
    - decrement(int numToSubtract) - decrements an integer field value in a document by how much the user inputs
  - **Secondary Methods**:
    - void add(Map<T, T> mapToAdd) - adds an {@code Map} to a collection in the database as a new document and gives it a unique ID based on path given
    - void set(Map<T, T> mapToAdd, String ID) - adds an {@code Map} to a collection in the database as a new document if no previous document exists with that ID and overwrites a current document if the same ID exists.
    - void delete() - deletes a document in the database based on the path given
    - void update(Map<T, T> dataToUpdate) - updates data of a certain document based on the collection and document path given.
    - getDoc() - creates an {@code Map} of the document specified by the path
    - boolean search(Key keyToSearch) - searches for a document based on a key specified and returns true if it exists.
    - boolean search(String ID) - searches for a document based on an ID specified and returns true if it exists.
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, you would be able to change the values within this database. It has to be mutable since it relies on Standard methods, and
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - I am not sure right now. I don't think it will.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - I don't think it will. Everything should be generated or specified by the user.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yes, in my iteration, the kernel methods are there to provide paths to specific information within the database.

      Example, to add a document to a collection called users:
      Database db = this.ref();

      db.collection("users").add({@code Map});


- Component Design #2: Shopping cart
  - **Description**:
    - creates a database of goods that will be added to a shopping cart.
  - **Kernel Methods**:
    - void add(String nameOfItem, int quantity) - dreates an {@code Map} with the name of the item and the quantity
    - void delete(String nameOfItem) - deletes an item from the shopping cart based on the name of the item given if it exists.
    - boolean contains(String nameOfItem) - returns true if an item exists with the name of the item specified. Returns false if not
  - **Secondary Methods**:
    - void addSeveral(Map<String, int> itemsToAdd) - adds several items to the shopping cart at once by iterating through a map
    - void deleteSeveral(Set<String> itemsToDelete) - deletes several items from the shopping cart based on the name of the items.
    - void increment(String nameOfItem, int amount) - increments the amount to the quantity of the item if it exists
    - void decrement(String nameOfItem, int amount) - decrements the amount to the quantity of the item if it exists. If the decrement goes into the negative, the item will be deleted.
    - void displayCart() - displays every item in the cart in an organized format.
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, this component would be mutable. Since it relies on methods from Standard, it has to be mutable. Also, it would be much easier to manipulate the database if it were mutable.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - Yes, it would more than likely rely on Map.Pair when attempting to display the information in the terminal.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - I don't think it would rely on any enums or constants. Everything should be specified by the user.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yes, I can implement my secondary methods using kernel methods.

      Example, addSeveral(Map<String, int> itemsToAdd) would create a loop of the add(String nameOfItem, int quantity) to add each item to the shopping cart.


- Component Design #3: Bank Account
  - **Description**:
    - A database that models your different accounts, movement of funds, etc.
  - **Kernel Methods**:
    - void deposit(String accountName, float amount) - deposits the amount into account name specified
    - float withdraw(String accountName, float amount) - if sufficient funds are availabe in the account, it withdraws the amount specified
    - void addToBankStatement(Map<T, T> info) - adds any type of money manipulation to the bank statement for further reading

  - **Secondary Methods**:
    - void depositMultiple(String accountName, Map<String, float> depositSlip) - deposits several amounts to the specified bank account.
    - Map<String, float> withdrawMultiple(String accountName, Map<String, float> depositSlip) - withdraws several amounts if funds are available and stores it in a Map.
    - void transfer(String accountTransfer, String accountReceive, float amount) - if sufficient funds are availabe, it withdraws the amount from the accountTransfer and deposits into accountReceive.
    - void pay(String accountName, String receiver, float amount) - if sufficient funds are available, it will withdraw that amount from the account, and the money will be "paid".
    - void getBankStatement() - prints the bank statement to the terminal in a readable format for the user to see
  - **Additional Considerations** (*note*: "I don't know" is an acceptable
    answer for each of the following questions):
    - Would this component be mutable? Answer and explain:
      - Yes, this component would be mutable. It has to be since it's a database type and relies on Standard.
    - Would this component rely on any internal classes (e.g., `Map.Pair`)?
      Answer and explain:
      - It might rely on Map.Pair for showing the bank statement by I am not sure.
    - Would this component need any enums or constants (e.g.,
      `Program.Instruction`)? Answer and explain:
      - It might rely on enums based on whether it's a withdraw, deposit, or transfer.
    - Can you implement your secondary methods using your kernel methods?
      Answer, explain, and give at least one example:
      - Yes, I can implement my secondary methods using kernel methods.

      Example, depositMultiple(String accountName, Map<String, float> depositSlip) would get the name of the account and would use the add(String accountName, float amount) several times to add every value from the depositSlip.

## Post-Assignment

The following sections detail everything that you should do once you've
completed the assignment.

### Changelog

At the end of every assignment, you should update the
[CHANGELOG.md](../../CHANGELOG.md) file found in the root of the project folder.
Since this is likely the first time you've done this, we would recommend
browsing the existing file. It includes all of the changes made to the portfolio
project template. When you're ready, you should delete this file and start your
own. Here's what I would expect to see at the minimum:

```markdown
# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## YYYY.MM.DD

### Added

- Designed a <!-- insert name of component 1 here --> component
- Designed a <!-- insert name of component 2 here --> component
- Designed a <!-- insert name of component 3 here --> component
```

Here `YYYY.MM.DD` would be the date of your submission, such as 2024.04.21.

You may notice that things are nicely linked in the root CHANGELOG. If you'd
like to accomplish that, you will need to make GitHub releases after each pull
request merge (or at least tag your commits). This is not required.

In the future, the CHANGELOG will be used to document changes in your
designs, so we can gauge your progress. Please keep it updated at each stage
of development.

### Submission

If you have completed the assignment using this template, we recommend that
you convert it to a PDF before submission. If you're not sure how, check out
this [Markdown to PDF guide][markdown-to-pdf-guide]. However, PDFs should be
created for you automatically every time you save, so just double check that
all your work is there before submitting. For future assignments, you will
just be submitting a link to a pull request. This will be the only time
you have to submit any PDFs.

### Peer Review

Following the completion of this assignment, you will be assigned three
students' component brainstorming assignments for review. Your job during the
peer review process is to help your peers flesh out their designs. Specifically,
you should be helping them determine which of their designs would be most
practical to complete this semester. When reviewing your peers' assignments,
please treat them with respect. Note also that we can see your comments, which
could help your case if you're looking to become a grader. Ultimately, we
recommend using the following feedback rubric to ensure that your feedback is
both helpful and respectful (you may want to render the markdown as HTML or a
PDF to read this rubric as a table).

| Criteria of Constructive Feedback | Missing                                                                                                                           | Developing                                                                                                                                                                                                                                | Meeting                                                                                                                                                               |
| --------------------------------- | --------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Specific                          | All feedback is general (not specific)                                                                                            | Some (but not all) feedback is specific and some examples may be provided.                                                                                                                                                                | All feedback is specific, with examples provided where possible                                                                                                       |
| Actionable                        | None of the feedback provides actionable items or suggestions for improvement                                                     | Some feedback provides suggestions for improvement, while some do not                                                                                                                                                                     | All (or nearly all) feedback is actionable; most criticisms are followed by suggestions for improvement                                                               |
| Prioritized                       | Feedback provides only major or minor concerns, but not both. Major and minar concerns are not labeled or feedback is unorganized | Feedback provides both major and minor concerns, but it is not clear which is which and/or the feedback is not as well organized as it could be                                                                                           | Feedback clearly labels major and minor concerns. Feedback is organized in a way that allows the reader to easily understand which points to prioritize in a revision |
| Balanced                          | Feedback describes either strengths or areas of improvement, but not both                                                         | Feedback describes both strengths and areas for improvement, but it is more heavily weighted towards one or the other, and/or descusses both but does not clearly identify which part of the feedback is a strength/area for improvement  | Feedback provides balanced discussion of the document's strengths and areas for improvement. It is clear which piece of feedback is which                             |
| Tactful                           | Overall tone and language are not appropriate (e.g., not considerate, could be interpreted as personal criticism or attack)       | Overall feedback tone and language are general positive, tactul, and non-threatening, but one or more feedback comments could be interpretted as not tactful and/or feedback leans toward personal criticism, not focused on the document | Feedback tone and language are positive, tactful, and non-threatening. Feedback addesses the document, not the writer                                                 |

### Assignment Feedback

If you'd like to give feedback for this assignment (or any assignment, really),
make use of [this survey][survey]. Your feedback helps make assignments
better for future students.

[example-components]: https://therenegadecoder.com/code/the-never-ending-list-of-small-programming-project-ideas/
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
[survey]: https://forms.gle/dumXHo6A4Enucdkq9
