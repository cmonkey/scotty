package org.excavator.boot.gubit

import scotty.quantum.{Circuit, Qubit}
import scotty.quantum.StandardGate.{CNOT, Controlled, H, Z}
import scotty.quantum.math.Complex

import scala.util.Random

class Scotty {
  implicit val random = new Random()

  def bellPair(q1: Int, q2: Int) =  Circuit(H(q1), CNOT(q1, q2))

  def getQubit() = {
    Qubit(Complex(0.8), Complex(0.6))
  }

  def getCircuit() = {
    val circuit = bellPair(1,2)
      .combine(Circuit(CNOT(0, 1), H(0)))
      .combine(CNOT(1, 2), Controlled(0, Z(2)))
      .withRegister(getQubit(), Qubit.zero("here"), Qubit.zero("there"))

    circuit
  }

}
