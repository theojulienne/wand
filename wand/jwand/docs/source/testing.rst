Wand testing framework
======================

Test structure
--------------

Wand tests are stored one-folder-per-test in ``tests/<type>/<feature>/<test-name>/``
where ``<type>`` is the test type (see :ref:`test-types`), ``<feature>`` represents
the feature being tested (eg "functions", "delegates", "classes", "templates"), and
``<test-name>`` represents the specific test being conducted.

This directory should contain one or more wand source files, which will be
automatically compiled and run.

* If a ``test.sh`` file exists, it will be run instead of any automatic compilation.
  It should exit with status "0" for a pass and "1" for a fail.
* If a ``main.c`` file exists, it will be compiled with gcc and linked with the wand
  file(s).

.. _test-types:

Test types
----------

* ``core-pass`` -- Tests that must pass in the current release. This includes any
  advertised language feature, and all tests must pass before an official 
  release.

* ``core-graceful`` -- Tests that are expected to gracefully fail in the current
  release. This means a given program must exit with a user error (syntax
  error, not-implemented, etc) and **not** a crash. All tests must pass
  (exit gracefully without compiling) before an official release.

* ``future-pass`` -- Tests for future language features. These features are not
  required to pass for a release, however none must crash 
  (see procedures below). Otherwise, same as "core-pass".

* ``future-graceful`` -- Tests for future language features. These features are not
  required to pass for a release, however none must crash
  (see procedures below). Otherwise, same as "core-graceful".

Release test procedures
-----------------------

* A "crash" (NullPointerException, ArrayOutOfBoundsException, etc) 
  is **never** acceptable. **No** program must be able to cause the compiler 
  to crash in a release, regardless of whether the syntax/test was in "core" 
  or "future".

* Releases must "pass" all tests in core, unless they are tagged with an
  appropriate name indicating they are of alpha quality. Trunk may not
  always pass all core tests, but still should wherever possible.

* Once a feature from "future" is considered well implemented (extensively
  tested, all tests pass), the appropriate test folder(s) from future-*
  should be moved to the core-* test suites, after whcih the feature can 
  be advertised as a working feature in the next release.