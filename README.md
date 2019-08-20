# OAG Software Engineering Interview

## Background

The purpose of this exercise is to evaluate how you approach certain problems in code.  This is not intended to be
an example of the type of work you would be doing on a daily basis, nor is this an exhaustive test of the types of
problems you'll need to solve.  This is merely a starting point so that we can get to know your programming style
and approach to problems a bit better.

If you have found this and are not currently interviewing with us, you are welcoem to give it a shot.  We'd love
to see your solution.  Just fork the repo, implement your solution, and then send an email to 
jobs.dev@oaganalytics.com with your resume and a link to your fork and we'd be happy to follow up with you.

## Goal

Start by reading the comments at the top of the `com.oag.interview.CsvTransformer` class.  Those comments describe the 
existing code and what you are expected to do.

To exercise the code, use `com.oag.interview.CsvTest` under the `src/test` directory.  The first test in that class
produces a sample daily-production file for use as input to the CsvTransformer in later tests.  The final test in the
suite cleans up.

You are free to add tests as desired, but as noted in `CsvTest`, at a minimum, you must add tests that call and verify 
your new method / updated code.

## Guidelines

* You are free to change almost anything about `CsvTransformer` and/or `CsvTest` that you need to in order to complete 
the exercise.  This includes refactoring, introducing classes, improving efficiency/performance, etc.

* The following items need to remain unchanged from the original in your final solution:
    * `CsvCreator` must remain unchanged and should continue to be your source for daily-production input data.
    
    * There must still be methods analogous to `dailyOilToOperatedDay`, `dailyGasToOperatedDay`, and 
    `dailyWaterToOperatedDay`.  That is, in addition to the new functionality, we should still be able to get a
    production summary for only oil or water or gas with a simple method call.
    
    * For both the new functionality and the individual production type methods, there should be some mechanism for
    specifying the `productionIntervals: Seq[Int]`.  It can be as a parameter to the method, but doesn't have to be.  
    There should also still be a way to exclude the intervals and get a default value, but you may use a different 
    mechanism than default values on method parameters if desired.
    
    * All current verifications in `CsvTest` should still happen in some way.  You are free to refactor the tests 
    and/or change method calls to match refactored signatures as needed.  Said another way, the things proven true
    by the current tests should still be proven true by the tests in your final solution, though it is OK for the
    test suite to look different.
    
* If you believe you have found a bug in the code, fix it and include a comment in the code indicating why you believe
it was a bug and how your change fixes it.

* **Do not add any additional 3rd party dependencies**, even if there is one available that would simplify the work or make
the code more efficient.  The goal of the exercise is to evaluate code that _you_ write.  However, if you identify a 
section of code that could be replaced with an efficient 3rd party solution, feel free to add a comment that explains 
that, including a link to the library in question.

## Building / Running

You may work in whatever IDE/editor you find most convenient.  However, to evaluate your solution, we will use the 
included SBT build.  To make it easier to use in your environment, the SBT build has been encapsulated in a docker
container.  You can interact with it easily (on OS X or Linux) using the `sbtd` script included.

For details, see `docker-usage.md`.  In brief, build and test with this command: `./sbtd clean test`.

## Notes

* We make no guarantees about the quality of the starting point code or its correctness beyond the things validated in
unit tests.

* While timeliness does matter, we are more interested in seeing your _best_ work than in seeing your _fastest_ work.  If, 
with an extra day of work, you can significantly improve the code, please do so and communicate as much to your interviewer.

* Even though this is a somewhat simplistic scenario, it is OK to design as much robustness as you want into your 
solution.  Imagine that this is part of a larger system with many similar types of processing happening in various
contexts.

* Keep [SOLID Design Principles](https://en.wikipedia.org/wiki/SOLID_(object-oriented_design)) in mind while working. 
Demonstrate your understanding of these principles in the code you produce. If there are places in your solution where 
the context of a larger system would better demonstrate a concept, add a comment with your thoughts on that an implement
as much of the design as makes sense within the context of the problem given.

* There is no fixed percent coverage threshold we are looking for in your tests.  However, unit testing is valued and 
important and is considered a fundamental part of your solution.
