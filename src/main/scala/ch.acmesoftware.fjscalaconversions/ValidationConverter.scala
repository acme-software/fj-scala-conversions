package ch.acmesoftware.fjscalaconversions

import scala.util.{ Failure, Success, Try }

trait ValidationConverter {
  implicit class FjToScalaValidationConversion[E <: Exception, T](validation: fj.data.Validation[E, T]) {
    def asScala(): Try[T] = Try {
      if (validation.isFail) {
        throw validation.fail()
      }

      validation.success()
    }
  }

  implicit class ScalaToFJValidationConversion[T](tryF: Try[T]) {
    def asFj(): fj.data.Validation[Throwable, T] = tryF match {
      case Success(v) => fj.data.Validation.success(v)
      case Failure(f) => fj.data.Validation.fail(f)
    }
  }
}
