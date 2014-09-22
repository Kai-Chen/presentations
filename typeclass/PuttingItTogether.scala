package com.sorrentocorp.presentation.typeclass

import scalaz._, Scalaz._

object PuttingItTogether {
  type Author = String
  type Publisher = String
  type PublishDate = Long

  case class Book (author: String, title: String, edition: Int, publisher: String) {
    override def toString = f"$author%-18s|$title%45s|$edition%5d|$publisher%s"
  }

  val Books = Vector(
    Book("John Milton", "Paradise Lost", 3, "Divine Publishing")
    , Book("E. L. James", "Fifty Shades of Grey", 1, "Random House")
    , Book("Immanuel Kant", "The Beautiful and the Sublime", 1, "Cambridge University Press")
    , Book("Nassim Taleb", "Black Swan", 2, "Random House")
    , Book("J. K. Rowlings", "Harry Potter", 20, "Bloomsbury")
    , Book("Donald Knuth", "The Art of Programming", 1, "Addison-Wesley")
    , Book("Alfred Aho, et al.", "Compilers: Principles, Techniques, and Tools", 10, "Pearson Education")
    , Book("Richard Feynman", "QED: The Strange Theory of Light and Matter", 1, "Princeton University Press")
    , Book("John Milton", "Paradise Regained", 1, "Diving Publishing")
  )

  import Order._

  val byAuthor = orderBy((_:Book).author)
  val byTitle = orderBy((_:Book).title)
  val byEdition = orderBy((_:Book).edition)
  val byPublisher = orderBy((_:Book).publisher)

  def printBooks = Books.foreach(println)

  def sortByAuthor = Books.sorted(byAuthor.toScalaOrdering).foreach(println)

  def sortByPublisher = Books.sorted(byPublisher.toScalaOrdering).foreach(println)

  def reverseSortByEdition = Books.sorted(byEdition.reverseOrder.toScalaOrdering).foreach(println)

  /*
   * val byPublisherAuthorReverse = byPublisher |+| byAuthor.reverseOrder
   * 
   * val byAuthorEdition = byAuthor |+| byEdition
   */


}

/*
(defun kai-eval-scala (start end)
	(interactive "r")

  (setq curwindow (selected-window))
  (save-excursion (let ((code (buffer-substring start end)))
		    (set-buffer "*shell*")
		    (insert code)
		    (comint-send-input)
		    ))
  (select-window curwindow)
	)
 */ 
