package ch.acmesoftware.fjscalaconversions

import scala.util.{ Failure, Success, Try }

/**
 * Object containing implicit functional java conversions
 */
object FjConversions {

  implicit class FjOption[T](opt: fj.data.Option[T]) {
    def asScala(): Option[T] = if (opt.isSome) Some(opt.some()) else None
  }

  implicit class ScalaOption[T](opt: Option[T]) {
    def asFj(): fj.data.Option[T] = opt.map(v => fj.data.Option.some(v)).getOrElse(fj.data.Option.none())
  }

  implicit class FjValidation[E <: Exception, T](validation: fj.data.Validation[E, T]) {
    def asScalaTry(): Try[T] = Try {
      if (validation.isFail) {
        throw validation.fail()
      }

      validation.success()
    }
  }

  implicit class ScalaTry[T](tryF: Try[T]) {
    def asFjValidation(): fj.data.Validation[Throwable, T] = tryF match {
      case Success(v) => fj.data.Validation.success(v)
      case Failure(f) => fj.data.Validation.fail(f)
    }
  }

}
