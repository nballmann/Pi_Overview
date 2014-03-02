package org.pi.overview.util

/**
 * Created by Nicolas on 26.02.14.
 */
object Utils {

  // reverse
  def reverse[A](list: Seq[A]): Seq[A] = {
    def rec_reverse(l: Seq[A], acc: Seq[A]): Seq[A] = {
      l.size match {
        case 0 => acc
        case _ => rec_reverse(l.tail, acc :+ l.head)
      }
    }
    rec_reverse(list, Nil)
  }

  // spliAt
  def splitAt[A](list: Seq[A], index: Int): Seq[Seq[A]] = {
    require(index >= 0, "index must not be negative")
    require(index < list.size, "index must be within bounds of list")
    def rec_split(list_a: Seq[A], list_b: Seq[A]): Seq[Seq[A]] = {
      list_a.size match {
        case `index` => Seq(list_a, list_b)
        case _ => rec_split(list_a :+ list_b.head, list_b.tail)
      }
    }
    rec_split(Nil, list)
  }
  def mergesort[A](list: Seq[A], comp: (A, A) => Boolean): Seq[A] = {
    // merge
    def merge(list_a: Seq[A], list_b: Seq[A]): Seq[A] = {
      def rec_merge(ll: Seq[A], lr: Seq[A], acc: Seq[A]): Seq[A] ={
        ll.size match {
          case 0 => if (lr.size == 0) { acc } else { rec_merge(Nil, lr.tail, acc :+ lr.head) }
          case _ => if (lr.size == 0) { rec_merge(ll.tail, Nil, acc :+ ll.head) }
                    else if (comp(ll.head, lr.head)) { rec_merge(ll.tail, lr, acc :+ ll.head) }
                    else { rec_merge(ll, lr.tail, acc :+ lr.head) }
        }
      }
      rec_merge(list_a, list_b, Nil)
    }
    def sort(xs: Seq[A]): Seq[A] = {
      if (xs.size <= 1) { xs }
      else {
        val m = xs.size / 2
        val split = splitAt(xs, m)
        merge(sort(split.head), sort(split.tail.head))
      }
    }
    sort(list)
  }
  // sort




}
