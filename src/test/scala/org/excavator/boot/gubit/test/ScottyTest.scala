package org.excavator.boot.gubit.test

import org.excavator.boot.gubit.Scotty
import org.junit.jupiter.api.Test
import scotty.quantum.{QubitProbabilityReader, Superposition}
import scotty.simulator.QuantumSimulator

class ScottyTest {

  @Test
  def testScotty() = {
    val scotty = new Scotty()

    val msg = scotty.getQubit()
    val circuit = scotty.getCircuit()

    QuantumSimulator().run(circuit) match {
      case s: Superposition => assert(QubitProbabilityReader(s).read("there")
      .forall(q => q.probability == Math.pow(msg.b.abs, 2)))
    }
  }

}
