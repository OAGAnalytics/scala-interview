# OAG Software Engineering Interview

## Background

This exercise is meant to evaluate how you approach certain problems in code.  This is not necessarily the type of work 
you would be doing on a daily basis, nor an exhaustive test of the types of problems you'll need to solve.  This is just 
a starting point so that we can get to know your programming style and approach to problems a bit better.

If you have found this repo and are not currently interviewing with us, you are welcome to give it a shot!  Fork the repo,
implement your solution, and then send an email to jobs.dev@oaganalytics.com with your resume and a link to your fork.
We'll be happy to follow up with you.

## Goal

The comments at the top of `com.oag.interview.CsvTransformer` describe the existing code and what you are expected to do.

To exercise the code, use `com.oag.interview.CsvTest` under the `src/test` directory.  The first test in that class
produces a sample daily-production file for use as input to the CsvTransformer in later tests.  The final test in the
suite cleans up.

## Guidelines

* Feel free to change almost anything about `CsvTransformer` and/or `CsvTest`.  This includes refactoring, introducing 
  classes, improving efficiency/performance, etc.

* Add tests as desired.  At a minimum, **you must add tests that call and verify your new method / updated code**. 
  There is no fixed percent coverage threshold we are looking for in your tests.  However, we value unit testing and 
  consider it to be part of your solution.

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

* If you find a bug in the code, fix it and include a comment in the code describiing the bug and how your change fixes it.

* **Do not add any additional 3rd party dependencies**, even if there is one available that would simplify the work or make
  the code more efficient.  The goal of the exercise is to evaluate code that _you_ write.  However, if you identify a 
  section of code that could be replaced with an efficient 3rd party solution, feel free to add a comment that explains 
  that, including a link to the library in question.

## Building / Running

Use whatever IDE/editor you find most convenient.  However, to evaluate your solution, we will use the 
included SBT build.  To make it easier to use in your environment, the SBT build has been encapsulated in a docker
container.  You can interact with it easily (on OS X or Linux) using the `sbtd` script included.

Build and test with this command: `./sbtd clean test`.  For details, see `docker-usage.md`.

## Notes

* We make no guarantees about the quality of the starting point code or even its correctness beyond the things validated in
  unit tests.

* While timeliness does matter, we are more interested in seeing your _best_ work than in seeing your _fastest_ work.  If, 
  with an extra day of work, you can significantly improve the code, please do so and communicate as much to your interviewer.

* Even though this is a somewhat simplistic scenario, you should design as your solution with as much robustness as you deem
  appropriate.  Imagine that this is part of a larger system with many similar types of processing happening in various
  contexts.

* Keep [SOLID Design Principles](https://en.wikipedia.org/wiki/SOLID_(object-oriented_design)) in mind while working. 
  Demonstrate your understanding of these principles in the code you produce. If there are places in your solution where 
  the context of a larger system would better demonstrate a concept, add a comment with your thoughts on that and implement
  as much of the design as makes sense within the context of the problem given.
