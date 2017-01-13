Fj Scala Conversions
====================

**Library to convert functional java types to scala and vice versa**

Features
--------

This library provides conversions from [Functional Java Library](http://www.functionaljava.org/) and 
[Java 8](http://www.oracle.com/technetwork/java/javase/8-relnotes-2226341.html) functional types to Scala and vice 
versa. The following type conversions are supported:

### Functional Fava

- `fj.data.Option`
- `fj.data.Validation`

### Java 8

- coming soon

Installation
------------

Add the library as an SBT dependency

```scala
libraryDependencies ++= Seq(
  "ch.acmesoftware" %% "fj-scala-conversions" % "VERSION"
)
```

See [GitHub Releases](https://github.com/acme-software/fj-scala-conversions/releases) for available versions. The 
library is available for Scala `2.10`, `2.11` and `2.12`.

Major releases follow the Fonctional Java Library version:

| FJ Version | Scala Conversions Version |
| ---------- | ------------------------- |
| 4.6        | 1.x.x                     |

Usage
-----

Just import the `FjConversions`, and call one of the methods beginning with `asScala` on the functional java types.

### FJ to Scala example

```scala
import ch.acmesoftware.fjscalaconversions.FjConversions._

// option
val fjOption = fj.data.Option.some("example")
val scalaOption: Option[String] = fjOption.asScala()

// validation
import scala.util.Try

val fjValidation = fj.data.Validation.success[Exception, String]("example") // failurew type must be explicitely stated
val scalaTry: Try[String] = fjValidation.asScalaTry()

```

### Scala to FJ example

```scala
import ch.acmesoftware.fjscalaconversions.FjConversions._

// option
val scalaOption = Some("example")
val fjOption: fj.data.Option[String] = scalaOption.asFj()

// validation
import scala.util.Try

val scalaTry = Try("example")
val fjValidation = scalaTry.asFjValidation()
```

Contribution
------------

Contribution in any kind are very welcome. Please use the GitHub issue tracking / pull requests.

This library with all its contents is licensed under the *MIT License* by 
[ACME Software Solutions GmbH](https://github.com/acme-software). See [LICENSE](LICENSE) for more information.
