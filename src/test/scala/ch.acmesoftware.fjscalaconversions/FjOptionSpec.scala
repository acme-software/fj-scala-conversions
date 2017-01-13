package ch.acmesoftware.fjscalaconversions

import ch.acmesoftware.fjscalaconversions._
import org.scalatest._

class FjOptionSpec extends WordSpec with MustMatchers {

  "Option conversion" when {

    val testData = Seq(
      (fj.data.Option.some("test"), Some("test")),
      (fj.data.Option.none(), None),
      (fj.data.Option.fromNull(null), None),
      (fj.data.Option.fromNull("test"), Some("test")),
      (fj.data.Option.fromString(""), None),
      (fj.data.Option.fromString("test"), Some("test"))
    )

    "applied to fj.data.Option[T]" should {
      for (dataset <- testData.zipWithIndex) {
        s"""${dataset._2}: convert ${dataset._1._1.getClass.toString} to ${dataset._1._2}""" in {
          dataset._1._1.asScala() mustEqual dataset._1._2
        }
      }
    }

    "applied to scala.Option[T]" should {
      for (dataset <- testData.zipWithIndex) {
        s"""${dataset._2}: convert  ${dataset._1._2} to ${dataset._1._1.getClass.toString}""" in {
          dataset._1._2.asFj() mustEqual dataset._1._1
        }
      }
    }
  }
}
