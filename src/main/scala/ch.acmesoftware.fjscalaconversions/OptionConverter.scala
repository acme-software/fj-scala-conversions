package ch.acmesoftware.fjscalaconversions

import java.util.Optional

private[fjscalaconversions] trait OptionConverter {
  implicit class FjToScalaOptionConversion[T](opt: fj.data.Option[T]) {
    def asScala(): Option[T] = if (opt.isSome) Some(opt.some()) else None
  }

  implicit class Java8ToScalaOptionConversion[T](opt: Optional[T]) {
    def asScala(): Option[T] = if (opt.isPresent) Some(opt.get()) else None
  }

  implicit class ScalaToFjOptionConversion[T](opt: Option[T]) {
    def asFj(): fj.data.Option[T] = opt.map(v => fj.data.Option.some(v)).getOrElse(fj.data.Option.none())
    def asJava8(): Optional[T] = opt.map(v => Optional.of(v)).getOrElse(Optional.empty())
  }
}
