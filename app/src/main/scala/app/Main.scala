package app

import cats.syntax.all.*
import cats.effect.*
import s4s.app.*
import s4s.data.Fraction

object Main extends IOApp.Simple:

  val fractions: Fractions[IO] = new Fractions[IO]:
    def set(name: String, fraction: Fraction): IO[SetOutput] =
      SetOutput(s"$name / ${fraction.basisPoint}").pure[IO]

  def run: IO[Unit] = ???
