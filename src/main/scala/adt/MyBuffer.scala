package adt

trait MyBuffer {
  def apply(i: Int): A
  def insert(elem: A, i: Int): Unit
  def remove(i: Int): A
  def length: Int
  def update(i: Int, elem: A): Unit
  def interator: Iterator[A]
}