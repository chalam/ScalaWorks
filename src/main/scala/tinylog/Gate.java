// tinylog -- a tiny Scala package for building combinational logic

package tinylog;

/*
https://puzzle.ics.hut.fi/ICS-A1120/2015/notes/round-sequential-logic--seq.html
 */
//abstract class Gate()
//{
//  def value: Boolean     // implemented by the extending classes
//  def unary_!(): Gate      = new NotGate(this)
//  def &&(that: Gate): Gate = new AndGate(this, that)
//  def ||(that: Gate): Gate = new OrGate(this, that)
//}
//
//object Gate {
//  val False: Gate = new ConstantGate(false)
//  val True: Gate  = new ConstantGate(true)
//  def input(): Gate = new InputElement()
//}
//
//class InputElement() extends Gate()
//{
//  var v = false                     // default value is false
//  def set(s: Boolean) { v = s }
//  def value = v
//}
//
//class NotGate(in: Gate) extends Gate()
//{
//  def value = !in.value
//}
//
//class OrGate(in1: Gate, in2: Gate) extends Gate()
//{
//  def value = in1.value || in2.value
//}
//
//class AndGate(in1: Gate, in2: Gate) extends Gate()
//{
//  def value = in1.value && in2.value
//}
//
//class ConstantGate(v: Boolean) extends Gate()
//{
//  def value = v
//}