/** 
  * minilog -- a small Scala package for building sequential logic.
  *
  * @author Petteri Kaski <petteri.kaski@aalto.fi>
  *
  */

/*
https://puzzle.ics.hut.fi/ICS-A1120/2015/notes/round-sequential-logic--seq.html
 */
package minilog;

/** The base class for gates.
  *
  * Build gates from existing gates with Boolean operators or
  * manufacture via factory methods in class Circuit.
  *
  */

//abstract class Gate(val host: Circuit)
//{
//  host.registerGate(this)       // register this gate with the host
//
//  /** Convenience constructor for use by extending classes. */
//
//  protected def this(inputs: Gate*) {
//    this(inputs.head.host)      // host is the host of first input
//    require(inputs.tail.forall(_.host == inputs.head.host))
//      // fails unless all inputs have same host
//  }
//
//  /* Memoization and clean/dirty interface
//   * (internal to classes Gate and Circuit). */
//
//  /** The memorized value of this gate. */
//
//  private var memo = false              // defaults to false
//
//  /** Updates memorized value, invoked by host. */
//
//  private[minilog] def clean() { memo = eval }
//
//  /** Returns the value of this gate, implemented in extending classes. */
//
//  protected def eval: Boolean
//
//  /** Returns the (memorized) value of this gate. */
//
//  def value = {
//    if(host.dirty) {
//      host.clean()       // recompute all memos if dirty
//    }
//    memo                 // my memorized value is up to date, so return it
//  }
//
//  /** Sets the value of this input element (fails on other gate types). */
//
//  def set(v: Boolean) { require(false) }         // fails unless input element
//
//  /** Builds a feedback to this input element (fails on other gate types). */
//
//  def buildFeedback(g: Gate) { require(false) }  // fails unless input element
//
//  /* Builders for basic types of gates. */
//
//  /** Returns a new NOT-gate. */
//
//  def unary_!(): Gate      = new NotGate(this)
//
//  /** Returns a new AND-gate. */
//
//  def &&(that: Gate): Gate = new AndGate(this, that)
//
//  /** Returns a new OR-gate. */
//
//  def ||(that: Gate): Gate = new OrGate(this, that)
//
//  /** Returns a new XOR-gate. */
//
//  def +(that: Gate): Gate  = new XorGate(this, that)
//
//  /** Returns a new XOR-gate. */
//
//  def ^^(that: Gate): Gate = new XorGate(this, that)
//}
//
///** Implements an input element. */
//
//private[minilog] class InputElement(host: Circuit) extends Gate(host)
//{
//  host.registerInput(this)          // register the new input
//
//  /** Value of this input element. */
//
//  private var v = false                     // default value is false
//
//  /** Sets the value of this input element. */
//
//  override def set(s: Boolean) {
//    v = s                           // whenever an input is set ...
//    host.dirty = true               // ... flag the host dirty
//  }
//
//  /** Returns the value of this input element. */
//
//  protected def eval = v
//
//  /** The gate from which this input element takes feedback. */
//
//  private var feedback_from: Gate = this    // default feedback is from itself
//
//  /** Builds a feedback to this input element. */
//
//  override def buildFeedback(g: Gate) {
//    require(host == g.host)         // fail unless g has the same host
//    feedback_from = g
//  }
//
//  /** Returns the value of the feedback gate. */
//
//  def feedbackValue = feedback_from.value
//}
//
///** Implements a NOT gate. */
//
//private[minilog] class NotGate(in: Gate) extends Gate(in)
//{
//  protected def eval = !in.value
//}
//
///** Implements an OR gate. */
//
//private[minilog] class OrGate(in1: Gate, in2: Gate) extends Gate(in1, in2)
//{
//  protected def eval = in1.value || in2.value
//}
//
///** Implements an AND gate. */
//
//private[minilog] class AndGate(in1: Gate, in2: Gate) extends Gate(in1, in2)
//{
//  protected def eval = in1.value && in2.value
//}
//
///** Implements a XOR gate. */
//
//private[minilog] class XorGate(in1: Gate, in2: Gate) extends Gate(in1, in2)
//{
//  protected def eval = (in1.value || in2.value) && !(in1.value && in2.value)
//}
//
///** Implements a constant gate. */
//
//private[minilog] class ConstantGate(host: Circuit, v: Boolean) extends Gate(host)
//{
//  protected def eval = v
//}
//
//import collection.immutable.Queue
//
///** A host class for gates with factory methods for input elements and constant gates. */
//
//class Circuit() {
//
//  /* Hosting mechanisms for gates and input elements (internal to package). */
//
//  /** Constructed gates register here. */
//
//  private var gates  = Queue[Gate]()
//
//  /** Registers a gate with its host. */
//
//  private[minilog] def registerGate(g: Gate) {
//    gates = gates :+ g
//    dirty = true
//  }
//
//  /** Constructed inputs register here. */
//
//  private var ins = Queue[InputElement]()
//
//  /** Registers an input element with its host. */
//
//  private[minilog] def registerInput(g: InputElement) { ins = ins :+ g }
//
//  /* Memoization and clean/dirty interface
//   * (internal to classes Gate and Circuit). */
//
//  /** Flag: must recompute the memorized values (if any)? */
//
//  private[minilog] var dirty = false
//
//  /** Recomputes the memorized gate values. */
//
//  private[minilog] def clean() {
//    dirty = false            // clear dirty before eval, otherwise infinite loop
//    gates.foreach(_.clean()) // update and memorize values at gates
//  }
//
//  /* Interface for feedback hooks. */
//
//  /** Feedback hooks register here. */
//
//  private var hooks = Queue[() => (() => Unit)]()
//
//  /** Builds a feedback hook. */
//
//  def buildFeedbackHook(hook: () =>  (() => Unit)) { hooks = hooks :+ hook }
//
//  /** Executes feedback. */
//
//  def clock() {
//    val writehooks = hooks.map(_()) // run read hooks
//    (ins zip ins.map(_.feedbackValue)).foreach({ case (w,v) => w.set(v) })
//    writehooks.foreach(_())         // run write hooks
//  }
//
//  /* Static objects and builders. */
//
//  /** A static gate that evaluates to false. */
//
//  val False: Gate = new ConstantGate(this, false)
//
//  /** A static gate that evaluates to true. */
//
//  val True: Gate  = new ConstantGate(this, true)
//
//  /** Returns a new input element. */
//
//  def input()        = new InputElement(this)
//
//  /** Returns a bus of n new input elements. */
//
//  def inputs(n: Int) = new Bus((1 to n).map(x => input()))
//
//  /** Returns a new bus of n constant gates that evaluate to false. */
//
//  def falses(n: Int) = new Bus((1 to n).map(x => False))
//
//  /** Returns a new bus of n constant gates that evaluate to true. */
//
//  def trues(n: Int)  = new Bus((1 to n).map(x => True))
//}
//
//
//import collection.SeqLike
//import collection.mutable.{ArrayBuffer,Builder}
//import collection.generic.CanBuildFrom
//
///** A custom collection for bus-level building. */
//
//class Bus(gates: Seq[Gate])
//      extends Seq[Gate]
//         with SeqLike[Gate,Bus]
//{
//  /* Relegate to underlying sequence object. */
//
//  def host = gates.head.host
//  def length = gates.length
//  def apply(idx: Int) = gates.apply(idx)
//  def apply(idxs: Seq[Int]) = new Bus(idxs.map(gates(_)))
//  def iterator = gates.iterator
//  override protected[this] def newBuilder: Builder[Gate, Bus] = Bus.newBuilder
//
//  /** Returns the values of the gates in the bus. */
//
//  def values = gates.map(_.value)
//
//  /** Returns the gate-wise AND of the gates in the left operand with the right operand. */
//
//  def &&(that: Gate) = new Bus(this.map(_ && that))
//
//  /** Returns the gate-wise OR of the gates in the left operand with the right operand. */
//
//  def ||(that: Gate) = new Bus(this.map(_ || that))
//
//  /** Returns the gate-wise XOR of the gates in the left operand with the right operand. */
//
//  def +(that: Gate)  = new Bus(this.map(_ + that))
//
//  /** Returns the NOT of all gates in the operand. */
//
//  def unary_~        = this.map(!_)
//
//  /** Returns the gate-wise AND of its operands. */
//
//  def &(that: Bus)   = new Bus((this zip that).map(x => x._1 && x._2))
//
//  /** Returns the gate-wise OR of its operands. */
//
//  def |(that: Bus)   = new Bus((this zip that).map(x => x._1 || x._2))
//
//  /** Returns the gate-wise XOR of its operands. */
//
//  def ^(that: Bus)   = new Bus((this zip that).map(x => x._1 + x._2))
//
//  /** Builds feedbacks to each gate (input element) in the bus from the corresponding
//    * gate in the operand. */
//
//  def buildFeedback(that: Bus) = (this zip that).foreach(x => x._1.buildFeedback(x._2))
//}
//
///** A companion builder for class Bus. */
//
//object Bus {
//  def apply(gates: Gate*) = new Bus(gates)
//  def newBuilder: Builder[Gate, Bus] =
//    new ArrayBuffer[Gate] mapResult (s => new Bus(s))
//  implicit def canBuildFrom: CanBuildFrom[Bus, Gate, Bus] = {
//    new CanBuildFrom[Bus, Gate, Bus] {
//      def apply(): Builder[Gate, Bus] = newBuilder
//      def apply(from: Bus): Builder[Gate, Bus] = newBuilder
//    }
//  }
//}