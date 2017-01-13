package ch.acmesoftware.fjscalaconversions

import org.scalatest._

import scala.util.{Failure, Success}

class FjValidationSpec extends WordSpec with MustMatchers {

  "Validation conversion" when {

    val exception = new Exception("failed")
    val testData = Seq(
      (fj.data.Validation.success[Exception, String]("test"), Success("test")),
      (fj.data.Validation.success[Exception, Integer](42), Success(42)),
      (fj.data.Validation.fail[Exception, String](exception), Failure(exception))
    )

    "applied to fj.data.Validation[E,T]" should {
      for (dataset <- testData.zipWithIndex) {
        s"""${dataset._2}: convert ${dataset._1._1.getClass.toString} to ${dataset._1._2}""" in {
          dataset._1._1.asScala() mustEqual dataset._1._2
        }
      }
    }

    "applied to scala.util.Try[T]" should {
      for (dataset <- testData.zipWithIndex) {
        s"""${dataset._2}: convert  ${dataset._1._2} to ${dataset._1._1.getClass.toString}""" in {
          dataset._1._2.asFj() mustEqual dataset._1._1
        }
      }
    }
  }
}
