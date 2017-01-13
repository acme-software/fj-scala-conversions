package ch.acmesoftware.fjscalaconversions

import java.util.Optional

import org.scalatest._

class Java8OptionalSpec extends WordSpec with MustMatchers {

  "Option conversion" when {

    "applied to java.util.Optional[T]" should {

      val testData = Seq(
        (Optional.of("test"), Some("test")),
        (Optional.empty(), None),
        (Optional.ofNullable(null), None),
        (Optional.ofNullable("test"), Some("test"))
      )

      for (dataset <- testData.zipWithIndex) {
        s"""${dataset._2}: convert ${dataset._1._1.getClass.toString} to ${dataset._1._2}""" in {
          dataset._1._1.asScala() mustEqual dataset._1._2
        }
      }
    }

    "applied to scala.Option[T]" should {

      val testData = Seq(
        (Optional.of("test"), Some("test")),
        (Optional.empty(), None),
        (Optional.ofNullable(null), None),
        (Optional.ofNullable("test"), Some("test"))
      )

      for (dataset <- testData.zipWithIndex) {
        s"""${dataset._2}: convert  ${dataset._1._2} to ${dataset._1._1.getClass.toString}""" in {
          dataset._1._2.asJava8() mustEqual dataset._1._1
        }
      }
    }
  }
}
